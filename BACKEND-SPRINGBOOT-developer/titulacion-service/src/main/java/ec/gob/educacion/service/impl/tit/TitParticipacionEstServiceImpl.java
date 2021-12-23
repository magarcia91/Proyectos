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
public class TitParticipacionEstServiceImpl implements TitParticipacionEstService {
	

	@Autowired
	private TitParticipacionEstRepository titParticipacionEstRepository;

	@Override
	public TitParticipacionEst registrarParticipacionEst(TitParticipacionEst titParticipacionEst) {
		// TODO Auto-generated method stub
		return titParticipacionEstRepository.saveAndFlush(titParticipacionEst);
	}

	@Override
	public TitParticipacionEst buscarPesCodigo(Integer pesCodigo) {
		// TODO Auto-generated method stub
		return titParticipacionEstRepository.findByPesCodigo(pesCodigo);
	}

	@Override
	public List<TitParticipacionEst> listarParticipacionEst() {
		// TODO Auto-generated method stub
		return titParticipacionEstRepository.findAll();
	}
	
	
	

}
