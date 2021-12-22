package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.model.TelDistrito;
import ec.gob.educacion.teletrabajo.repository.DistritoRepository;
import ec.gob.educacion.teletrabajo.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

	@Autowired
	private DistritoRepository distritoRepository;
	
	public TelDistrito obtenerDistritoPorDpa(String dpaDistrito, String estado) {
		return distritoRepository.obtenerDistritoPorDpa(dpaDistrito, estado);
	}
	
	public List<TelDistrito> listarDistritosPorCodProvincia(Long codProvincia, String estado){
		return distritoRepository.obtenerDistritoPorCodProvincia(codProvincia, estado);
	}
	
	public List<TelDistrito> obtenerDistritosPorZona(Long codZona, String estado){
		return distritoRepository.obtenerDistritosPorZona(codZona, estado);
	}

}
