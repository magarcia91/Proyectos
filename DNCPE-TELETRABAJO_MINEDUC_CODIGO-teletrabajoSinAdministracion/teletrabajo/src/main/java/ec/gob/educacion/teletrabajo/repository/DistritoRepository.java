package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelDistrito;

public interface DistritoRepository extends JpaRepository<TelDistrito, Long> {

	@Query("Select d from TelDistrito d where d.dpaDistrito = :dpaDistrito and d.stsEstado = :estado")
	public TelDistrito obtenerDistritoPorDpa(@Param("dpaDistrito") String dpaDistrito, @Param("estado") String estado);
	
	@Query("Select d from TelDistrito d where d.telProvincia.codProvincia = :codProvincia and d.stsEstado = :estado")
	public List<TelDistrito> obtenerDistritoPorCodProvincia(@Param("codProvincia") Long codProvincia, @Param("estado") String estado);
	
	@Query("Select d from TelDistrito d where d.telProvincia.telZona.codZona = :codZona and d.stsEstado = :estado")
	public List<TelDistrito> obtenerDistritosPorZona(@Param("codZona") Long codZona, @Param("estado") String estado);
	
}
