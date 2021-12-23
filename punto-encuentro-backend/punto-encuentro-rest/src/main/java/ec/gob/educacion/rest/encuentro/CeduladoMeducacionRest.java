package ec.gob.educacion.rest.encuentro;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.asignaciones.CeduladoMeducacion;
import ec.gob.educacion.service.encuentro.CeduladoMeducacionService;





@RestController
@RequestMapping("private/")
public class CeduladoMeducacionRest {
	
	@Autowired
	private CeduladoMeducacionService ceduladoMeducacionService;	
	
	@GetMapping(value = "buscarPorCedula/{cedula}")
	public ResponseEntity<List<CeduladoMeducacion>> buscarCeduladoMeducacion(@PathVariable("cedula") BigDecimal cedula){
		List<CeduladoMeducacion> lista = ceduladoMeducacionService.buscarCeduladoMeducacion(cedula);
		return new ResponseEntity<List<CeduladoMeducacion>>(lista, HttpStatus.OK);
	}

}
