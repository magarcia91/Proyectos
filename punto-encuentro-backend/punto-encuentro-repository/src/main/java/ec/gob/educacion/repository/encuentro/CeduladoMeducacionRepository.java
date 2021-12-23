package ec.gob.educacion.repository.encuentro;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.model.asignaciones.CeduladoMeducacion;

/**
* Repositorio para la entidad CeduladoMeducacion
* 
* @author Belen Changoluisa
*
*/

public interface CeduladoMeducacionRepository extends JpaRepository<CeduladoMeducacion, Integer>{
	
	/**
	 * Permite buscar la cedula
	 * 
	 * @param cedula a buscar
	 * @return lista persona
	 * @author Belen Changoluisa
	 */
	List<CeduladoMeducacion>  findByCedula(@Param("cedula") BigDecimal cedula);



}
