package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;

public interface EncuestaEstadoRepository extends JpaRepository<TelEncuestaEstado, Long> {

	
	@Query("Select t from TelEncuestaEstado t where t.telEncuesta.codCatalogo= :codigoEncuesta "
			+ "and t.stsEstado = :estado and t.telCabeceraRegistro.codCabeceraRegistro = :cabeceraRegistro ")
	public List<TelEncuestaEstado> listarPorEncuestaCabeceraRegistro(Long codigoEncuesta, Long cabeceraRegistro, String estado);

}
