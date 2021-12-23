package ec.gob.educacion.rest.encuentro;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.encuentro.dto.PreguntasDTO;
import ec.gob.educacion.service.encuentro.PreguntasService;



/**
 * Rest para el manejo de encuestado
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class PreguntaRest {
	
	@Autowired
	private PreguntasService preguntasService;	
	
	
	/**
	 * Metodo para buscar un respuesta
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarPreguntaPortpeCodigo/{tpeCodigo}/{codGrado}")
	public ResponseEntity<List<PreguntasDTO>> listarPreguntaPortpeCodigo(@PathVariable("tpeCodigo") long tpeCodigo, @PathVariable("codGrado") BigDecimal codGrado){
		List<PreguntasDTO> respuesta = preguntasService.listarPreguntaPortpeCodigo(tpeCodigo, codGrado) ;
		return new ResponseEntity<List<PreguntasDTO>>(respuesta, HttpStatus.OK);
	}

}
