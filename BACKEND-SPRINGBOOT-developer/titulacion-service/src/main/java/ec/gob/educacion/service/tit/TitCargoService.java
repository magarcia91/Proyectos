package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitCargo;
/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitCargoService  {

	TitCargo registrarCargo(TitCargo titCargo);
	TitCargo  buscarCarCodigo(Integer carCodigo);
	List<TitCargo>  listarCargo();
}
