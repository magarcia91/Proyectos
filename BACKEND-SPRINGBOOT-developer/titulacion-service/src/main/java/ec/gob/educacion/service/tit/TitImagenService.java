package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitImagen;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitImagenService  {

	TitImagen registrarImagen(TitImagen titImagen);
	TitImagen  buscarImgCodigo(Integer imgCodigo);
	List<TitImagen>  listarImagen();
}
