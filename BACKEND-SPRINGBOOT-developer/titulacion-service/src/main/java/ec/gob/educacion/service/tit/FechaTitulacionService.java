package ec.gob.educacion.service.tit;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ec.gob.educacion.model.tit.TitFechaTitulacion;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface FechaTitulacionService  {

	TitFechaTitulacion registrar(TitFechaTitulacion titFechaTitulacion);
	TitFechaTitulacion  buscarCodigo(long ftiCodigo);
	List<TitFechaTitulacion>  listar();
	List<TitFechaTitulacion>  listarRegionTipo(Integer codRegAniLec, Integer codTipoEducacion);
}
