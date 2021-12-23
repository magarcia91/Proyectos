package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitImagen;
import ec.gob.educacion.repository.tit.TitImagenRepository;
import ec.gob.educacion.service.tit.TitImagenService;

@Service
public class TitImagenServiceImpl implements TitImagenService{
	
	@Autowired
	private TitImagenRepository titImagenRepository;

	@Override
	public TitImagen registrarImagen(TitImagen titImagen) {
		// TODO Auto-generated method stub
		return titImagenRepository.save(titImagen);
	}

	@Override
	public TitImagen buscarImgCodigo(Integer imgCodigo) {
		// TODO Auto-generated method stub
		return titImagenRepository.findByImgCodigo(imgCodigo);
	}

	@Override
	public List<TitImagen> listarImagen() {
		// TODO Auto-generated method stub
		return titImagenRepository.findAll();
	}

	

	

}
