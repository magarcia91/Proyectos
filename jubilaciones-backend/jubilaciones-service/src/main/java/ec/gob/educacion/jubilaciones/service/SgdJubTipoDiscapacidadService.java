package ec.gob.educacion.jubilaciones.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ec.gob.educacion.jubilaciones.entity.SgdJubTipoDiscapacidad;

public interface SgdJubTipoDiscapacidadService {

	public List<SgdJubTipoDiscapacidad> findBytipdisEstado(@Param("tipdisEstado") Integer tipdisEstado);
	public List<SgdJubTipoDiscapacidad> listarDiscapacidadPorJubilacion(@Param("tipjubCod") Integer tipjubCod);
}
