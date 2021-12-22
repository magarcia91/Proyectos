package ec.gob.educacion.teletrabajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelUsuario;

public interface UsuarioRepository extends JpaRepository<TelUsuario, Long> {

	@Query("Select u from TelClaveUsuario cu inner join cu.telUsuario u where u.identificacion = :identificacion and cu.clave = :clave "
			+ "and cu.stsEstado = :estado and u.stsEstado = :estado")
	TelUsuario login(@Param("identificacion") String identificacion, @Param("clave") String clave,
			@Param("estado") String estado);
	
	
	@Query("Select u from TelUsuario u where u.identificacion = :identificacion  "
			+ "and u.stsEstado = :estado ")
	TelUsuario obtenerPorIdentificacion(@Param("identificacion") String identificacion,
			@Param("estado") String estado);

}
