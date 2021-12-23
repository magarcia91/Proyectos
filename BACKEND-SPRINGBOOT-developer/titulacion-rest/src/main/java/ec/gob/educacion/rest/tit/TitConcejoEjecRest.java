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

import ec.gob.educacion.encuentro.dto.ConsejoEjecuDTO;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.model.tit.TitCargo;
import ec.gob.educacion.model.tit.TitConsejoEjec;
import ec.gob.educacion.service.tit.TitCargoService;
import ec.gob.educacion.service.tit.TitConsejoEjecService;





/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TitConcejoEjecRest {
	
	@Autowired
	private TitConsejoEjecService titConsejoEjecService;	
	
	@Autowired
	private TitCargoService titCargoService ;
	
	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarConsejoEjec")
	public ResponseGenerico<String> guardarConsejoEjec(@RequestBody ConsejoEjecuDTO consejoEjecuDTO){
		TitConsejoEjec titConsejoEjec = new TitConsejoEjec();
		
		titConsejoEjec.setAutCedula(consejoEjecuDTO.getAutCedula());
		titConsejoEjec.setAutNombre(consejoEjecuDTO.getAutNombre());
		titConsejoEjec.setCodInstitucion(consejoEjecuDTO.getCodInstitucion());
		titConsejoEjec.setCodAnioLectivo(consejoEjecuDTO.getCodAnioLectivo());
		titConsejoEjec.setCarNombreTransient(consejoEjecuDTO.getCarNombreTransient());
		
		TitCargo titCargo = titCargoService.buscarCarCodigo(consejoEjecuDTO.getCodigoTitCargo());		
		titConsejoEjec.setTitCargo(titCargo);	
		
		
		titConsejoEjecService.registrar(titConsejoEjec) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoConsejo/{autCodigo}")
	public ResponseEntity<TitConsejoEjec> buscarAutCodigo(@PathVariable("autCodigo") Integer autCodigo){
		TitConsejoEjec listaCodigoConsejo = titConsejoEjecService.buscarAutCodigo(autCodigo);
		return new ResponseEntity<TitConsejoEjec>(listaCodigoConsejo, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarConsejoEjec")
	public ResponseEntity<List<TitConsejoEjec>> listarConsejoEjec(){
		List<TitConsejoEjec> listaConsejo = titConsejoEjecService.listar();
		return new ResponseEntity<List<TitConsejoEjec>>(listaConsejo, HttpStatus.OK);
	}

}
