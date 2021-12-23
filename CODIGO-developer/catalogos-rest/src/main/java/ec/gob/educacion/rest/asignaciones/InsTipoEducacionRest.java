package ec.gob.educacion.rest.asignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.asignaciones.InsTipoEducacion;
import ec.gob.educacion.service.asignaciones.InsTipoEducacionService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class InsTipoEducacionRest {
	
	@Autowired
	private InsTipoEducacionService insTipoEducacionService;	


	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarTipoEducacion")
	public ResponseEntity<List<InsTipoEducacion>> listarA(){
		List<InsTipoEducacion> listarTipo = insTipoEducacionService.listarTipo();
		return new ResponseEntity<List<InsTipoEducacion>>(listarTipo, HttpStatus.OK);
	}

}
