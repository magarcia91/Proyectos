package ec.gob.educacion.teletrabajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;

public interface CabeceraRegistroRepository extends JpaRepository<TelCabeceraRegistro, Long> {

	@Query("Select cr from TelCabeceraRegistro cr where cr.stsEstado = :estado and cr.telUsuario.codUsuario = :usuario")
	TelCabeceraRegistro findCabeceraByUser(@Param("estado") String estado, @Param("usuario") Long usuario);
	
	
	@Query("Select c from TelCabeceraRegistro c where c.telUsuario.identificacion = :identificacion "
			+ "and c.stsEstado = :estado and c.telUsuario.stsEstado = :estado ")
	public TelCabeceraRegistro obtenerCabeceraRegistroUsuario(@Param("identificacion") String identificacion, @Param("estado") String estado);
	

}
