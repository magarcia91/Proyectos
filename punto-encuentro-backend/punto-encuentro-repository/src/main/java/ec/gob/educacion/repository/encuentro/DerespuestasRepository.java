package ec.gob.educacion.repository.encuentro;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.encuentro.dto.DerespuestasDTO;
import ec.gob.educacion.model.encuentro.PenRespuesta;


/**
* Repositorio para la entidad Encuestado
* 
* @author Belen changoluisa
*
*/
@Repository
public interface DerespuestasRepository extends JpaRepository<PenRespuesta, Integer>{
	
	/**
	 * Permite buscar Derespuestas
	 * 
	 * @param codigo a buscar
	 * @return objeto de respuestas
	 * @author Belen changoluisa
	 */
	@Query(value = "select new ec.gob.educacion.encuentro.dto.DerespuestasDTO ( p.preCodigo,  r.resCodigo,  r.resOrden,  r.resRespuesta, r.resEstado ) from PenPregunta p, PenRespuesta r where p.preCodigo = r.penPregunta and p.preCodigo =:preCodigo and  r.resEstado =:resEstado ")
	List<DerespuestasDTO> listaRespuesta(@Param("preCodigo") long preCodigo, @Param("resEstado") BigDecimal resEstado);
	
	


}
