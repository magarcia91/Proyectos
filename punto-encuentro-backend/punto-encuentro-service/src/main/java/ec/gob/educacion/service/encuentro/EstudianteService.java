package ec.gob.educacion.service.encuentro;

import ec.gob.educacion.model.encuentro.PenEstudiante;

/**
 * Interfaz para PenEstudiante
 * 
 * @author Jorge Quishpe
 *
 */
public interface EstudianteService {
	
	/**
	 * Permite buscar un estudiante
	 * 
	 * @param estado a buscar
	 * @param cedula a buscar
	 * @return objeto de estudiante
	 * @author Jorge Quishpe
	 */
	PenEstudiante buscarEstudiantePorCedula(String estCedula);
	
	/**
	 * Permite buscar un estudiante
	 * 
	 * @param estado a buscar
	 * @param identidad a buscar
	 * @return objeto de estudiante
	 * @author Jorge Quishpe
	 */
	PenEstudiante buscarEstudiantePorIdentidad(String estIdentidad);
	
	/**
	 * Permite persistir un estudiante
	 * 
	 * @param estudiante a guardar o actualizar
	 * @return estudiante guardado
	 */
	PenEstudiante guardar(PenEstudiante estudiante);
	
	/**
	 * Permite buscar un estudiante
	 * 
	 * @param codigo a buscar
	 * @author Belen Changoluisa
	 */
	PenEstudiante buscarEstudiantePorCodigo(long estCodigo);

}
