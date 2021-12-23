package ec.gob.educacion.service.encuentro;

import java.util.List;

import ec.gob.educacion.encuentro.dto.EncuEstPregDTO;
import ec.gob.educacion.model.encuentro.PenTipoPregunta;


/**
 * Interfaz para Derespuesta
 * 
 * @author Belen Changoluisa
 *
 */
public interface EncEstPregService {
	
	/**
	 * Permite buscar un derespuesta
	 * 
	 * @return listar pregunta
	 * @author Belen Changoluisa
	 */
	List<EncuEstPregDTO> listarEstudianteEncuentaPregunta(long penTipoPregunta, long estCodigo);
	


}
