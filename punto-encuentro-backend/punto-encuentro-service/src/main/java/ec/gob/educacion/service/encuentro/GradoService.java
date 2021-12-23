package ec.gob.educacion.service.encuentro;

import java.util.List;

import ec.gob.educacion.model.asignaciones.InsGrado;

/**
 * Interfaz para Grado
 * 
 * @author Jorge Quishpe
 *
 */
public interface GradoService {
	
	/**
	 * Permite listar los grados
	 * 
	 * @param estado a buscar
	 * @return lista de grados
	 * @author Jorge Quishpe
	 */
	List<InsGrado>  listarGradosNiveles();


}
