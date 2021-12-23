package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelClaveUsuario;

public interface ClaveUsuarioRepository extends JpaRepository<TelClaveUsuario, Long> {

	@Query("Select cu from TelClaveUsuario cu where cu.telUsuario.identificacion = :identificacion and cu.clave = :clave "
			+ "and cu.stsEstado = :estado and cu.telUsuario.stsEstado = :estado")
	TelClaveUsuario login(@Param("identificacion") String identificacion, @Param("clave") String clave,
			@Param("estado") String estado);
	
	
	@Query("Select cu from TelClaveUsuario cu where cu.telUsuario.identificacion = :identificacion and cu.telUsuario.token = :tokenUsuario "
			+ "and cu.stsEstado = :estado and cu.telUsuario.stsEstado = :estado and cu.telUsuario.correoPersonal = :correoPersonal ")
	public List<TelClaveUsuario> listaClavesUsuarioActivasRecuperacionConCorreoPersonal(@Param("identificacion") String identificacion, @Param("tokenUsuario") String tokenUsuario,
			@Param("estado") String estado, @Param("correoPersonal") String correoPersonal);
	
	@Query("Select cu from TelClaveUsuario cu where cu.telUsuario.identificacion = :identificacion and cu.telUsuario.token = :tokenUsuario "
			+ "and cu.stsEstado = :estado and cu.telUsuario.stsEstado = :estado and cu.telUsuario.correoElectronico = :correoInstitucional ")
	public List<TelClaveUsuario> listaClavesUsuarioActivasRecuperacionConCorreoInstitucional(@Param("identificacion") String identificacion, @Param("tokenUsuario") String tokenUsuario,
			@Param("estado") String estado, @Param("correoInstitucional") String correoInstitucional);
	
	@Query("Select cu from TelClaveUsuario cu where cu.telUsuario.identificacion = :identificacion and cu.telUsuario.token = :tokenUsuario "
			+ "and cu.stsEstado = :estado and cu.telUsuario.stsEstado = :estado and cu.telUsuario.anioExpedicionCedula = :anioExpedicionCedula ")
	public List<TelClaveUsuario> listaClavesUsuarioActivasRecuperacionConAnioExpedicion(@Param("identificacion") String identificacion, @Param("tokenUsuario") String tokenUsuario,
			@Param("estado") String estado, @Param("anioExpedicionCedula") Integer anioExpedicionCedula);
	
	@Query("Select cu from TelClaveUsuario cu where cu.telUsuario.codUsuario = :codigoUsuario order by cu.codClaveUsuario desc ")
	public Page<TelClaveUsuario> getClavesCoincidenConActual(@Param("codigoUsuario") Long codigoUsuario, @Param("cantidadClavesBuscar") Pageable cantidadClavesBuscar);
		

}
