package ec.gob.educacion.teletrabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.EncuestaDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelCatalogo;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.CatalogoService;
import ec.gob.educacion.teletrabajo.service.RegistroEncuestaService;

@Controller
@RequestMapping("encuesta")
public class EncuestaController {

	
	@Autowired
	private RegistroEncuestaService registroEncuestaService;
	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;
	@Autowired
	private CatalogoService catalogoService;

	
	
	@GetMapping(value = "/recuperarEncuesta")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(DocenteController.ItemCatalogoView.class)
	public EncuestaDTO recuperarEncuestaCompleta(@Param("identificacion") String identificacion, @Param("codigoEncuesta") Long codigoEncuesta) {
		TelCabeceraRegistro cabeceraDocente = cabeceraRegistroService.obtenerCabeceraRegistroUsuario(identificacion, EstadoEnum.ACTIVO.getValor());
		return registroEncuestaService.generarEncuesta(cabeceraDocente.getCodCabeceraRegistro(), codigoEncuesta);
	}
	
	@GetMapping(value = "/validarExistenRespuestas")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public String existenRespuestasGuardadas(@Param("codigoCabeceraRegistro") Long codigoCabeceraRegistro){		
	    boolean existe = registroEncuestaService.existenRespuestasGuardadas(codigoCabeceraRegistro, EstadoEnum.ACTIVO.getValor());
	    return existe? "{\"existenRespuestasGuardadas\":true}":"{\"existenRespuestasGuardadas\":false}";
	}
	
	
	@PostMapping(value = "/salvarRespuestas")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO guardarrespuestas(@RequestBody EncuestaDTO encuestaRespuestas, @RequestHeader("Authorization") String token) {		
		return registroEncuestaService.guardarEncuesta(token, encuestaRespuestas.getRespuestas(), encuestaRespuestas.getEstadoEncuesta(), encuestaRespuestas.getEncuesta());
	}
	
	
	@GetMapping(value = "/listarEncuestasHabilitadas")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<TelCatalogo> listarEncuestasHabilitadas(@Param("identificacion") String identificacion) {
		TelCabeceraRegistro cabecera = cabeceraRegistroService.obtenerCabeceraRegistroUsuario(identificacion, EstadoEnum.ACTIVO.getValor());
		return catalogoService.listarEncuestasPorUsuario(cabecera.getCodCabeceraRegistro(), cabecera.getTelCargo()!=null?cabecera.getTelCargo().getCodItemCatalogo():cabecera.getTelOfertaEducativa().getCodItemCatalogo(), EstadoEnum.ACTIVO.getValor());
	}

}
