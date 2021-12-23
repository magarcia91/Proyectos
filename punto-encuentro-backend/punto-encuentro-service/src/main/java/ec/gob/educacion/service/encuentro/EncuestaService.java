package ec.gob.educacion.service.encuentro;

import ec.gob.educacion.model.encuentro.PenEncuesta;

/**
 * Interfaz para Encuesta
 * 
 * @author Belen Changoluisa
 *
 */
public interface EncuestaService {
	
	/**
	 * Permite buscar un encuesta
	 * 
	 * @return encuesta a guardar o actualizar
	 * @author Belen Changoluisa
	 */
	PenEncuesta guardarPenEncuesta(PenEncuesta penEncuesta);
	


}
