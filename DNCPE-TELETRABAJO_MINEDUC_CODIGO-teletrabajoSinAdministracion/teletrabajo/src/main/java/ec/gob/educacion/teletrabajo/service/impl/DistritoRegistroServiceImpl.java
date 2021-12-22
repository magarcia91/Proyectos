package ec.gob.educacion.teletrabajo.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelDistritoRegistro;
import ec.gob.educacion.teletrabajo.model.TelNivelRegistro;
import ec.gob.educacion.teletrabajo.repository.DistritoRegistroRepository;
import ec.gob.educacion.teletrabajo.repository.NivelRegistroRepository;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.DistritoRegistroService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class DistritoRegistroServiceImpl implements DistritoRegistroService {
	
	private static final Logger LOGGER = Logger.getLogger(DistritoRegistroServiceImpl.class.getName());

	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;
	@Autowired
	private DistritoRegistroRepository distritoRegistroRepository;
	@Autowired
	private NivelRegistroRepository nivelRegistroRepository;

	public List<TelDistritoRegistro> obtenerDistritosRegistradosPorCabecera(Long codCabeceraRegistro, String estado){
		return distritoRegistroRepository.obtenerDistritosRegistradosPorCabecera(codCabeceraRegistro, estado);
	}
	
	@Transactional
	public DefaultDTO guardarDistritoRegistro(String token, List<TelDistritoRegistro> distritos) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);			
			Date fechaACtual = new Date();
			Timestamp date = new Timestamp(fechaACtual.getTime());
			TelCabeceraRegistro cabeceraGuardada = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());
			List<TelDistritoRegistro> distritosGuardados = distritoRegistroRepository.obtenerDistritosRegistradosPorCabecera(cabeceraGuardada.getCodCabeceraRegistro(), EstadoEnum.ACTIVO.getValor());
			//filtrar distritos
			List<TelDistritoRegistro> distritosInactivar = distritosGuardados.stream().filter(guardado -> (distritos.stream().filter(nuevo -> nuevo.getTelDistrito().getCodDistrito()==guardado.getTelDistrito().getCodDistrito()).count())<1).collect(Collectors.toList());
			List<TelDistritoRegistro> distritosCrear = distritos.stream().filter(guardado -> (distritosGuardados.stream().filter(nuevo -> nuevo.getTelDistrito().getCodDistrito()==guardado.getTelDistrito().getCodDistrito()).count())<1).collect(Collectors.toList());		
			//inactivar niveles guardados
			inactivarNivelesRegistro(nivelRegistroRepository.obtenerNivelesRegistradosPorCabecera(cabeceraGuardada.getCodCabeceraRegistro(), EstadoEnum.ACTIVO.getValor()),date,dto.getIdentificacion());
			inactivarDistritosRegistro(distritosInactivar,date,dto.getIdentificacion());
			//creamos los nuevos distritos
			crearDistritosRegistro(distritosCrear,date,dto.getIdentificacion(),cabeceraGuardada);					
			result.setCodigoError(Constantes.GENERAL_OK_CODE);
			result.setMensaje(Constantes.GENERAL_MSG_OK);
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}
	
	private void inactivarDistritosRegistro(List<TelDistritoRegistro> distritosInactivar, Timestamp date, String identificacionUsuario) {
		distritosInactivar.stream().forEach(distrito->{
			distrito.setStsEstado(EstadoEnum.INACTIVO.getValor());
			distrito.setFechaModificacion(date);
			distrito.setUsuarioModifico(identificacionUsuario);
			distritoRegistroRepository.save(distrito);
		});
	}
	
	private void crearDistritosRegistro(List<TelDistritoRegistro> distritos, Timestamp date, String identificacionUsuario, TelCabeceraRegistro cabeceraGuardada) {
		distritos.stream().forEach(distrito -> {
			distrito.setStsEstado(EstadoEnum.ACTIVO.getValor());
			distrito.setFechaCreacion(date);
			distrito.setUsuarioCreacion(identificacionUsuario);
			distrito.setTelCabeceraRegistro(cabeceraGuardada);
			distritoRegistroRepository.save(distrito);
		});
	}
	
	private void inactivarNivelesRegistro(List<TelNivelRegistro> nivelesInactivar, Timestamp date, String identificacionUsuario) {
		nivelesInactivar.stream().forEach(nivel->{
			nivel.setStsEstado(EstadoEnum.INACTIVO.getValor());
			nivel.setFechaModificacion(date);
			nivel.setUsuarioModifico(identificacionUsuario);
			nivelRegistroRepository.save(nivel);
		});
	}
	
}
