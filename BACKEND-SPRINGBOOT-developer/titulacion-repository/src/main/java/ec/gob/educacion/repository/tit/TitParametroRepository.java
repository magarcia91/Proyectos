package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitParametro;

@Repository
public interface TitParametroRepository extends JpaRepository<TitParametro, Integer>{
	
	TitParametro  findByCodigo(@Param("codigo") Integer codigo);
	

}
