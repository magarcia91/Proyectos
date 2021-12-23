package ec.gob.educacion.jubilaciones.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.jubilaciones.entity.SgdJubTipoJubilacion;
import ec.gob.educacion.jubilaciones.repository.SgdJubTipoJubilacionRepository;
import ec.gob.educacion.jubilaciones.service.SgdJubTipoJubilacionService;

@Service
public class SgdJubTipoJubilacionServiceImpl implements SgdJubTipoJubilacionService {

	@Autowired
	public SgdJubTipoJubilacionRepository sgdJubTipoJubilacionRepository;
	
	@Override
	public List<SgdJubTipoJubilacion> findByTipjubEstado(Integer tipjubEstado) {
		return sgdJubTipoJubilacionRepository.findByTipjubEstado(tipjubEstado);
	}
	
	
			
}
