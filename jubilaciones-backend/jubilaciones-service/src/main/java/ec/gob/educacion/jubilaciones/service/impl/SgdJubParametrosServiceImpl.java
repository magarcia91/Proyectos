package ec.gob.educacion.jubilaciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.jubilaciones.entity.SgdJubParametros;
import ec.gob.educacion.jubilaciones.repository.SgdJubParametrosRepository;
import ec.gob.educacion.jubilaciones.service.SgdJubParametrosService;

@Service
public class SgdJubParametrosServiceImpl implements SgdJubParametrosService {
	
	
	@Autowired
	private SgdJubParametrosRepository repositorySgdJubParametros;

	@Override
	public SgdJubParametros registrar(SgdJubParametros par) {		
		return repositorySgdJubParametros.save(par);
	}

	@Override
	public SgdJubParametros modificar(SgdJubParametros par) {
		return repositorySgdJubParametros.save(par);
	}

	@Override
	public List<SgdJubParametros> listar() {
		return repositorySgdJubParametros.findAll();
	}

	@Override
	public SgdJubParametros listarPorId(Integer parJubCod) {
		Optional<SgdJubParametros> op = repositorySgdJubParametros.findById(parJubCod);
		return op.isPresent() ? op.get() : new SgdJubParametros();		
	}

	@Override
	public boolean eliminar(Integer parJubCod) {
		repositorySgdJubParametros.deleteById(parJubCod);
		return true;		
	}

	@Override
	public List<SgdJubParametros> findByParestado(Integer parestado) {		
		return repositorySgdJubParametros.findByParestado(parestado);
	}
		
}
