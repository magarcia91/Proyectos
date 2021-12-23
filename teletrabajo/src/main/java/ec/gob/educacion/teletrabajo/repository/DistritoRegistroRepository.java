package ec.gob.educacion.teletrabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.educacion.teletrabajo.model.TelDistritoRegistro;

public interface DistritoRegistroRepository extends JpaRepository<TelDistritoRegistro, Long> {

	
	@Query("Select n from TelDistritoRegistro n where n.telCabeceraRegistro.codCabeceraRegistro = :codCabeceraRegistro and n.stsEstado = :estado")
	public List<TelDistritoRegistro> obtenerDistritosRegistradosPorCabecera(@Param("codCabeceraRegistro") Long codCabeceraRegistro, @Param("estado") String estado);
	
}
