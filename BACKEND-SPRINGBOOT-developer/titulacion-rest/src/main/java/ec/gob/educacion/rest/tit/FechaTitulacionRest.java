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
import ec.gob.educacion.model.tit.TitFechaTitulacion;
import ec.gob.educacion.service.tit.FechaTitulacionService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class FechaTitulacionRest {
	
	@Autowired
	private FechaTitulacionService fechaTitulacionService;	
	
	
	/**
	 * REST para guardar o actualizar encuesta
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarFechaTitulacion")
	public ResponseGenerico<String> guardarFechaTitulacion(@RequestBody TitFechaTitulacion titFechaTitulacion){
		fechaTitulacionService.registrar(titFechaTitulacion) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigo/{ftiCodigo}")
	public ResponseEntity<TitFechaTitulacion> buscarCodigo(@PathVariable("ftiCodigo") long ftiCodigo){
		TitFechaTitulacion lista = fechaTitulacionService.buscarCodigo(ftiCodigo);
		return new ResponseEntity<TitFechaTitulacion>(lista, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listar")
	public ResponseEntity<List<TitFechaTitulacion>> listar(){
		List<TitFechaTitulacion> lista = fechaTitulacionService.listar();
		return new ResponseEntity<List<TitFechaTitulacion>>(lista, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listaRegTipo/{codRegAniLec}/{codTipoEducacion}")
	public ResponseEntity<List<TitFechaTitulacion>> listarCodRegAniLecAndCodTipoEducacion(@PathVariable("codRegAniLec") Integer codRegAniLec,@PathVariable("codTipoEducacion") Integer codTipoEducacion){
		List<TitFechaTitulacion> listaRegTipo = fechaTitulacionService.listarRegionTipo( codRegAniLec, codTipoEducacion);
		return new ResponseEntity<List<TitFechaTitulacion>>(listaRegTipo, HttpStatus.OK);
	}

}
