package ec.gob.educacion.jubilaciones.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.jubilaciones.entity.SgdJubTipoDiscapacidad;
import ec.gob.educacion.jubilaciones.entity.SgdJubTipoJubilacion;
import ec.gob.educacion.jubilaciones.enumeracion.EstadoEnum;
import ec.gob.educacion.jubilaciones.repository.SgdJubTipoDiscapacidadRepository;
import ec.gob.educacion.jubilaciones.repository.SgdJubTipoJubilacionRepository;
import ec.gob.educacion.jubilaciones.service.SgdJubTipoDiscapacidadService;

@Service
public class SgdJubTipoDiscapacidadServiceImpl implements SgdJubTipoDiscapacidadService {

	@Autowired
	private SgdJubTipoDiscapacidadRepository sgdJubTipoDiscapacidadRepository;
	@Autowired
	private SgdJubTipoJubilacionRepository sgdJubTipoJubilacionRepository;
	
	@Override
	public List<SgdJubTipoDiscapacidad> findBytipdisEstado(Integer tipdisEstado) {			
		return sgdJubTipoDiscapacidadRepository.findByTipdisEstado(tipdisEstado);
	}

	@Override
	public List<SgdJubTipoDiscapacidad> listarDiscapacidadPorJubilacion(Integer tipjubCod) {
		SgdJubTipoJubilacion tipoJubilacion=sgdJubTipoJubilacionRepository.getOne(tipjubCod);
		return sgdJubTipoDiscapacidadRepository.findByTipoJubilacionAndTipdisEstado(tipoJubilacion ,EstadoEnum.ACTIVO.getCodigo() );
	}

	

	
		
}
