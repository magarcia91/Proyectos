package ec.gob.educacion.repository.encuentro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.encuentro.PenEncuesta;


/**
* Repositorio para la entidad Encuetas
* 
* @author Belen changoluisa
*
*/
@Repository
public interface EncuestaRepository extends JpaRepository<PenEncuesta, Integer>{
	
	
}
