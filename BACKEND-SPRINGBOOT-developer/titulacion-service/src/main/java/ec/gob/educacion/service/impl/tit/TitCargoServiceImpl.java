package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitCargo;
import ec.gob.educacion.repository.tit.TitCargoRepository;
import ec.gob.educacion.service.tit.TitCargoService;


@Service
public class TitCargoServiceImpl implements TitCargoService{
	
	@Autowired
	private TitCargoRepository titCargoRepository;

	@Override
	public TitCargo registrarCargo(TitCargo titCargo) {
		// TODO Auto-generated method stub
		return titCargoRepository.save(titCargo);
	}

	@Override
	public TitCargo buscarCarCodigo(Integer carCodigo) {
		// TODO Auto-generated method stub
		return titCargoRepository.findByCarCodigo(carCodigo);
	}

	@Override
	public List<TitCargo> listarCargo() {
		// TODO Auto-generated method stub
		return titCargoRepository.findAll();
	}

	
	
	

}
