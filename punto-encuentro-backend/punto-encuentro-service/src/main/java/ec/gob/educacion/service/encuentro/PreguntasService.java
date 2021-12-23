package ec.gob.educacion.service.encuentro;


import java.math.BigDecimal;
import java.util.List;

import ec.gob.educacion.encuentro.dto.PreguntasDTO;

/**
 * Interfaz para Derespuesta
 * 
 * @author Belen Changoluisa
 *
 */
public interface PreguntasService {
	
	/**
	 * Permite buscar un derespuesta
	 * 
	 * @return listar pregunta
	 * @author Belen Changoluisa
	 */
	List<PreguntasDTO> listarPreguntaPortpeCodigo(long tpeCodigo, BigDecimal codGrado);
	


}
