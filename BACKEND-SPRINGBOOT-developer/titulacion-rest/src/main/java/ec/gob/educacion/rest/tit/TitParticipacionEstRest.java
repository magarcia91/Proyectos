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
import ec.gob.educacion.model.tit.TitParticipacionEst;
import ec.gob.educacion.model.tit.TitRefrendacion;
import ec.gob.educacion.service.tit.TitParticipacionEstService;
import ec.gob.educacion.service.tit.TitRefrendacionService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TitParticipacionEstRest {
	
	@Autowired
	private TitParticipacionEstService titParticipacionEstService;	
	
	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarParticipacionEst")
	public ResponseGenerico<String> guardarParticipacionEst(@RequestBody TitParticipacionEst titParticipacionEst){
		titParticipacionEstService.registrarParticipacionEst(titParticipacionEst) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoParticipacionEst/{pesCodigo}")
	public ResponseEntity<TitParticipacionEst> buscarPesCodigo(@PathVariable("pesCodigo") Integer pesCodigo){
		TitParticipacionEst listaPesCodigo = titParticipacionEstService.buscarPesCodigo(pesCodigo);
		return new ResponseEntity<TitParticipacionEst>(listaPesCodigo, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarParticipacionEst")
	public ResponseEntity<List<TitParticipacionEst>> listarParticipacionEst(){
		List<TitParticipacionEst> listaParticipacionEst = titParticipacionEstService.listarParticipacionEst();
		return new ResponseEntity<List<TitParticipacionEst>>(listaParticipacionEst, HttpStatus.OK);
	}

}
