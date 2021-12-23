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
import ec.gob.educacion.model.tit.TitParametro;
import ec.gob.educacion.service.tit.TitParametroService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TitParametroRest {
	
	@Autowired
	private TitParametroService titParametroService;	
	
	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarParametro")
	public ResponseGenerico<String> guardarParametro(@RequestBody TitParametro titParametro){
		titParametroService.registrar(titParametro) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoParametro/{codigo}")
	public ResponseEntity<TitParametro> buscarMcaCodigo(@PathVariable("codigo") Integer codigo){
		TitParametro listaParametro = titParametroService.buscarCodigo(codigo);
		return new ResponseEntity<TitParametro>(listaParametro, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarParametro")
	public ResponseEntity<List<TitParametro>> listarParametro(){
		List<TitParametro> listaModelo = titParametroService.listar();
		return new ResponseEntity<List<TitParametro>>(listaModelo, HttpStatus.OK);
	}

}
