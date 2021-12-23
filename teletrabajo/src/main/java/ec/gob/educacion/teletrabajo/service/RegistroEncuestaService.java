package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.EncuestaDTO;
import ec.gob.educacion.teletrabajo.model.TelCatalogo;
import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;
import ec.gob.educacion.teletrabajo.model.TelRegistroEncuesta;

public interface RegistroEncuestaService {

	public List<TelRegistroEncuesta> obtenerEncuestaPorCabecera(Long codCabeceraRegistro, String estado);
	
	public EncuestaDTO generarEncuesta(Long codCabeceraRegistro, Long codigoEncuesta);
	
	public DefaultDTO guardarEncuesta(String token, List<TelRegistroEncuesta> respuestas, TelEncuestaEstado estadoEncuesta, TelCatalogo encuesta);
	
	public boolean existenRespuestasGuardadas(Long codCabeceraRegistro, String estado);
	
	public boolean existenRespuestasGuardadasPorEncuesta(Long codCabeceraRegistro, Long codEncuesta, String estado);

}
