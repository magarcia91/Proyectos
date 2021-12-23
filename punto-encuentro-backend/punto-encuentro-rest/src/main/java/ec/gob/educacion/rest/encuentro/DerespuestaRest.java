package ec.gob.educacion.rest.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.encuentro.dto.DerespuestasDTO;
import ec.gob.educacion.service.encuentro.DerespuestaService;



/**
 * Rest para el manejo de encuestado
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class DerespuestaRest {
	
	@Autowired
	private DerespuestaService derespuestaService;	
	
	
	/**
	 * Metodo para buscar un respuesta
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarPregunta/{preCodigo}")
	public ResponseEntity<List<DerespuestasDTO>> listarPregunta(@PathVariable("preCodigo") long preCodigo){
		List<DerespuestasDTO> respuesta = derespuestaService.listarDerespuesta(preCodigo) ;
		return new ResponseEntity<List<DerespuestasDTO>>(respuesta, HttpStatus.OK);
	}

}
