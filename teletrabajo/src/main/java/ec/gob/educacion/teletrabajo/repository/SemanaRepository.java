package ec.gob.educacion.teletrabajo.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TlSemana;

public interface SemanaRepository extends JpaRepository<TlSemana, Long> {

	@Query("Select s from TlSemana s where s.stsEstado = :estado order by s.fechaInicio desc")
	List<TlSemana> findAll(@Param("estado") String estado);

	@Query("Select s from TlSemana s where s.stsEstado = :estado and s.fechaInicio = :fechaInicio and s.fechaFin = :fechaFin")
	List<TlSemana> findSemanaEstado(@Param("estado") String estado, @Param("fechaInicio") Timestamp fechaInicio,
			@Param("fechaFin") Timestamp fechaFin);
	
	@Query("Select s from TlSemana s where DATE_TRUNC('day', s.fechaInicio) = :fechaInicio and DATE_TRUNC('day', s.fechaFin) = :fechaFin order by s.codSemana desc")
	List<TlSemana> findSemanaFechaTruncada(@Param("fechaInicio") Date fechaInicio,
			@Param("fechaFin") Date fechaFin);
	
}
