package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;

public interface ItemCatalogoRepository extends JpaRepository<TelItemCatalogo, Long> {

	@Query("Select ic from TelItemCatalogo ic where ic.telCatalogo.nemonico = :nemonico "
			+ "and ic.stsEstado = :estado and ic.telCatalogo.stsEstado = :estado order by ic.codItemCatalogo asc")
	public List<TelItemCatalogo> listarPorNemonicoCatalogo(@Param("nemonico") String nemonico, @Param("estado") String estado);
	
	@Query("Select ic from TelItemCatalogo ic where ic.telCatalogo.codCatalogo = :codigoCatalogo "
			+ "and ic.stsEstado = :estado and ic.telCatalogo.stsEstado = :estado order by ic.codItemCatalogo asc")
	public List<TelItemCatalogo> listarPorCodigoCatalogo(@Param("codigoCatalogo") Long codigoCatalogo, @Param("estado") String estado);
	
	@Query("Select ic from TelItemCatalogo ic where ic.itemCatalogoPadre = :codigoPadre "
			+ "and ic.stsEstado = :estado and ic.telCatalogo.nemonico = :nemonicoCatalogo order by ic.codItemCatalogo asc ")
	public List<TelItemCatalogo> listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(@Param("nemonicoCatalogo") String nemonicoCatalogo, @Param("codigoPadre") Long codigoPadre, @Param("estado") String estado);
	
	@Query("Select ic from TelItemCatalogo ic where ic.nemonico = :nemonico and ic.stsEstado = :estado ")
	public TelItemCatalogo obtenerPorNemonico(@Param("nemonico") String nemonico, @Param("estado") String estado);

}
