package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.model.TelZona;
import ec.gob.educacion.teletrabajo.repository.ZonaRepository;
import ec.gob.educacion.teletrabajo.service.ZonaService;

@Service
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	private ZonaRepository zonaRepository;
	
	public List<TelZona> listarZonas(String estado){
		return zonaRepository.listarZonas(estado);
	}

}
