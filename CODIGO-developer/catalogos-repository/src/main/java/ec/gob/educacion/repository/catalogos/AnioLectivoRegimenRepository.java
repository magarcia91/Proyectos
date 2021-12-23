package ec.gob.educacion.repository.catalogos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.InsRegAniLec;

@Repository
public interface AnioLectivoRegimenRepository extends JpaRepository<InsRegAniLec, Integer>{
	
	@Query(nativeQuery = true , value = "SELECT \r\n"
			+ "ASIGNACIONES.INS_REG_ANI_LEC.CODIGO,\r\n"
			+ "ASIGNACIONES.INS_INC_REGIMEN.DESCRIPCION REGIMEN,\r\n"
			+ "ASIGNACIONES.INS_INC_ANIO_LECTIVO.ANIO_INICIO,\r\n"
			+ "ASIGNACIONES.INS_INC_ANIO_LECTIVO.ANIO_FIN  \r\n"
			+ "FROM \r\n"
			+ "ASIGNACIONES.INS_REG_ANI_LEC \r\n"
			+ "INNER JOIN ASIGNACIONES.INS_INC_REGIMEN ON ASIGNACIONES.INS_REG_ANI_LEC.COD_INC_REGIMEN = ASIGNACIONES.INS_INC_REGIMEN.CODIGO\r\n"
			+ "INNER JOIN ASIGNACIONES.INS_INC_ANIO_LECTIVO ON ASIGNACIONES.INS_REG_ANI_LEC.COD_INC_ANIO_LECTIVO = ASIGNACIONES.INS_INC_ANIO_LECTIVO.CODIGO\r\n"
			+ "WHERE\r\n"
			+ "ASIGNACIONES.INS_REG_ANI_LEC.ESTADO = 1\r\n"
			+ "ORDER BY ANIO_INICIO, REGIMEN")
			List<Object[]>  listarA();
	

}
