package ec.gob.educacion.rest.asignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.DTO.TipoTituloDTO;
import ec.gob.educacion.service.asignaciones.TipoTituloService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class TipoTituloRest {
	
	@Autowired
	private TipoTituloService tipoTituloService;	

	
	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarTipoTitulo/{codigoIns}/{codRegAniLec}")
	public ResponseEntity<List<TipoTituloDTO>> listarTipoTitulo(@PathVariable("codigoIns") Integer codigoIns , @PathVariable("codRegAniLec") Integer codRegAniLec){
		List<TipoTituloDTO> listarTipoTitulo = tipoTituloService.listarTipoTitulo(codigoIns, codRegAniLec);
		return new ResponseEntity<List<TipoTituloDTO>>(listarTipoTitulo, HttpStatus.OK);
	}

}
