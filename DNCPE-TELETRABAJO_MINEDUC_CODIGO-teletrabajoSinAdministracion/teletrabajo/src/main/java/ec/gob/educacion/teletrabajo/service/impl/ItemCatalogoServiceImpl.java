package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.repository.ItemCatalogoRepository;
import ec.gob.educacion.teletrabajo.service.ItemCatalogoService;

@Service
public class ItemCatalogoServiceImpl implements ItemCatalogoService {

	@Autowired
	private ItemCatalogoRepository itemCatalogoRepository;

	
	
	public List<TelItemCatalogo> listarPorNemonicoCatalogo(String nemonico, String estado){
		return itemCatalogoRepository.listarPorNemonicoCatalogo(nemonico, estado);
	}
	
	public List<TelItemCatalogo> listarPorCodigoCatalogo(Long codigoCatalogo, String estado){
		return itemCatalogoRepository.listarPorCodigoCatalogo(codigoCatalogo, estado);
	}
	
	public List<TelItemCatalogo> listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(String nemonicoCatalogo, Long codigoPadre, String estado){
		return itemCatalogoRepository.listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(nemonicoCatalogo, codigoPadre, estado);
	}
	
	public TelItemCatalogo obtenerPorNemonico(String nemonico, String estado) {
		return itemCatalogoRepository.obtenerPorNemonico(nemonico, estado);
	}

}
