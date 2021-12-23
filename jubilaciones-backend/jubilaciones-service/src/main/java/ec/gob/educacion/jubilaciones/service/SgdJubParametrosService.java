package ec.gob.educacion.jubilaciones.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ec.gob.educacion.jubilaciones.entity.SgdJubParametros;

public interface SgdJubParametrosService extends ICRUD<SgdJubParametros, Integer> {

	public List<SgdJubParametros> findByParestado(@Param("parestado")Integer parestado);
}
