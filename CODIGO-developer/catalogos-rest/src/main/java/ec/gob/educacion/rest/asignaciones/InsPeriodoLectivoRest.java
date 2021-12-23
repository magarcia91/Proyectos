package ec.gob.educacion.rest.asignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.DTO.Ins_peridoLectivoDTO;
import ec.gob.educacion.service.asignaciones.InsPeriodoLectivoService;


/**
 * Rest para el manejo de transacccion
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class InsPeriodoLectivoRest {
	
	@Autowired
	private InsPeriodoLectivoService insPeriodoLectivoService;	


	/**
	 * Metodo para listar 
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "listarAnioRegimen/{CodigoIns}")
	public ResponseEntity<List<Ins_peridoLectivoDTO>> listarPeriodoLectivo(@PathVariable("CodigoIns") Integer CodigoIns){
		List<Ins_peridoLectivoDTO> listarPeriodo = insPeriodoLectivoService.listarPeriodoLectivoIns(CodigoIns);
		return new ResponseEntity<List<Ins_peridoLectivoDTO>>(listarPeriodo, HttpStatus.OK);
	}

}
