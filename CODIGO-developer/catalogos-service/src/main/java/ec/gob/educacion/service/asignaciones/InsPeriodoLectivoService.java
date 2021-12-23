package ec.gob.educacion.service.asignaciones;

import java.util.List;

import ec.gob.educacion.model.DTO.Ins_peridoLectivoDTO;


/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface InsPeriodoLectivoService  {

	
	List<Ins_peridoLectivoDTO>  listarPeriodoLectivoIns(Integer CodigoIns);
}
