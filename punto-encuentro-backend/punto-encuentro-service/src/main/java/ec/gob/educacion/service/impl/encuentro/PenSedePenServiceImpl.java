package ec.gob.educacion.service.impl.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.encuentro.PenSedePen;
import ec.gob.educacion.repository.encuentro.PenSedePenRepository;
import ec.gob.educacion.service.encuentro.PenSedePenService;


/**
 * Implementación de los servicios para PenSede
 * 
 * @author Jorge Quishpe
 *
 */
@Service
public class PenSedePenServiceImpl implements PenSedePenService{
	@Autowired
	private PenSedePenRepository penSedePenRepository;

	@Override
	public List<PenSedePen> listarSede(Integer sedEstado) {
		// TODO Auto-generated method stub
		return penSedePenRepository.findBySedEstado(sedEstado);
	}
	
	@Override
	public PenSedePen buscarSedePorCodigo(Long sedCodigo) {
		return penSedePenRepository.findBySedCodigo(sedCodigo);
	}
}
