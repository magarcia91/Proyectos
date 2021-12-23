package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitCargo;


@Repository
public interface TitCargoRepository extends JpaRepository<TitCargo, Integer>{
	
	TitCargo  findByCarCodigo(@Param("carCodigo") Integer carCodigo);
	

}
