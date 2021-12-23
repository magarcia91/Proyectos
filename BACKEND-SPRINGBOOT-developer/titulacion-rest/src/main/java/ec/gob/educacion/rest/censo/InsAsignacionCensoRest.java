package ec.gob.educacion.rest.censo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.censo.InsAsignacionCenso;
import ec.gob.educacion.service.censo.InsAsignacionCensoService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class InsAsignacionCensoRest {
	
	@Autowired
	private InsAsignacionCensoService insAsignacionCensoService;	
	

	@GetMapping(value = "buscarCodigoA/{codigo}")
	public ResponseEntity<InsAsignacionCenso> buscarCodigo(@PathVariable("codigo") Integer codigo){
		InsAsignacionCenso listaCenso = insAsignacionCensoService.buscarCodigoAsignacionCenso(codigo);
		return new ResponseEntity<InsAsignacionCenso>(listaCenso, HttpStatus.OK);
	}


}
