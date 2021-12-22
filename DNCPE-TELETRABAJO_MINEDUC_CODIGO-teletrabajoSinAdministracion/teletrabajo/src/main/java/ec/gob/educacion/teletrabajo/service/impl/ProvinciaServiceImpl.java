package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.model.TelProvincia;
import ec.gob.educacion.teletrabajo.repository.ProvinciaRepository;
import ec.gob.educacion.teletrabajo.service.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	public List<TelProvincia> listarProvinciasPorZona(Long codZona, String estado){
		return provinciaRepository.listarProvinciasPorZona(codZona, estado);
	}

}
