package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelZona;

public interface ZonaRepository extends JpaRepository<TelZona, Long> {

	@Query("Select z from TelZona z where z.stsEstado = :estado")
	public List<TelZona> listarZonas(@Param("estado") String estado);
	
}
