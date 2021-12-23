package ec.gob.educacion.rest.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.asignaciones.InsPais;
import ec.gob.educacion.service.encuentro.NacionalidadService;


@RestController
@RequestMapping("private/")
public class NacionalidaRest {
	
	@Autowired
	private NacionalidadService nacionalidadService;	
	
	@GetMapping(value = "nacionalidad")
	public ResponseEntity<List<InsPais>> buscarNacionalidad(){
		List<InsPais> lista = nacionalidadService.listarNacionalidad();
		
		return new ResponseEntity<List<InsPais>>(lista, HttpStatus.OK);
		
	}

}
