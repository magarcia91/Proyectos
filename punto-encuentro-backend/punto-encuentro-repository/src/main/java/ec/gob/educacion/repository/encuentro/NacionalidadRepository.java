package ec.gob.educacion.repository.encuentro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.asignaciones.InsPais;

/**
* Repositorio para la entidad NacionalidadRepository
* 
* @author Belen Changoluisa
*
*/
public interface NacionalidadRepository extends JpaRepository<InsPais, Integer>{
	

	
	List<InsPais> findByOrderByDescripcionAsc();




}
