package ec.gob.educacion.service.encuentro;

import java.util.List;

import ec.gob.educacion.model.asignaciones.InsEtnia;

/**
 * Interfaz para Etnias
 * 
 * @author Belen Changoluisa
 *
 */
public interface EtniasService {
	
	/**
	 * Permite listar los Etnias
	 * 
	 * @return lista de Etnias
	 * @author Belen Changoluisa
	 */
	List<InsEtnia> listarEtnias();


}
