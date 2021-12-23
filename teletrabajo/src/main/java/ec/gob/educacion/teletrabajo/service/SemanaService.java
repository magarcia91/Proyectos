package ec.gob.educacion.teletrabajo.service;

import java.util.Date;
import java.util.List;

import ec.gob.educacion.teletrabajo.DTO.SemanaResumenDTO;
import ec.gob.educacion.teletrabajo.model.TlSemana;

public interface SemanaService {

	List<SemanaResumenDTO> findAll();

	List<TlSemana> findSemanaFechaTruncada(Date fechaInicio, Date fechaFin);

	void save(TlSemana semana);
	
	public long contarTotalRegistros();

}
