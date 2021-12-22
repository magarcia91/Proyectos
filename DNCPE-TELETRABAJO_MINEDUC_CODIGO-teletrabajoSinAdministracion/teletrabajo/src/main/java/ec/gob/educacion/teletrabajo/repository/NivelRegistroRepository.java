package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelNivelRegistro;

public interface NivelRegistroRepository extends JpaRepository<TelNivelRegistro, Long> {

	
	@Query("Select n from TelNivelRegistro n where n.telCabeceraRegistro.codCabeceraRegistro = :codCabeceraRegistro and n.stsEstado = :estado")
	public List<TelNivelRegistro> obtenerNivelesRegistradosPorCabecera(@Param("codCabeceraRegistro") Long codCabeceraRegistro, @Param("estado") String estado);
	
}
