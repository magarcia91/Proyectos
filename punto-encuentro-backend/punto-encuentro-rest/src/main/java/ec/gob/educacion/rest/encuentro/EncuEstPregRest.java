package ec.gob.educacion.rest.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.encuentro.dto.EncuEstPregDTO;
import ec.gob.educacion.model.encuentro.PenTipoPregunta;
import ec.gob.educacion.service.encuentro.EncEstPregService;

/**
 * Rest para el manejo de encuestado
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class EncuEstPregRest {
	
	@Autowired
	private EncEstPregService encEstPregService;	
	
	
	/**
	 * Metodo para buscar un respuesta
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarEstudiantePreguntaEncuesta/{penTipoPregunta}/{estCodigo}")
	public ResponseEntity<List<EncuEstPregDTO>> listarEstudianteEncuentaPregunta(@PathVariable("penTipoPregunta") long penTipoPregunta, @PathVariable("estCodigo") long estCodigo){
		List<EncuEstPregDTO> respuesta = encEstPregService.listarEstudianteEncuentaPregunta(penTipoPregunta, estCodigo) ;
		return new ResponseEntity<List<EncuEstPregDTO>>(respuesta, HttpStatus.OK);
	}

}
