package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitModeloCalificacion;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitModeloCalificacionService  {

	TitModeloCalificacion registrar(TitModeloCalificacion titModeloCalificacion);
	TitModeloCalificacion  buscarMcaCodigo(Integer mcaCodigo);
	List<TitModeloCalificacion>  listar();
}
