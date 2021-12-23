package ec.gob.educacion.service.asignaciones;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ec.gob.educacion.model.asignaciones.InsTipoEducacion;

import ec.gob.educacion.tit.dto.AnioLectivoRegimenDTO;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface InsTipoEducacionService  {

	
	List<InsTipoEducacion>  listarTipo();
}
