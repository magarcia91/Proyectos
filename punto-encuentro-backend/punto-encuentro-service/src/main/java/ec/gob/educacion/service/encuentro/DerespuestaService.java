package ec.gob.educacion.service.encuentro;


import java.util.List;


import ec.gob.educacion.encuentro.dto.DerespuestasDTO;

/**
 * Interfaz para Derespuesta
 * 
 * @author Belen Changoluisa
 *
 */
public interface DerespuestaService {
	
	/**
	 * Permite buscar un derespuesta
	 * 
	 * @return listar respuestas
	 * @author Belen Changoluisa
	 */
	List<DerespuestasDTO> listarDerespuesta(long preCodigo);
	


}
