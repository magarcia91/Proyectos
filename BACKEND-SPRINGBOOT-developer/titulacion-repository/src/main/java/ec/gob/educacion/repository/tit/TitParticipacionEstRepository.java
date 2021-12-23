package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitParticipacionEst;


@Repository
public interface TitParticipacionEstRepository extends JpaRepository<TitParticipacionEst, Integer>{
	
	TitParticipacionEst  findByPesCodigo(@Param("pesCodigo") Integer pesCodigo);
	

}
