package ec.gob.educacion.repository.tit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.tit.TitImagen;


@Repository
public interface TitImagenRepository extends JpaRepository<TitImagen, Integer>{
	
	TitImagen  findByImgCodigo(@Param("imgCodigo") Integer imgCodigo);
	

}
