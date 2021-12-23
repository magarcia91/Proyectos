package ec.gob.educacion.service.impl.censo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.censo.InsAsignacionCenso;
import ec.gob.educacion.repository.censo.InsAsignacionCensoRepository;
import ec.gob.educacion.service.censo.InsAsignacionCensoService;


@Service
public class InsAsignacionCensoServiceImpl implements InsAsignacionCensoService{
	
	@Autowired (required=true)
	private InsAsignacionCensoRepository insAsignacionCensoRepository;

	@Override
	public InsAsignacionCenso buscarCodigoAsignacionCenso(Integer codigo) {
		// TODO Auto-generated method stub
		return insAsignacionCensoRepository.getOne(codigo);
	}

	

	




	
	

}
