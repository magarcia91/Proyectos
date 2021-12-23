package ec.gob.educacion.service.impl.asignaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.DTO.InsJornadaDTO;
import ec.gob.educacion.repository.catalogos.InsJornadaRepository;
import ec.gob.educacion.service.asignaciones.InsJornadaService;

@Service
public class InsJornadaServiceImpl implements InsJornadaService{
	
	@Autowired
	private InsJornadaRepository insJornadaRepository;

	@Override
	public List<InsJornadaDTO> listarJornada(Integer codJornada, Integer codInstitucion) {
		
		List<InsJornadaDTO> consultas = new ArrayList<>();
		insJornadaRepository.listarJornada(codJornada, codInstitucion).forEach(objects -> {
			
			InsJornadaDTO cr = new InsJornadaDTO();	
			
			if(objects[0] == null || objects[0] == "" ) {
            }else{
            	cr.setCodJornada(Integer.parseInt(String.valueOf(objects[0])));	
				            }
			if(objects[1] == null || objects[1] == "" ) {
            }else{
            	cr.setJornadaDescripcion(String.valueOf(objects[1]));
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
