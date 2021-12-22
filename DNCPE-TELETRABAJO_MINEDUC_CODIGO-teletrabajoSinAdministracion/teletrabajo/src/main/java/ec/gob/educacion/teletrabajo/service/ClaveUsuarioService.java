package ec.gob.educacion.teletrabajo.service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.RecuperarClaveDTO;
import ec.gob.educacion.teletrabajo.model.TelClaveUsuario;

public interface ClaveUsuarioService {

	
	public DefaultDTO guardarClave(String token, TelClaveUsuario claveUsuario);
	
	public DefaultDTO recuperarClave(RecuperarClaveDTO recuperar);
	
	public DefaultDTO recuperarCorreo(RecuperarClaveDTO recuperar);

}
