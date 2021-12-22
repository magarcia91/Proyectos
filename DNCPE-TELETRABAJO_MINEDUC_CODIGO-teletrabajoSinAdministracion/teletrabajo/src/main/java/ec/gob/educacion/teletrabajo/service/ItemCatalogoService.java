package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;

public interface ItemCatalogoService {

	public List<TelItemCatalogo> listarPorNemonicoCatalogo(String nemonico, String estado);
	
	public List<TelItemCatalogo> listarPorCodigoCatalogo(Long codigoCatalogo, String estado);
	
	public List<TelItemCatalogo> listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(String nemonicoCatalogo, Long codigoPadre, String estado);
	
	public TelItemCatalogo obtenerPorNemonico(String nemonico, String estado);

}
