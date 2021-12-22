package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.model.TelInsEducativa;
import ec.gob.educacion.teletrabajo.repository.InsEducativaRepository;
import ec.gob.educacion.teletrabajo.service.InsEducativaService;

@Service
public class InsEducativaServiceImpl implements InsEducativaService {

	@Autowired
	private InsEducativaRepository insEducativaRepository;
	
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistrito(Long codDistrito, String estado){
		return insEducativaRepository.listarInstitucionesEducativasPorDistrito(codDistrito, estado);
	}
	
	public List<TelInsEducativa> listarInstitucionesEducativasPorOfertaEducativa(String nemonicoOferta, String estado){
		return insEducativaRepository.listarInstitucionesEducativasPorOfertaEducativa(nemonicoOferta, estado);
	}
	
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistritoYOferta(String nemonicoOferta,Long codDistrito,String estado){
		return insEducativaRepository.listarInstitucionesEducativasPorDistritoYOferta(nemonicoOferta, codDistrito, estado);
	}

}
