package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitConsejoEjec;
import ec.gob.educacion.repository.tit.TitConsejoEjecRepository;
import ec.gob.educacion.service.tit.TitConsejoEjecService;



@Service
public class TitConsejoEjecServiceImpl implements TitConsejoEjecService{
	
	@Autowired
	private TitConsejoEjecRepository titConsejoEjecRepository;

	@Override
	public TitConsejoEjec registrar(TitConsejoEjec titConsejoEjec) {
		// TODO Auto-generated method stub
		return titConsejoEjecRepository.save(titConsejoEjec);
	}

	@Override
	public TitConsejoEjec buscarAutCodigo(Integer autCodigo) {
		// TODO Auto-generated method stub
		return titConsejoEjecRepository.findByAutCodigo(autCodigo);
	}

	@Override
	public List<TitConsejoEjec> listar() {
		// TODO Auto-generated method stub
		return titConsejoEjecRepository.findAll();
	}



	

	




	
	

}
