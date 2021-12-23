package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitConsejoEjec;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitConsejoEjecService  {


	TitConsejoEjec registrar(TitConsejoEjec titConsejoEjec);
	TitConsejoEjec  buscarAutCodigo(Integer autCodigo);
	List<TitConsejoEjec>  listar();
}
