package ec.gob.educacion.repository.encuentro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.encuentro.dto.EncuEstPregDTO;
import ec.gob.educacion.model.encuentro.PenEstudiante;
import ec.gob.educacion.model.encuentro.PenTipoPregunta;

/**
* Repositorio para la entidad listarPregunta
* 
* @author Belen Changoluisa
*
*/
@Repository
public interface EncEstPregRepository extends JpaRepository<PenEstudiante, Integer>{
	
	/**
	 * Permite listar codPregunta, estudiante
	 * 
	 * @return lista de preguntas
	 * @author Belen Changoluisa
	 */	
	@Query(value = "Select new ec.gob.educacion.encuentro.dto.EncuEstPregDTO (e.encCodigo,a.tpeCodigo, p.estCedula "
			+ " ) from PenEstudiante p "
			+ " inner join PenEncuesta e on e.penEstudiante = p.estCodigo "
			+ " inner join PenPregunta t on t.preCodigo = e.preCodigo "
			+ "inner join PenTipoPregunta a on a.tpeCodigo = t.penTipoPregunta "
			+ " where a.tpeCodigo=:penTipoPregunta and p.estCodigo =:estCodigo")
	List<EncuEstPregDTO>  listarEstudianteEncuentaPregunta(@Param("penTipoPregunta") long penTipoPregunta, @Param("estCodigo") long estCodigo);

}
