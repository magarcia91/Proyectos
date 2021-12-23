package ec.gob.educacion.rest.asignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.service.asignaciones.AnioLectivoRegimenService;
import ec.gob.educacion.tit.dto.AnioLectivoRegimenDTO;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class AnioLectivoRegimenRest {
	
	@Autowired
	private AnioLectivoRegimenService anioLectivoRegimenService;	


	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarAnioRegimen")
	public ResponseEntity<List<AnioLectivoRegimenDTO>> listarA(){
		List<AnioLectivoRegimenDTO> listarA = anioLectivoRegimenService.listarA();
		return new ResponseEntity<List<AnioLectivoRegimenDTO>>(listarA, HttpStatus.OK);
	}

}
