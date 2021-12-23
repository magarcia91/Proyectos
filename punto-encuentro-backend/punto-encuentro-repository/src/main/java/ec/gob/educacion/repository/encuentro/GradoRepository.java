package ec.gob.educacion.repository.encuentro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.InsGrado;

/**
* Repositorio para la entidad InsGrado
* 
* @author Jorge Quishpe
*
*/
@Repository
public interface GradoRepository extends JpaRepository<InsGrado, Integer>{
	
	/**
	 * Permite listar los grados
	 * 
	 * @param estado a buscar
	 * @return lista de grados
	 * @author Jorge Quishpe
	 */
	@Query(value = "select g from InsGrado g where g.codNivel in (1,2,3,4,5,6,7,8) and g.codigo not in (17,18,19) and g.estado=:estado order by g.codigo ")
	List<InsGrado>  listarGradosNiveles(@Param("estado") int estado);

}
