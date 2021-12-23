package ec.gob.educacion.service.asignaciones;

import java.util.List;

import ec.gob.educacion.model.DTO.InsJornadaDTO;


/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface InsJornadaService  {

	
	List<InsJornadaDTO>  listarJornada(Integer codJornada, Integer codInstitucion);
}
