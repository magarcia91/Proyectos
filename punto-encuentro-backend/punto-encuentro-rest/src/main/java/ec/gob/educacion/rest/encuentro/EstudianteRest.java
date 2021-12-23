package ec.gob.educacion.rest.encuentro;

import java.util.Date;

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
import ec.gob.educacion.model.encuentro.PenEstudiante;
import ec.gob.educacion.model.encuentro.PenSedePen;
import ec.gob.educacion.model.enumeraciones.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.rest.util.Utils;
import ec.gob.educacion.service.encuentro.EstudianteService;
import ec.gob.educacion.service.encuentro.PenSedePenService;

/**
 * Rest para el manejo de estudiantes
 * 
 * @author Jorge Quishpe
 *
 */
@RestController
@RequestMapping("private/")
public class EstudianteRest {
	
	@Autowired
	private EstudianteService estudianteService;	
	@Autowired
	private PenSedePenService sedeService;
	
	/**
	 * Metodo para buscar un estudiante
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "buscarEstudiantePorCedula/{estCedula}")
	public ResponseEntity<PenEstudiante> buscarEstudiantePorCedula(@PathVariable("estCedula") String estCedula){
		PenEstudiante estudiante = estudianteService.buscarEstudiantePorCedula(estCedula) ;
		return new ResponseEntity<PenEstudiante>(estudiante, HttpStatus.OK);
	}
	
	/**
	 * Metodo para buscar un estudiante
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "buscarEstudiantePorIdentidad/{estIdentidad}")
	public ResponseEntity<PenEstudiante> buscarEstudiantePorIdentidad(@PathVariable("estIdentidad") String estIdentidad){
		PenEstudiante estudiante = estudianteService.buscarEstudiantePorIdentidad(estIdentidad) ;
		return new ResponseEntity<PenEstudiante>(estudiante, HttpStatus.OK);
	}
	
	/**
	 * REST para guardar o actualizar un estudiante
	 * 
	 * @param estudiante a guardar
	 */
	@PostMapping(path = "guardarEstudiante")
	public ResponseGenerico<String> guardarEstudiante(@RequestBody @Valid EstudianteDTO estudianteDTO) {
		PenEstudiante estudiante = new PenEstudiante();
		estudiante.setEstCodigo(estudianteDTO.getEstCodigo());
		estudiante.setEstCedula(estudianteDTO.getEstCedula());
		estudiante.setEstComidas(estudianteDTO.getEstComidas());
		estudiante.setEstDiscapacidad(estudianteDTO.getEstDiscapacidad());
		estudiante.setEstEstado(EstadoEnum.ACTIVO.getEstado());
		estudiante.setEstFechaCreacion(new Date());
		estudiante.setEstFechaNacimiento(estudianteDTO.getEstFechaNacimiento());
		estudiante.setEstIdentidad(estudianteDTO.getEstIdentidad());
		estudiante.setEstMatriculado(estudianteDTO.getEstMatriculado());
		estudiante.setEstMovil(estudianteDTO.getEstMovil());
		estudiante.setEstNombre(estudianteDTO.getEstNombre());
		estudiante.setEstPeso(estudianteDTO.getEstPeso());
		estudiante.setEstTalla(estudianteDTO.getEstTalla());
		estudiante.setEstVisitasMedicas(estudianteDTO.getEstVisitasMedicas());
		estudiante.setGraCodigo(estudianteDTO.getGraCodigo());
		estudiante.setPaiCodigo(estudianteDTO.getPaiCodigo());
		estudiante.setUsuCodigo(estudianteDTO.getUsuCodigo());
		estudiante.setEstGenero(estudianteDTO.getEstGenero());
		
		estudiante.setEstMovilidadHumana(estudianteDTO.getEstMovilidadHumana());
		estudiante.setNacPais(estudianteDTO.getNacPais());
		estudiante.setEstDireccion(estudianteDTO.getEstDireccion());
		estudiante.setEstConectividad(estudianteDTO.getEstConectividad());
		estudiante.setEstCambioVivenda(estudianteDTO.getEstCambioVivenda());
		estudiante.setEstIeCerca(estudianteDTO.getEstIeCerca());
		
		PenSedePen sede=sedeService.buscarSedePorCodigo(estudianteDTO.getCodigoSede());
		estudiante.setPenSedePen(sede);
		estudiante=estudianteService.guardar(estudiante);
		estudiante.setEstIdentidad(Utils.generarNumeroIdentididad(estudiante.getEstCodigo(), sede.getSedCodigo()));
		estudianteService.guardar(estudiante);
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setId(estudiante.getEstCodigo());
		response.setCodigoRespuesta(estudiante.getEstIdentidad());
		response.setMensaje("OK");
		return response;
	}
	
	/**
	 * REST para guardar o actualizar un estudiante excel
	 * 
	 * @param estudiante a guardar
	 */
	@PostMapping(path = "guardarEstudianteExcel")
	public ResponseGenerico<String> guardarEstudianteExcel(@RequestBody @Valid EstudianteDTO estudianteDTO) {
		PenEstudiante estudiante = new PenEstudiante();
		estudiante.setEstCodigo(estudianteDTO.getEstCodigo());
		estudiante.setEstCedula(estudianteDTO.getEstCedula());
		estudiante.setEstComidas(estudianteDTO.getEstComidas());
		estudiante.setEstDiscapacidad(estudianteDTO.getEstDiscapacidad());
		estudiante.setEstEstado(EstadoEnum.ACTIVO.getEstado());
		estudiante.setEstFechaCreacion(new Date());
		estudiante.setEstFechaNacimiento(estudianteDTO.getEstFechaNacimiento());
		
		estudiante.setEstIdentidad(estudianteDTO.getEstIdentidad());
		estudiante.setEstMatriculado(estudianteDTO.getEstMatriculado());
		estudiante.setEstMovil(estudianteDTO.getEstMovil());
		estudiante.setEstNombre(estudianteDTO.getEstNombre());
		estudiante.setEstPeso(estudianteDTO.getEstPeso());
		estudiante.setEstTalla(estudianteDTO.getEstTalla());
		estudiante.setEstVisitasMedicas(estudianteDTO.getEstVisitasMedicas());
		estudiante.setGraCodigo(estudianteDTO.getGraCodigo());
		estudiante.setPaiCodigo(estudianteDTO.getPaiCodigo());
		estudiante.setUsuCodigo(estudianteDTO.getUsuCodigo());
		estudiante.setEstGenero(estudianteDTO.getEstGenero());
		
		estudiante.setEstMovilidadHumana(estudianteDTO.getEstMovilidadHumana());
		estudiante.setNacPais(estudianteDTO.getNacPais());
		estudiante.setEstDireccion(estudianteDTO.getEstDireccion());
		estudiante.setEstConectividad(estudianteDTO.getEstConectividad());
		estudiante.setEstCambioVivenda(estudianteDTO.getEstCambioVivenda());
		estudiante.setEstIeCerca(estudianteDTO.getEstIeCerca());
		
		PenSedePen sede=sedeService.buscarSedePorCodigo(estudianteDTO.getCodigoSede());
		estudiante.setPenSedePen(sede);
		estudianteService.guardar(estudiante);
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setId(estudiante.getEstCodigo());
		response.setCodigoRespuesta(estudiante.getEstIdentidad());
		response.setMensaje("OK");
		return response;
		
	}

}
