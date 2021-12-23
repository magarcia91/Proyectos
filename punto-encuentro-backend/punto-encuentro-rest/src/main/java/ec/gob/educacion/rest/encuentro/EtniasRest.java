package ec.gob.educacion.rest.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.asignaciones.InsEtnia;
import ec.gob.educacion.service.encuentro.EtniasService;


@RestController
@RequestMapping("private/")
public class EtniasRest {
	
	@Autowired
	private EtniasService etniasService;	
	
	@GetMapping(value = "etnias")
	public ResponseEntity<List<InsEtnia>> buscarEtnias(){
		List<InsEtnia> lista = etniasService.listarEtnias();
		
		return new ResponseEntity<List<InsEtnia>>(lista, HttpStatus.OK);
		
	}

}
