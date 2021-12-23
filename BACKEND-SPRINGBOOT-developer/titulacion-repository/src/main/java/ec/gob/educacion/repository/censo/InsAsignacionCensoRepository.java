package ec.gob.educacion.repository.censo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.censo.InsAsignacionCenso;


@Repository
public interface InsAsignacionCensoRepository extends JpaRepository<InsAsignacionCenso, Integer>{
	
	InsAsignacionCenso  findByCodigo(@Param("codigo") Integer codigo);
	

}
