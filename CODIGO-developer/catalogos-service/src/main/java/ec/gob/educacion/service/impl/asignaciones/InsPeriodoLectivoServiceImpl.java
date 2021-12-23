package ec.gob.educacion.service.impl.asignaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.DTO.Ins_peridoLectivoDTO;
import ec.gob.educacion.repository.catalogos.InsPeriodoLectivoRepository;
import ec.gob.educacion.service.asignaciones.InsPeriodoLectivoService;

@Service
public class InsPeriodoLectivoServiceImpl implements InsPeriodoLectivoService{
	
	@Autowired
	private InsPeriodoLectivoRepository insPeriodoLectivoRepository;

	@Override
	public List<Ins_peridoLectivoDTO> listarPeriodoLectivoIns(Integer CodigoIns) {
		
		List<Ins_peridoLectivoDTO> consultas = new ArrayList<>();
		insPeriodoLectivoRepository.listarPeriodoLectivoIns(CodigoIns).forEach(objects -> {
			Ins_peridoLectivoDTO cr = new Ins_peridoLectivoDTO();	
			
			if(objects[0] == null || objects[0] == "" ) {
            }else{
            	cr.setCodRegAniLec(Integer.parseInt(String.valueOf(objects[0])));	
				            }
			if(objects[1] == null || objects[1] == "" ) {
            }else{
            	cr.setCodInstitucion(Integer.parseInt(String.valueOf(objects[1])));
            }

			if(objects[2] == null || objects[2] == "" ) {
            }else{
            	cr.setRegimenDescripcion(String.valueOf(objects[2]));
            }
			if(objects[3] == null || objects[3] == "" ) {
            }else{
            	cr.setAnioInicio(Integer.parseInt(String.valueOf(objects[3])));
            }
			if(objects[4] == null || objects[4] == "" ) {
            }else{
            	cr.setAnioFin(Integer.parseInt(String.valueOf(objects[4])));
            }
						
			consultas.add(cr);
			
			
		});

		return consultas;
	}





	
	

}
