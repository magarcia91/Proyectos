package ec.gob.educacion.repository.tit;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitFechaTitulacion;

@Repository
public interface FechaTitulacionRepository extends JpaRepository<TitFechaTitulacion, Integer>{
	
	TitFechaTitulacion  findByFtiCodigo(@Param("ftiCodigo") long ftiCodigo);
	
	List<TitFechaTitulacion>  findByCodRegAniLecAndCodTipoEducacion(@Param("codRegAniLec") Integer codRegAniLec,@Param("codTipoEducacion") Integer codTipoEducacion);
}
