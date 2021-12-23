package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelCatalogo;

public interface CatalogoService {

	public List<TelCatalogo> listarEncuestasPorUsuario(Long codigoCabeceraRegistro, Long codigoOfertaEducativa, String estado);
	
	public List<TelCatalogo> listarEncuestasPorEstado(String estado, String nemonicoEncuestas);

}
