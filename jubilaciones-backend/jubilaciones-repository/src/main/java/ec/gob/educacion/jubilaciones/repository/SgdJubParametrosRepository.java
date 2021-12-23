package ec.gob.educacion.jubilaciones.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.jubilaciones.entity.SgdJubParametros;


@Repository
public interface SgdJubParametrosRepository extends JpaRepository<SgdJubParametros, Integer> {


	public List<SgdJubParametros> findByParestado(@Param("parestado")Integer parestado);
}
