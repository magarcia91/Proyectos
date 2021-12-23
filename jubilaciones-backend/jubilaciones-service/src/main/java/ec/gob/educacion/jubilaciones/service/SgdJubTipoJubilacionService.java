package ec.gob.educacion.jubilaciones.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ec.gob.educacion.jubilaciones.entity.SgdJubTipoJubilacion;

public interface SgdJubTipoJubilacionService {

	public List<SgdJubTipoJubilacion> findByTipjubEstado(@Param("tipjubEstado") Integer tipjubEstado);
		
}
