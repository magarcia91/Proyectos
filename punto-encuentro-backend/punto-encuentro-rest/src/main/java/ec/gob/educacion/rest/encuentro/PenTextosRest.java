package ec.gob.educacion.rest.encuentro;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.encuentro.dto.EstudianteDTO;
import ec.gob.educacion.model.asignaciones.InsGrado;
import ec.gob.educacion.model.asignaciones.PenTextos;
import ec.gob.educacion.model.encuentro.PenEstudiante;
import ec.gob.educacion.model.encuentro.PenSedePen;
import ec.gob.educacion.model.enumeraciones.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.rest.util.Utils;
import ec.gob.educacion.service.encuentro.EstudianteService;
import ec.gob.educacion.service.encuentro.PenSedePenService;
import ec.gob.educacion.service.encuentro.PenTextosService;

/**
 * Rest para el manejo de textos
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class PenTextosRest {
	
	@Autowired
	private PenTextosService penTextosService;	

	
	/**
	 * Metodo para buscar un texto por grado
	 * 
	 * @return objeto response
	 */

	@GetMapping(value = "buscarTextoPorGrado/{graCodigo}")
	public ResponseEntity<List<PenTextos>> listarTextoPorGrado(@PathVariable("graCodigo") Integer graCodigo){
		List<PenTextos> lista = penTextosService.buscarTextoPorGrado(graCodigo);
		return new ResponseEntity<List<PenTextos>>(lista, HttpStatus.OK);
	}
	
	
}
