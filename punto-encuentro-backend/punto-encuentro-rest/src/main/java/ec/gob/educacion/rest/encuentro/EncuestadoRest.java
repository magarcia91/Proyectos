package ec.gob.educacion.rest.encuentro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.encuentro.dto.EncuestadoDTO;
import ec.gob.educacion.repository.encuentro.EncuestadoRepository;



/**
 * Rest para el manejo de encuestado
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class EncuestadoRest {
	
	@Autowired
	private EncuestadoRepository encuestadoRepository;	
	
	
	/**
	 * Metodo para buscar un encuetado
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "buscarEncuestadoPorCedula/{estCedula}")
	public ResponseEntity<EncuestadoDTO> buscarEncuestadoPorCedula(@PathVariable("estCedula") String estCedula){
		EncuestadoDTO encuestado = encuestadoRepository.findByEncuestadoDTO(estCedula) ;
		return new ResponseEntity<EncuestadoDTO>(encuestado, HttpStatus.OK);
	}
	
	/**
	 * Metodo para buscar un encuentro
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "buscarEncuestadoPorCodigo/{estCodigo}")
	public ResponseEntity<EncuestadoDTO> buscarEstudiantePorIdentidad(@PathVariable("estCodigo") long estCodigo){
		EncuestadoDTO encuestadoCodigo = encuestadoRepository.findByEncuestadoCodigo(estCodigo) ;
		return new ResponseEntity<EncuestadoDTO>(encuestadoCodigo, HttpStatus.OK);
	}
	


}
