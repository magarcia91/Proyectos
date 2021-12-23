package ec.gob.educacion.service.impl.encuentro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.encuentro.PenEncuesta;
import ec.gob.educacion.repository.encuentro.EncuestaRepository;
import ec.gob.educacion.service.encuentro.EncuestaService;

/**
 * Implementación de los servicios para PenEstudiante
 * 
 * @author Belen Changoluisa
 *
 */
@Service
public class EncuestaServiceImpl implements EncuestaService{
	
	@Autowired
	private EncuestaRepository  encuestaRepository;

	@Override
	public PenEncuesta guardarPenEncuesta(PenEncuesta penEncuesta) {
		
		return encuestaRepository.save(penEncuesta);
	}

	

}
