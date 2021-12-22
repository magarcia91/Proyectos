package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;

public interface EncuestaEstadoService {

	public List<TelEncuestaEstado> listarPorEncuestaCabeceraRegistro(Long codigoEncuesta, Long cabeceraRegistro, String estado);
	
	public TelEncuestaEstado buscarPorCodigo(Long codigoEncuestaEstado);
	
	public void crearActualizar(TelEncuestaEstado encuestaEstado);
	
	public void inactivarListado(List<TelEncuestaEstado> listaEncuestaEstado);

}
