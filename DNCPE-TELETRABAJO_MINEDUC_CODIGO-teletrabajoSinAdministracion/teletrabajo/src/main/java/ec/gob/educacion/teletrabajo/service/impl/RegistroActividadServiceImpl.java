package ec.gob.educacion.teletrabajo.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.ActividadDTO;
import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.SemanaResumenDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.model.TelRegistroActividad;
import ec.gob.educacion.teletrabajo.model.TlSemana;
import ec.gob.educacion.teletrabajo.repository.RegistroActividadRepository;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.RegistroActividadService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class RegistroActividadServiceImpl implements RegistroActividadService {
	
	private static final Logger LOGGER = Logger.getLogger(RegistroActividadServiceImpl.class.getName());

	@Autowired
	private RegistroActividadRepository registroActividadRepository;
	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;

	@Override
	public List<ActividadDTO> findActivities(Long usuario, Long semana) {
		return registroActividadRepository.findActivities(usuario, EstadoEnum.ACTIVO.getValor(), semana);
	}

	@Override
	@Transactional
	public DefaultDTO save(String token, SemanaResumenDTO datos) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);
			TelCabeceraRegistro cabecera = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());
			Date fechaACtual = new Date();
			Timestamp date = new Timestamp(fechaACtual.getTime());
			if (cabecera != null) {
				inactivarActividades(dto.getUserId(), datos.getCodSemana(), dto.getIdentificacion());
				for (ActividadDTO actividad : datos.getActividades()) {

					TelRegistroActividad registro = new TelRegistroActividad(EstadoEnum.ACTIVO.getValor(), cabecera,
							actividad.fromDTO(new TelItemCatalogo()), new TlSemana(datos.getCodSemana()));
					registro.setUsuarioCreacion(dto.getIdentificacion());
					registro.setFechaCreacion(date);
					registroActividadRepository.save(registro);
				}

				result.setCodigoError(Constantes.GENERAL_OK_CODE);
				result.setMensaje(Constantes.GENERAL_MSG_OK);

			} else {
				result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
				result.setMensaje("Lo sentimos, no cuenta con datos registrados");
			}

		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}
	
	@Override
	@Transactional
	public DefaultDTO inactivarActividadesRegistradas(String token, SemanaResumenDTO datos) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);
			TelCabeceraRegistro cabecera = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());
			if (cabecera != null) {
				inactivarActividades(dto.getUserId(), datos.getCodSemana(), dto.getIdentificacion());				
				result.setCodigoError(Constantes.GENERAL_OK_CODE);
				result.setMensaje(Constantes.GENERAL_MSG_OK);

			} else {
				result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
				result.setMensaje("Lo sentimos, no cuenta con datos registrados");
			}

		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}
	
	

	private void inactivarActividades(Long usuario, Long semana, String identificacion) {
		Date fechaActual = new Date();
		Timestamp fecha = new Timestamp(fechaActual.getTime());
		List<TelRegistroActividad> actividades = registroActividadRepository.findActivitiesBySemanaAndUser(usuario,
				EstadoEnum.ACTIVO.getValor(), semana);
		actividades.stream().forEach(a -> {
			a.setStsEstado(EstadoEnum.INACTIVO.getValor());
			a.setUsuarioModifico(identificacion);
			a.setFechaModificacion(fecha);
			registroActividadRepository.save(a);
		});
	}

}
