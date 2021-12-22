package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelDistrito;

public interface DistritoService {

	public TelDistrito obtenerDistritoPorDpa(String dpaDistrito, String estado);
	
	public List<TelDistrito> listarDistritosPorCodProvincia(Long codProvincia, String estado);
	
	public List<TelDistrito> obtenerDistritosPorZona(Long codZona, String estado);
	
}
