package ec.gob.educacion.rest.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.asignaciones.InsGrado;
import ec.gob.educacion.service.encuentro.GradoService;

/**
 * Rest para el manejo de grados
 * 
 * @author Jorge Quishpe
 *
 */
@RestController
@RequestMapping("private/")
public class GradoRest {
	
	@Autowired
	private GradoService gradoService;	
	
	/**
	 * Metodo para listar grados
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarGradosPorNiveles")
	public ResponseEntity<List<InsGrado>> listarGradosPorNiveles(){
		List<InsGrado> lista = gradoService.listarGradosNiveles();
		return new ResponseEntity<List<InsGrado>>(lista, HttpStatus.OK);
	}

}
