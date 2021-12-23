package ec.gob.educacion.teletrabajo.service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;

public interface CabeceraRegistroService {

	TelCabeceraRegistro findCabeceraByUser(Long usuario);
	public TelCabeceraRegistro obtenerCabeceraRegistroUsuario(String identificacion, String estado);
	
	public DefaultDTO guardarCabeceraRegistro(String token, TelCabeceraRegistro cabecera);

}
