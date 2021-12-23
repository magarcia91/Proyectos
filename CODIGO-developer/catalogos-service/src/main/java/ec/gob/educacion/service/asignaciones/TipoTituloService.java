package ec.gob.educacion.service.asignaciones;

import java.util.List;

import ec.gob.educacion.model.DTO.TipoTituloDTO;


/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface TipoTituloService  {

	
	List<TipoTituloDTO>  listarTipoTitulo(Integer codigoIns, Integer codRegAniLec);
}
