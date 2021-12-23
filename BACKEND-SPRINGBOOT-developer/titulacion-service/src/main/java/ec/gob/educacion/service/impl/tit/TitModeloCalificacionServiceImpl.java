package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitModeloCalificacion;
import ec.gob.educacion.repository.tit.TitModeloCalificacionRepository;
import ec.gob.educacion.service.tit.TitModeloCalificacionService;


@Service
public class TitModeloCalificacionServiceImpl implements TitModeloCalificacionService{
	
	@Autowired
	private TitModeloCalificacionRepository titModeloCalificacionRepository;

	@Override
	public TitModeloCalificacion registrar(TitModeloCalificacion titModeloCalificacion) {
		//titModeloCalificacion.setMcaEstado(1);
		return titModeloCalificacionRepository.save(titModeloCalificacion);
	}

	@Override
	public TitModeloCalificacion buscarMcaCodigo(Integer mcaCodigo) {
		// TODO Auto-generated method stub
		return titModeloCalificacionRepository.findByMcaCodigo(mcaCodigo);
	}

	@Override
	public List<TitModeloCalificacion> listar() {
		// TODO Auto-generated method stub
		return titModeloCalificacionRepository.findAll();
	}

	




	
	

}
