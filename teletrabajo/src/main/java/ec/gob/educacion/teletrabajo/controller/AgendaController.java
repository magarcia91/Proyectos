package ec.gob.educacion.teletrabajo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.gob.educacion.teletrabajo.DTO.ActividadDTO;
import ec.gob.educacion.teletrabajo.DTO.CabeceraRegistroDTO;
import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.SemanaResumenDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.CatalogoEnum;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.repository.EncuestaOfertaRepository;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.ItemCatalogoService;
import ec.gob.educacion.teletrabajo.service.RegistroActividadService;
import ec.gob.educacion.teletrabajo.service.SemanaService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Controller
@RequestMapping("agenda")
public class AgendaController {
	

	@Autowired
	private SemanaService semanaService;
	@Autowired
	private RegistroActividadService registroActividadService;
	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;
	@Autowired
	private ItemCatalogoService itemCatalogoService;
	@Autowired
	private EncuestaOfertaRepository encuestaOfertaRepository;

	@GetMapping("/semana")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<SemanaResumenDTO> findAllSemana(@RequestHeader("Authorization") String token) {
		List<SemanaResumenDTO> result = new ArrayList<SemanaResumenDTO>();
		try {
			TokenDTO dto = Util.getInfoToken(token);
			result = semanaService.findAll();
			for (SemanaResumenDTO semana : result) {
				semana.setActividades(registroActividadService.findActivities(dto.getUserId(), semana.getCodSemana()));
				if(semana.getActividades() != null && semana.getActividades().size()==1) {
					ActividadDTO actividad = semana.getActividades().get(0);
					semana.setEsTrabajoPresencial(actividad.getNemonico()!=null && actividad.getNemonico().equals(Constantes.NEMONICO_ACTIVIDAD_TELETRABAJO));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping("/actividades")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<ActividadDTO> findActivitiesByFunction(@RequestHeader("Authorization") String token) {
		List<ActividadDTO> result = new ArrayList<ActividadDTO>();
		try {
			TokenDTO dto = Util.getInfoToken(token);
			TelCabeceraRegistro cabecera = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());
			if (cabecera != null) {
				Long codigo = null;
				if(cabecera.getTelCargo() != null) {
					codigo = cabecera.getTelCargo().getCodItemCatalogo();
				} else {
					codigo = cabecera.getTelOfertaEducativa().getCodItemCatalogo();
				}
				List<TelItemCatalogo> actividades = itemCatalogoService.listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(CatalogoEnum.ACTIVIDADES.getNemonico(),
						codigo, EstadoEnum.ACTIVO.getValor());
				actividades.stream().forEach(a -> {
					result.add(new ActividadDTO(a));
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO save(@RequestBody SemanaResumenDTO datos, @RequestHeader("Authorization") String token) {
		return registroActividadService.save(token, datos);
	}
	
	@PostMapping("/guardarTrabajoPresencial")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO guardarTrabajoPresencial(@RequestBody SemanaResumenDTO datos, @RequestHeader("Authorization") String token) {
		DefaultDTO result = new DefaultDTO();
		TelItemCatalogo actividadTrabajoPresencial = itemCatalogoService.obtenerPorNemonico(Constantes.NEMONICO_ACTIVIDAD_TELETRABAJO, EstadoEnum.ACTIVO.getValor());
		if(actividadTrabajoPresencial!=null) {
			List<ActividadDTO> actividades = new ArrayList<>();
			actividades.add(new ActividadDTO(actividadTrabajoPresencial.getCodItemCatalogo(), actividadTrabajoPresencial.getNombre()));
			datos.setActividades(actividades);
			result = registroActividadService.save(token, datos);
		}else {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje("No existe una actividad de trabajo presencial.");
		}
		return result;
	}
	
	@PostMapping("/inactivarActividades")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO inactivarActividades(@RequestBody SemanaResumenDTO datos, @RequestHeader("Authorization") String token) {
		return registroActividadService.inactivarActividadesRegistradas(token, datos);
	}

	@GetMapping("/cabecera")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public CabeceraRegistroDTO findCabecera(@RequestHeader("Authorization") String token) {
		CabeceraRegistroDTO result = new CabeceraRegistroDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);
			TelCabeceraRegistro cabecera = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());			
			if (cabecera != null && cabecera.getTelOfertaEducativa() != null) {							
				long totalEncuestasResponder = encuestaOfertaRepository.contarEncuestasHabilitadas(cabecera.getTelCargo()!=null?cabecera.getTelCargo().getCodItemCatalogo():cabecera.getTelOfertaEducativa().getCodItemCatalogo(), EstadoEnum.ACTIVO.getValor());
				result = new CabeceraRegistroDTO(cabecera.getTelOfertaEducativa() != null ? cabecera.getTelOfertaEducativa().getNombre() : "No registra",
						cabecera.getTelCargo() != null ? cabecera.getTelCargo().getNombre(): "No registra", cabecera.getTelInsEducativa() != null ? cabecera.getTelInsEducativa().getNombre(): "No registra",
						cabecera.getTelRegimen() != null ? cabecera.getTelRegimen().getNombre(): "No registra",totalEncuestasResponder>0, cabecera.getCodCabeceraRegistro());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
