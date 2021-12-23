package ec.gob.educacion.repository.encuentro;


import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.asignaciones.InsEtnia;
import java.util.List; 

/**
* Repositorio para la entidad EtniasRepository
* 
* @author Belen Changoluisa
*
*/
public interface EtniasRepository extends JpaRepository<InsEtnia, Long>  {
   
	
	
	List<InsEtnia> findByOrderByDescripcionAsc();
}
