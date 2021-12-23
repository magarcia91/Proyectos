package ec.gob.educacion.repository.encuentro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.encuentro.PenSedePen;

/**
* Repositorio para la entidad PenSede
* 
* @author Jorge Quishpe
*
*/
@Repository
public interface PenSedePenRepository extends JpaRepository<PenSedePen, Integer>{
	

	List<PenSedePen> findBySedEstado(Integer sedEstado);

	/**
	 * Permite buscar un sede
	 * 
	 * @param codigo a buscar
	 * @return objeto de sede
	 * @author Jorge Quishpe
	 */
	PenSedePen findBySedCodigo(@Param("sedCodigo") Long sedCodigo);

}
