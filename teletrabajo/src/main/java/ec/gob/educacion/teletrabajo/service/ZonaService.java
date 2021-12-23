package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelZona;

public interface ZonaService {

	public List<TelZona> listarZonas(String estado);
	
}
