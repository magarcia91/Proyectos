package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitParametro;
import ec.gob.educacion.repository.tit.TitParametroRepository;
import ec.gob.educacion.service.tit.TitParametroService;


@Service
public class TitParametroServiceImpl implements TitParametroService{
	
	@Autowired
	private TitParametroRepository titParametroRepository;

	@Override
	public TitParametro registrar(TitParametro titParametro) {
		// TODO Auto-generated method stub
		return titParametroRepository.save(titParametro);
	}

	@Override
	public TitParametro buscarCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return titParametroRepository.findByCodigo(codigo);
	}

	@Override
	public List<TitParametro> listar() {
		// TODO Auto-generated method stub
		return titParametroRepository.findAll();
	}

	

	




	
	

}
