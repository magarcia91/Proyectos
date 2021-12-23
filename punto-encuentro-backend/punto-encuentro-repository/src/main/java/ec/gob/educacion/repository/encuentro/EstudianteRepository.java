package ec.gob.educacion.repository.encuentro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.encuentro.PenEstudiante;

/**
* Repositorio para la entidad PenEstudiante
* 
* @author Jorge Quishpe
*
*/
@Repository
public interface EstudianteRepository extends JpaRepository<PenEstudiante, Integer>{
	
	/**
	 * Permite buscar un estudiante
	 * 
	 * @param estado a buscar
	 * @param cedula a buscar
	 * @return objeto de estudiante
	 * @author Jorge Quishpe
	 */
	PenEstudiante findByEstCedulaAndEstEstado(@Param("estCedula") String estCedula,@Param("estEstado") int estEstado);
	
	/**
	 * Permite buscar un estudiante
	 * 
	 * @param estado a buscar
	 * @param identidad a buscar
	 * @return objeto de estudiante
	 * @author Jorge Quishpe
	 */
	PenEstudiante findByEstIdentidadAndEstEstado(@Param("estIdentidad") String estIdentidad,@Param("estEstado") int estEstado);
	
	/**
	 * Permite buscar un estudiante
	 * 
	 * @param codigo a buscar
	 * @author Belen Changoluisa
	 */
	PenEstudiante findByEstCodigo(@Param("estCodigo") long estCodigo);

}
