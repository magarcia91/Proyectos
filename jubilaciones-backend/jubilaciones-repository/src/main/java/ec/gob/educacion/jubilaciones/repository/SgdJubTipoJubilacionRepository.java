package ec.gob.educacion.jubilaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.jubilaciones.entity.SgdJubTipoJubilacion;


@Repository
public interface SgdJubTipoJubilacionRepository extends JpaRepository<SgdJubTipoJubilacion, Integer> {	
	
	public List<SgdJubTipoJubilacion> findByTipjubEstado(@Param("tipjubEstado") Integer tipjubEstado);
}
