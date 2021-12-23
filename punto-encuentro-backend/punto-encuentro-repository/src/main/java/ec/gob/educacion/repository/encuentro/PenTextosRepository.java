package ec.gob.educacion.repository.encuentro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.PenTextos;
import ec.gob.educacion.model.encuentro.PenEstudiante;

/**
* Repositorio para la entidad InsGrado
* 
* @author Jorge Quishpe
*
*/
@Repository
public interface PenTextosRepository extends JpaRepository<PenTextos, Integer>{
	
	/**
	 * Permite listar los textos por grado
	 * 
	 * @param estado a buscar
	 * @return lista de textos
	 * @author Belen Changoluisa
	 */

	List<PenTextos>  findByGraCodigoAndTxtEstado(@Param("graCodigo") Integer graCodigo,@Param("txtEstado") int txtEstado);
	


}
