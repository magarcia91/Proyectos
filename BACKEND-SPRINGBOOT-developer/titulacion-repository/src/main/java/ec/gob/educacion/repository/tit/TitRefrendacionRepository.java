package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitRefrendacion;


@Repository
public interface TitRefrendacionRepository extends JpaRepository<TitRefrendacion, Integer>{
	
	TitRefrendacion  findByRefCodigo(@Param("refCodigo") Integer refCodigo);
	

}
