package ec.gob.educacion.service.impl.asignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.asignaciones.InsTipoEducacion;
import ec.gob.educacion.repository.catalogos.InsTipoEducacionRepository;
import ec.gob.educacion.service.asignaciones.InsTipoEducacionService;
import ec.gob.educacion.service.util.Constantes;


@Service
public class InsTipoEducacionServiceImpl implements InsTipoEducacionService{
	
	@Autowired
	private InsTipoEducacionRepository insTipoEducacionRepository;

	@Override
	public List<InsTipoEducacion> listarTipo() {
		// TODO Auto-generated method stub

		return insTipoEducacionRepository.findByEstado(Constantes.REGISTRO_ACTIVO);
	}





	
	

}
