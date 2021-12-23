package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelProvincia;

public interface ProvinciaService {

	public List<TelProvincia> listarProvinciasPorZona(Long codZona, String estado);
	
}
