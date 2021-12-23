package ec.gob.educacion.service.impl.encuentro;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.encuentro.dto.PreguntasDTO;
import ec.gob.educacion.repository.encuentro.PreguntasRepository;
import ec.gob.educacion.service.encuentro.PreguntasService;


/**
 * Implementación de los servicios para derespuestas
 * 
 * @author Belen Changoluisa
 *
 */
@Service
public class PreguntasServiceImpl implements PreguntasService{
	
	@Autowired
	private PreguntasRepository preguntasRepository;

	@Override
	public List<PreguntasDTO> listarPreguntaPortpeCodigo(long tpeCodigo, BigDecimal codGrado) {
		// TODO Auto-generated method stub
		return preguntasRepository.listarPreguntaPortpeCodigo(BigDecimal.valueOf(1), tpeCodigo,codGrado);
	}


}
