package ec.gob.educacion.repository.catalogos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.InsRegAniLec;
import ec.gob.educacion.model.asignaciones.InsTipoEducacion;

@Repository
public interface InsTipoEducacionRepository extends JpaRepository<InsTipoEducacion, Integer>{
	
	List<InsTipoEducacion> findByEstado (@Param("estado") int estado);
	

}
