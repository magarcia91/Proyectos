package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitRefrendacion;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitRefrendacionService  {

	TitRefrendacion registrarRefrendacion(TitRefrendacion titRefrendacion);
	TitRefrendacion  buscarRefCodigo(Integer refCodigo);
	List<TitRefrendacion>  listarRefrendacion();
}
