package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelInsEducativa;

public interface InsEducativaRepository extends JpaRepository<TelInsEducativa, Long> {

	@Query("Select i from TelInsEducativa i where i.telDistrito.codDistrito = :codDistrito and i.stsEstado = :estado order by i.amie asc")
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistrito(@Param("codDistrito") Long codDistrito, @Param("estado") String estado);
	
	@Query("Select i from TelInsEducativa i where i.nemonicoOfertaEducativa = :nemonicoOferta and i.stsEstado = :estado order by i.amie asc")
	public List<TelInsEducativa> listarInstitucionesEducativasPorOfertaEducativa(@Param("nemonicoOferta") String nemonicoOferta, @Param("estado") String estado);
	
	@Query("Select i from TelInsEducativa i where i.telDistrito.codDistrito = :codDistrito and i.nemonicoOfertaEducativa = :nemonicoOferta and i.stsEstado = :estado order by i.amie asc")
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistritoYOferta(@Param("nemonicoOferta") String nemonicoOferta, @Param("codDistrito") Long codDistrito, @Param("estado") String estado);
	
}
