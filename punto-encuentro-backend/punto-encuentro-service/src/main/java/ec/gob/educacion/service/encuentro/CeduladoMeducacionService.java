package ec.gob.educacion.service.encuentro;

import java.math.BigDecimal;
import java.util.List;

import ec.gob.educacion.model.asignaciones.CeduladoMeducacion;

/**
 * Interfaz para CeduladoMeducacion
 * 
 * @author Belen Changoluisa
 *
 */



public interface CeduladoMeducacionService {
	
	/**
	 * Permite buscar una persona
	 * 
	 * @param cedula a buscar
	 * @return lista de una persona
	 * @author Belen Changoluisa
	 */
	
	List<CeduladoMeducacion> buscarCeduladoMeducacion(BigDecimal cedula);

}
