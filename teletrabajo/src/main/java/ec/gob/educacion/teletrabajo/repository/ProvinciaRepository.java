package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelProvincia;

public interface ProvinciaRepository extends JpaRepository<TelProvincia, Long> {

	@Query("Select p from TelProvincia p where p.telZona.codZona = :codZona and p.stsEstado = :estado")
	public List<TelProvincia> listarProvinciasPorZona(@Param("codZona") Long codZona, @Param("estado") String estado);
	
}
