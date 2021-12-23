package ec.gob.educacion.rest.tit;

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

import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.model.tit.TitCargo;
import ec.gob.educacion.service.tit.TitCargoService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TitCargoRest {
	
	@Autowired
	private TitCargoService titCargoService;	
	
	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarCargo")
	public ResponseGenerico<String> guardarCargo(@RequestBody TitCargo titCargo){
		titCargoService.registrarCargo(titCargo) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoCargo/{carCodigo}")
	public ResponseEntity<TitCargo> buscarCarCodigo(@PathVariable("carCodigo") Integer carCodigo){
		TitCargo listaParametro = titCargoService.buscarCarCodigo(carCodigo);
		return new ResponseEntity<TitCargo>(listaParametro, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarCargo")
	public ResponseEntity<List<TitCargo>> listarCargo(){
		List<TitCargo> listaCargo = titCargoService.listarCargo();
		return new ResponseEntity<List<TitCargo>>(listaCargo, HttpStatus.OK);
	}

}
