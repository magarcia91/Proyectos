package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelCatalogo;

public interface CatalogoRepository extends JpaRepository<TelCatalogo, Long> {

	
	
	@Query("Select u from TelCatalogo u where u.stsEstado = :estado ")
	public TelCatalogo listarCatalogosPorEstado(@Param("estado") String estado);
	
	@Query("Select distinct t.telEncuesta from TelEncuestaOferta t where t.stsEstado = :estado and t.telEncuesta.stsEstado = :estado and t.telOfertaEducativa.codItemCatalogo = :codigoOfertaEducativa order by t.telEncuesta.nombre asc")
	public List<TelCatalogo> listarEncuestasPorEstadoYOfertaEducativa(@Param("codigoOfertaEducativa") Long codigoOfertaEducativa, @Param("estado") String estado);
	
	@Query("Select t from TelCatalogo t where t.stsEstado = :estado and t.nemonico = :nemonicoEncuestas order by t.nombre asc")
	public List<TelCatalogo> listarEncuestasActivas(@Param("estado") String estado, @Param("nemonicoEncuestas") String nemonicoEncuestas);
	
	@Query("Select u from TelCatalogo u where u.codCatalogo = :codigoCatalogo and u.stsEstado = :estado ")
	public TelCatalogo obtenerPorCodigoYEstado(@Param("codigoCatalogo") Long codigoCatalogo, @Param("estado") String estado);

}
