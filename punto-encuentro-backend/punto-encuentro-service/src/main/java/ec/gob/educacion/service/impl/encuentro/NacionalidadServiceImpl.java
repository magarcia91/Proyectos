package ec.gob.educacion.service.impl.encuentro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.asignaciones.InsPais;
import ec.gob.educacion.repository.encuentro.NacionalidadRepository;
import ec.gob.educacion.service.encuentro.NacionalidadService;


/**
 * Implementación de los servicios para Nacionalidad
 * 
 * @author Belen Changoluisa
 *
 */

@Service
public class NacionalidadServiceImpl implements NacionalidadService{
	
	@Autowired
	private NacionalidadRepository nacionalidadRepository;

	@Override
	public List<InsPais> listarNacionalidad() {
		// TODO Auto-generated method stub
		return nacionalidadRepository.findByOrderByDescripcionAsc();
	}
	
	
	
	

}
