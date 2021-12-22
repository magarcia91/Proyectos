package ec.gob.educacion.teletrabajo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.model.TelClaveUsuario;
import ec.gob.educacion.teletrabajo.service.ClaveUsuarioService;

@Controller
@RequestMapping("clave")
public class ClaveController {

	@Autowired
	private ClaveUsuarioService claveUsuarioService;
	
	
	
	@PostMapping(value = "/guardarClave")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO salvarClave(@RequestBody TelClaveUsuario claveUsuario, @RequestHeader("Authorization") String token){		
	    return claveUsuarioService.guardarClave(token, claveUsuario);
	}	
}
