package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitParametro;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitParametroService  {

	TitParametro registrar(TitParametro titParametro);
	TitParametro  buscarCodigo(Integer codigo);
	List<TitParametro>  listar();
}
