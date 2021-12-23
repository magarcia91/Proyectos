package ec.gob.educacion.service.tit;

import java.util.List;

import ec.gob.educacion.model.tit.TitParticipacionEst;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TitParticipacionEstService  {

	TitParticipacionEst registrarParticipacionEst(TitParticipacionEst titParticipacionEst);
	TitParticipacionEst  buscarPesCodigo(Integer pesCodigo);
	List<TitParticipacionEst>  listarParticipacionEst();
}
