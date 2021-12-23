package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelInsEducativa;

public interface InsEducativaService {

	public List<TelInsEducativa> listarInstitucionesEducativasPorDistrito(Long codDistrito, String estado);
	
	public List<TelInsEducativa> listarInstitucionesEducativasPorOfertaEducativa(String nemonicoOferta, String estado);
	
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistritoYOferta(String nemonicoOferta,Long codDistrito,String estado);
	
}
