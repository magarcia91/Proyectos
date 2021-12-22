package ec.gob.educacion.teletrabajo.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelNivelRegistro;
import ec.gob.educacion.teletrabajo.repository.NivelRegistroRepository;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.NivelRegistroService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class NivelRegistroServiceImpl implements NivelRegistroService {	
	
	private static final Logger LOGGER = Logger.getLogger(NivelRegistroServiceImpl.class.getName());

	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;
	@Autowired
	private NivelRegistroRepository nivelRegistroRepository;

	public List<TelNivelRegistro> obtenerNivelesRegistradosPorCabecera(Long codCabeceraRegistro, String estado){
		return nivelRegistroRepository.obtenerNivelesRegistradosPorCabecera(codCabeceraRegistro, estado);
	}
	
	@Transactional
	public DefaultDTO guardarNivelRegistro(String token, List<TelNivelRegistro> niveles) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);			
			Date fechaACtual = new Date();
			Timestamp date = new Timestamp(fechaACtual.getTime());
			//inactivar niveles guardados
			TelCabeceraRegistro cabeceraGuardada = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());
			inactivarNivelesRegistro(nivelRegistroRepository.obtenerNivelesRegistradosPorCabecera(cabeceraGuardada.getCodCabeceraRegistro(), EstadoEnum.ACTIVO.getValor()),date,dto.getIdentificacion());
			//creamos los nuevos niveles
			niveles.stream().forEach(nivel -> {
				nivel.setStsEstado(EstadoEnum.ACTIVO.getValor());
				nivel.setFechaCreacion(date);
				nivel.setUsuarioCreacion(dto.getIdentificacion());
				nivel.setTelCabeceraRegistro(cabeceraGuardada);
				nivelRegistroRepository.save(nivel);
			});					
			result.setCodigoError(Constantes.GENERAL_OK_CODE);
			result.setMensaje(Constantes.GENERAL_MSG_OK);
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
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
