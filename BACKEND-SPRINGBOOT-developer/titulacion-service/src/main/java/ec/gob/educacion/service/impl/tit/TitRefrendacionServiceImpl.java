package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitParticipacionEst;
import ec.gob.educacion.model.tit.TitRefrendacion;
import ec.gob.educacion.repository.tit.TitParticipacionEstRepository;
import ec.gob.educacion.repository.tit.TitRefrendacionRepository;
import ec.gob.educacion.service.tit.TitParticipacionEstService;
import ec.gob.educacion.service.tit.TitRefrendacionService;


@Service
public class TitRefrendacionServiceImpl implements TitRefrendacionService{
	
	@Autowired
	private TitRefrendacionRepository titRefrendacionRepository;

	@Override
	public TitRefrendacion registrarRefrendacion(TitRefrendacion titRefrendacion) {

		return titRefrendacionRepository.save(titRefrendacion);
	}

	@Override
	public TitRefrendacion buscarRefCodigo(Integer refCodigo) {
		// TODO Auto-generated method stub
		return titRefrendacionRepository.findByRefCodigo(refCodigo);
	}

	@Override
	public List<TitRefrendacion> listarRefrendacion() {
		// TODO Auto-generated method stub
		return titRefrendacionRepository.findAll();
	}

	

}
