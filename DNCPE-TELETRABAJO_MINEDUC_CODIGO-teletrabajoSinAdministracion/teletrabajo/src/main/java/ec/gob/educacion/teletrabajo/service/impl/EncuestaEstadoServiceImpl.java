package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;
import ec.gob.educacion.teletrabajo.repository.EncuestaEstadoRepository;
import ec.gob.educacion.teletrabajo.service.EncuestaEstadoService;

@Service
public class EncuestaEstadoServiceImpl implements EncuestaEstadoService {
	
	private static final Logger LOGGER = Logger.getLogger(DistritoRegistroServiceImpl.class.getName());

	@Autowired
	private EncuestaEstadoRepository encuestaEstadoRepository;

	
	public List<TelEncuestaEstado> listarPorEncuestaCabeceraRegistro(Long codigoEncuesta, Long cabeceraRegistro, String estado){
		return encuestaEstadoRepository.listarPorEncuestaCabeceraRegistro(codigoEncuesta, cabeceraRegistro, estado);
	}
	
	public void crearActualizar(TelEncuestaEstado encuestaEstado) {
		try {
			encuestaEstadoRepository.save(encuestaEstado);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
	
	public void inactivarListado(List<TelEncuestaEstado> listaEncuestaEstado) {
		try {
			listaEncuestaEstado.stream().forEach(x->x.setStsEstado(EstadoEnum.INACTIVO.getValor()));
			encuestaEstadoRepository.saveAll(listaEncuestaEstado);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
	
	public TelEncuestaEstado buscarPorCodigo(Long codigoEncuestaEstado) {
		return encuestaEstadoRepository.getOne(codigoEncuestaEstado);
	}

}
