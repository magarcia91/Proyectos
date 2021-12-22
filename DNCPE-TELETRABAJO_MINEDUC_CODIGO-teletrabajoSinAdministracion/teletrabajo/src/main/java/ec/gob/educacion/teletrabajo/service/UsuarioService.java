package ec.gob.educacion.teletrabajo.service;

import ec.gob.educacion.teletrabajo.DTO.ResponseLoginDTO;
import ec.gob.educacion.teletrabajo.model.TelUsuario;

public interface UsuarioService {

	ResponseLoginDTO login(String identificacion, String password);
	
	public TelUsuario obtenerPorIdentificacion(String identificacion);

}
