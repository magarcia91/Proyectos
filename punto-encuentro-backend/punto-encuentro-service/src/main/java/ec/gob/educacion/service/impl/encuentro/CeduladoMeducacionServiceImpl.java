package ec.gob.educacion.service.impl.encuentro;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.asignaciones.CeduladoMeducacion;
import ec.gob.educacion.repository.encuentro.*;
import ec.gob.educacion.service.encuentro.*;

/**
 * Implementación de los servicios para CeduladoMeducacion
 * 
 * @author Belen Changoluisa
 *
 */

@Service
public class CeduladoMeducacionServiceImpl implements CeduladoMeducacionService{
	@Autowired
	private CeduladoMeducacionRepository ceduladoMeducacionRepository;
	
	@Override
	public List<CeduladoMeducacion> buscarCeduladoMeducacion(BigDecimal cedula) {
	
		
		return ceduladoMeducacionRepository.findByCedula(cedula);
	
	}
	
	

}
