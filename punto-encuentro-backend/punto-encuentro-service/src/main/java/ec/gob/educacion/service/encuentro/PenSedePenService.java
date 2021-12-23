package ec.gob.educacion.service.encuentro;

import java.util.List;

import ec.gob.educacion.model.encuentro.PenSedePen;


/**
 * Interfaz para PenSede
 * 
 * @author Jorge Quishpe
 *
 */
public interface PenSedePenService {
	
	List<PenSedePen> listarSede(Integer sedEstado);
	
	/**
	 * Permite buscar un sede
	 * 
	 * @param codigo a buscar
	 * @return objeto de sede
	 * @author Jorge Quishpe
	 */
	PenSedePen buscarSedePorCodigo(Long sedCodigo);

}
