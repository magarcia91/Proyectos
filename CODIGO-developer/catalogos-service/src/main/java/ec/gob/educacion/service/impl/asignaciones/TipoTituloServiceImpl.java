package ec.gob.educacion.service.impl.asignaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.DTO.TipoTituloDTO;
import ec.gob.educacion.repository.catalogos.TipoTituloRepository;
import ec.gob.educacion.service.asignaciones.TipoTituloService;


@Service
public class TipoTituloServiceImpl implements TipoTituloService{
	
	@Autowired
	private TipoTituloRepository tipoTituloRepository;

	@Override
	public List<TipoTituloDTO> listarTipoTitulo(Integer codigoIns,Integer codRegAniLec) {
		
		List<TipoTituloDTO> consultas = new ArrayList<>();
		tipoTituloRepository.listarTipoTitulo(codigoIns,  codRegAniLec).forEach(objects -> {
			TipoTituloDTO cr = new TipoTituloDTO();	
			
			if(objects[0] == null || objects[0] == "" ) {
            }else{
            	cr.setCodTipoTitulo(Integer.parseInt(String.valueOf(objects[0])));	
				            }
			if(objects[1] == null || objects[1] == "" ) {
            }else{
            	cr.setTipoTitulo(String.valueOf(objects[1]));
            }

			if(objects[2] == null || objects[2] == "" ) {
            }else{
            	cr.setCodRegAniLec(Integer.parseInt(String.valueOf(objects[2])));
            }
			if(objects[3] == null || objects[3] == "" ) {
            }else{
            	cr.setCodInstitucion(Integer.parseInt(String.valueOf(objects[3])));
            }

						
			consultas.add(cr);
			
			
		});

		return consultas;
	}





	
	

}
