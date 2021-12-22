package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.DTO.ActividadDTO;
import ec.gob.educacion.teletrabajo.model.TelRegistroActividad;

public interface RegistroActividadRepository extends JpaRepository<TelRegistroActividad, Long> {

	@Query("select new ec.gob.educacion.teletrabajo.DTO.ActividadDTO(a.codItemCatalogo, a.nombre, a.nemonico) from TelRegistroActividad ra inner join ra.telActividad a where ra.telCabeceraRegistro.telUsuario.codUsuario = :usuario "
			+ "and ra.telCabeceraRegistro.stsEstado = :estado and ra.stsEstado = :estado and ra.telSemana.codSemana = :semana")
	List<ActividadDTO> findActivities(@Param("usuario") Long usuario, @Param("estado") String estado, @Param("semana") Long semana);
	
	@Query("select ra from TelRegistroActividad ra inner join ra.telActividad a where ra.telCabeceraRegistro.telUsuario.codUsuario = :usuario "
			+ "and ra.telCabeceraRegistro.stsEstado = :estado and ra.stsEstado = :estado and ra.telSemana.codSemana = :semana")
	List<TelRegistroActividad> findActivitiesBySemanaAndUser(@Param("usuario") Long usuario, @Param("estado") String estado, @Param("semana") Long semana);

}
