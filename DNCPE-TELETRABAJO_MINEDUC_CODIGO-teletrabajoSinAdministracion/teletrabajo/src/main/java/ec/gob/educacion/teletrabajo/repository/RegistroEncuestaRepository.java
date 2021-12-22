package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelRegistroEncuesta;

public interface RegistroEncuestaRepository extends JpaRepository<TelRegistroEncuesta, Long> {

	
	@Query("Select n from TelRegistroEncuesta n where n.telCabeceraRegistro.codCabeceraRegistro = :codCabeceraRegistro and n.stsEstado = :estado")
	public List<TelRegistroEncuesta> obtenerEncuestaPorCabecera(@Param("codCabeceraRegistro") Long codCabeceraRegistro, @Param("estado") String estado);
	
	@Query("Select n from TelRegistroEncuesta n where n.telCabeceraRegistro.codCabeceraRegistro = :codCabeceraRegistro and n.stsEstado = :estado and n.telPregunta.telCatalogo.codCatalogo = :codEncuesta")
	public List<TelRegistroEncuesta> obtenerEncuestaPorCabeceraYEncuesta(@Param("codCabeceraRegistro") Long codCabeceraRegistro, @Param("codEncuesta") Long codEncuesta, @Param("estado") String estado);
	

	@Query("Select count(n) from TelRegistroEncuesta n where n.telCabeceraRegistro.codCabeceraRegistro = :codCabeceraRegistro and n.stsEstado = :estado and n.telPregunta.telCatalogo.codCatalogo = :codEncuesta")
	public long contarRespuestasGuardadas(@Param("codCabeceraRegistro") Long codCabeceraRegistro, @Param("codEncuesta") Long codEncuesta, @Param("estado") String estado);
	
}
