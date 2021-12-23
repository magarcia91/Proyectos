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

import ec.gob.educacion.encuentro.dto.RefrendacionDTO;
import ec.gob.educacion.model.censo.InsAsignacionCenso;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.model.tit.TitParticipacionEst;
import ec.gob.educacion.model.tit.TitRefrendacion;
import ec.gob.educacion.service.censo.InsAsignacionCensoService;
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
public class TitRefrendacionRest {
	
	@Autowired
	private TitRefrendacionService titRefrendacionService;	
	
	@Autowired
	private InsAsignacionCensoService insAsignacionCensoService;
	
	@Autowired
	private TitParticipacionEstService titParticipacionEstService;
	
	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarRefrendacion")
	public ResponseGenerico<String> guardarRefrendacion(@RequestBody RefrendacionDTO titRefrendacionDTO){

		TitRefrendacion titRefrendacion = new TitRefrendacion();
		
		titRefrendacion.setRefCalifuno(titRefrendacionDTO.getRefCalifuno());
		titRefrendacion.setRefCalifdos(titRefrendacionDTO.getRefCalifdos());
		titRefrendacion.setRefCaliftres(titRefrendacionDTO.getRefCaliftres());
		titRefrendacion.setRefCalifcuatro(titRefrendacionDTO.getRefCalifcuatro());
		titRefrendacion.setRefPromedio(titRefrendacionDTO.getRefPromedio());
		titRefrendacion.setRefEnes(titRefrendacionDTO.getRefEnes());
		titRefrendacion.setRefValuno(titRefrendacionDTO.getRefValuno());
		titRefrendacion.setRefValdos(titRefrendacionDTO.getRefValdos());
		titRefrendacion.setRefValtres(titRefrendacionDTO.getRefValtres());
		titRefrendacion.setRefCalifcuatro(titRefrendacionDTO.getRefCalifcuatro());
		titRefrendacion.setRefValcinco(titRefrendacionDTO.getRefValcinco());
		titRefrendacion.setRefImpresion(titRefrendacionDTO.getRefImpresion());
		titRefrendacion.setRefFechaGrado(titRefrendacionDTO.getRefFechaGrado());		
		titRefrendacion.setRefFechaRefrendacion(titRefrendacionDTO.getRefFechaRefrendacion());		
		
		titRefrendacion.setRefCodigoRef(titRefrendacionDTO.getRefCodigoRef());
		titRefrendacion.setRefPromedioLetras(titRefrendacionDTO.getRefPromedioLetras());	
		
		InsAsignacionCenso insAsignacionCenso = insAsignacionCensoService.buscarCodigoAsignacionCenso(titRefrendacionDTO.getCodigo());		
		titRefrendacion.setInsAsignacionCenso(insAsignacionCenso);
		
		TitParticipacionEst titParticipacionEst = titParticipacionEstService.buscarPesCodigo(titRefrendacionDTO.getPesCodigo());
		titRefrendacion.setTitParticipacionEst(titParticipacionEst);
		titRefrendacionService.registrarRefrendacion(titRefrendacion) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}


	@GetMapping(value = "buscarCodigoRefrendacion/{refCodigo}")
	public ResponseEntity<TitRefrendacion> buscarRefCodigo(@PathVariable("refCodigo") Integer refCodigo){
		TitRefrendacion listaRefCodigo = titRefrendacionService.buscarRefCodigo(refCodigo);
		return new ResponseEntity<TitRefrendacion>(listaRefCodigo, HttpStatus.OK);
	}
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarRefrendacion")
	public ResponseEntity<List<TitRefrendacion>> listarRefrendacion(){
		List<TitRefrendacion> listaModelo = titRefrendacionService.listarRefrendacion();
		return new ResponseEntity<List<TitRefrendacion>>(listaModelo, HttpStatus.OK);
	}

}
