package ec.gob.educacion.jubilaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.jubilaciones.entity.SgdJubTipoDiscapacidad;
import ec.gob.educacion.jubilaciones.entity.SgdJubTipoJubilacion;


@Repository
public interface SgdJubTipoDiscapacidadRepository extends JpaRepository<SgdJubTipoDiscapacidad, Integer> {	
	
	public List<SgdJubTipoDiscapacidad> findByTipdisEstado(@Param("tipdisEstado") Integer tipdisEstado);	
	public List<SgdJubTipoDiscapacidad> findByTipoJubilacionAndTipdisEstado(@Param("tipoJubilacion") SgdJubTipoJubilacion tipoJubilacion,@Param("tipjubEstado") Integer tipjubEstado);
}
