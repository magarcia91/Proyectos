package ec.gob.educacion.service.impl.asignaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.repository.catalogos.AnioLectivoRegimenRepository;
import ec.gob.educacion.service.asignaciones.AnioLectivoRegimenService;
import ec.gob.educacion.tit.dto.AnioLectivoRegimenDTO;


@Service
public class AnioLectivoRegimenServiceImpl implements AnioLectivoRegimenService{
	
	@Autowired
	private AnioLectivoRegimenRepository anioLectivoRegimenRepository;

	@Override
	public List<AnioLectivoRegimenDTO> listarA() {
		// TODO Auto-generated method stub
		
		List<AnioLectivoRegimenDTO> consultas = new ArrayList<>();
		anioLectivoRegimenRepository.listarA().forEach(objects -> {
			AnioLectivoRegimenDTO cr = new AnioLectivoRegimenDTO();	
			
			if(objects[0] == null || objects[0] == "" ) {
            }else{
            	cr.setCodigo(Integer.parseInt(String.valueOf(objects[0])));	
				            }
			if(objects[1] == null || objects[1] == "" ) {
            }else{
            	cr.setDescripcion(String.valueOf(objects[1]));
            }

			if(objects[2] == null || objects[2] == "" ) {
            }else{
            	cr.setAnioInicio(Integer.parseInt(String.valueOf(objects[2])));
            }
			if(objects[3] == null || objects[3] == "" ) {
            }else{
            	cr.setAnioFin(Integer.parseInt(String.valueOf(objects[3])));
            }
						
			consultas.add(cr);
			
			
		});

		return consultas;
	}





	
	

}
