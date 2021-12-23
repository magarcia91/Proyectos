package ec.gob.educacion.rest.asignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.DTO.InsJornadaDTO;
import ec.gob.educacion.service.asignaciones.InsJornadaService;



/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class InsJornadaRest {
	
	@Autowired
	private InsJornadaService insJornadaService;	


	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarJornada/{codJornada}/{codInstitucion}")
	public ResponseEntity<List<InsJornadaDTO>> listarJornada(@PathVariable("codJornada") Integer codJornada, @PathVariable("codInstitucion") Integer codInstitucion){
		System.out.println("llega: "+ codJornada);
		List<InsJornadaDTO> listarJornada = insJornadaService.listarJornada(codJornada, codInstitucion);
		
		return new ResponseEntity<List<InsJornadaDTO>>(listarJornada, HttpStatus.OK);
	}

}
