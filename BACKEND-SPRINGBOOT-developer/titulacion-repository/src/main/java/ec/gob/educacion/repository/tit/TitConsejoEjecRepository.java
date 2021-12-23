package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitConsejoEjec;


@Repository
public interface TitConsejoEjecRepository extends JpaRepository<TitConsejoEjec, Integer>{
	
	TitConsejoEjec  findByAutCodigo(@Param("autCodigo") Integer autCodigo);
	

}
