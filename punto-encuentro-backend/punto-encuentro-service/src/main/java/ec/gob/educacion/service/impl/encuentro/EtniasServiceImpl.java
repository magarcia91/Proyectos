package ec.gob.educacion.service.impl.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.asignaciones.InsEtnia;
import ec.gob.educacion.repository.encuentro.EtniasRepository;
import ec.gob.educacion.service.encuentro.EtniasService;


/**
 * Implementación de los servicios para Etnias
 * 
 * @author Belen Changoluisa
 *
 */

@Service
public class EtniasServiceImpl implements EtniasService{
	
	@Autowired
	private EtniasRepository etniasRepository;

	@Override
	public List<InsEtnia> listarEtnias() {
		// TODO Auto-generated method stub
		return etniasRepository.findByOrderByDescripcionAsc();
	}
	
	
	
	

}
