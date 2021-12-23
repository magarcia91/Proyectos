package ec.gob.educacion.service.impl.encuentro;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.asignaciones.PenTextos;
import ec.gob.educacion.model.enumeraciones.EstadoEnum;
import ec.gob.educacion.repository.encuentro.PenTextosRepository;
import ec.gob.educacion.service.encuentro.PenTextosService;



/**
 * Implementación de los servicios para PenTextos
 * 
 * @author Belen Changoluisa
 *
 */
@Service
public class PenTextosServiceImpl implements PenTextosService{
	@Autowired
	private PenTextosRepository penTextosRepository;

	@Override
	public List<PenTextos> buscarTextoPorGrado(Integer graCodigo) {
		// TODO Auto-generated method stub
		return penTextosRepository.findByGraCodigoAndTxtEstado(graCodigo, 1);

	}


}
