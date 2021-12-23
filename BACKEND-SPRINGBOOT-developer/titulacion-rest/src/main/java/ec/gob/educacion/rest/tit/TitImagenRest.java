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
import ec.gob.educacion.model.tit.TitImagen;
import ec.gob.educacion.service.tit.TitImagenService;

/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TitImagenRest {
	
	@Autowired
	private TitImagenService titImagenService;	
	
	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarImagen")
	public ResponseGenerico<String> guardarImagen(@RequestBody TitImagen titImagen){
		titImagenService.registrarImagen(titImagen) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoImagen/{imgCodigo}")
	public ResponseEntity<TitImagen> buscarImgCodigo(@PathVariable("imgCodigo") Integer imgCodigo){
		TitImagen listaImgCodigo = titImagenService.buscarImgCodigo(imgCodigo);
		return new ResponseEntity<TitImagen>(listaImgCodigo, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarImagen")
	public ResponseEntity<List<TitImagen>> listarImagen(){
		List<TitImagen> listaImagen = titImagenService.listarImagen();
		return new ResponseEntity<List<TitImagen>>(listaImagen, HttpStatus.OK);
	}

}
