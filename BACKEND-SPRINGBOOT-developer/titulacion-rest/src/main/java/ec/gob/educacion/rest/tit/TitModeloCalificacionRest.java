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
import ec.gob.educacion.model.tit.TitModeloCalificacion;
import ec.gob.educacion.service.tit.TitModeloCalificacionService;

/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TitModeloCalificacionRest {
	
	@Autowired
	private TitModeloCalificacionService titModeloCalificacionService;	
	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarModeloCalificacion")
	public ResponseGenerico<String> guardarModeloCalificacion(@RequestBody TitModeloCalificacion titModeloCalificacion){
		titModeloCalificacionService.registrar(titModeloCalificacion) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoModelo/{mcaCodigo}")
	public ResponseEntity<TitModeloCalificacion> buscarMcaCodigo(@PathVariable("mcaCodigo") Integer mcaCodigo){
		TitModeloCalificacion lista = titModeloCalificacionService.buscarMcaCodigo(mcaCodigo);
		return new ResponseEntity<TitModeloCalificacion>(lista, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarModelo")
	public ResponseEntity<List<TitModeloCalificacion>> listar(){
		List<TitModeloCalificacion> listaModelo = titModeloCalificacionService.listar();
		return new ResponseEntity<List<TitModeloCalificacion>>(listaModelo, HttpStatus.OK);
	}

}
