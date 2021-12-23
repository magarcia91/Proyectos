package ec.gob.educacion.service.encuentro;

import java.util.List;

import ec.gob.educacion.model.asignaciones.InsPais;

/**
 * Interfaz para Pais
 * 
 * @author Belen Changoluisa
 *
 */
public interface NacionalidadService {
	
	/**
	 * Permite listar los Nacionalidades
	 * 
	 * @return lista de nacionalidades
	 * @author Belen Changoluisa
	 */
	List<InsPais> listarNacionalidad();


}
