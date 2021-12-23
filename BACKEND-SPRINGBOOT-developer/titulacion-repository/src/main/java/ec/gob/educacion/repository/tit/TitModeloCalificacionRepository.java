package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitModeloCalificacion;

@Repository
public interface TitModeloCalificacionRepository extends JpaRepository<TitModeloCalificacion, Integer>{
	
	TitModeloCalificacion  findByMcaCodigo(@Param("mcaCodigo") Integer mcaCodigo);
	

}
