package ec.gob.educacion.rest.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.encuentro.PenSedePen;
import ec.gob.educacion.service.encuentro.PenSedePenService;
import ec.gob.educacion.service.util.Constantes;



@RestController
@RequestMapping("private/")
public class PenSedPenRest {
	
	@Autowired
	private PenSedePenService penSedePenService;	
	
	@GetMapping(value = "sede")
	public ResponseEntity<List<PenSedePen>> listaSede(){
		List<PenSedePen> listaSeda = penSedePenService.listarSede(Constantes.REGISTRO_ACTIVO_NUM);
		
		return new ResponseEntity<List<PenSedePen>>(listaSeda, HttpStatus.OK);
		
	}

}
