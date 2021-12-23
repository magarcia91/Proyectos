package ec.gob.educacion.service.encuentro;

import java.util.List;

import ec.gob.educacion.model.asignaciones.PenTextos;

/**
 * Interfaz para PenEstudiante
 * 
 * @author Jorge Quishpe
 *
 */
public interface PenTextosService {
	
	/**
	 * Permite buscar un texto por grado
	 * 
	 * @param estado a buscar
	 * @param codigo a buscar
	 * @return objeto de texto
	 * @author Belen Changoluisa
	 */

	List<PenTextos> buscarTextoPorGrado(Integer graCodigo);
}
