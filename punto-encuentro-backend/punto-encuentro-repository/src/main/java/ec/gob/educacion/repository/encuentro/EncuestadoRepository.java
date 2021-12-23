package ec.gob.educacion.repository.encuentro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.encuentro.dto.EncuestadoDTO;
import ec.gob.educacion.model.encuentro.PenEstudiante;


/**
* Repositorio para la entidad Encuestado
* 
* @author Belen changoluisa
*
*/
@Repository
public interface EncuestadoRepository extends JpaRepository<PenEstudiante, Integer>{
	
	/**
	 * Permite buscar un encuestado
	 * 
	 * @param cedula a buscar
	 * @return objeto de estudiante
	 * @author Belen changoluisa
	 */
	@Query(value = "select new ec.gob.educacion.encuentro.dto.EncuestadoDTO (p.estCodigo, p.estNombre, g.codigo , g.descripcion ) from PenEstudiante p, InsGrado  g where p.graCodigo = g.codigo and p.estCedula =:estCedula ")
	EncuestadoDTO findByEncuestadoDTO(@Param("estCedula") String estCedula);
	
	/**
	 * Permite buscar un encuestado
	 * 
	 * @param codigo a buscar
	 * @return objeto de estudiante
	 * @author Belen changoluisa
	 */
	@Query(value = "select new ec.gob.educacion.encuentro.dto.EncuestadoDTO (p.estCodigo, p.estNombre, g.codigo , g.descripcion ) from PenEstudiante p, InsGrado  g where p.graCodigo = g.codigo and p.estCodigo =:estCodigo ")
	EncuestadoDTO findByEncuestadoCodigo(@Param("estCodigo") long estCodigo);
	


}
