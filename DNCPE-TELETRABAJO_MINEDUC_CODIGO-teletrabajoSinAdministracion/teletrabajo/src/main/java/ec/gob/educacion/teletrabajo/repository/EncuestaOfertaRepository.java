package ec.gob.educacion.teletrabajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.gob.educacion.teletrabajo.model.TelEncuestaOferta;

public interface EncuestaOfertaRepository extends JpaRepository<TelEncuestaOferta, Long> {

	
	@Query("Select count(c) from TelEncuestaOferta c where c.telOfertaEducativa.codItemCatalogo= :codigoOfertaEducativa "
			+ "and c.stsEstado = :estado ")
	public long contarEncuestasHabilitadas(long codigoOfertaEducativa, String estado);

}
