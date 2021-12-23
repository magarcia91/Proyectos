package ec.gob.educacion.repository.catalogos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.InsRegAniLec;

@Repository
public interface InsPeriodoLectivoRepository extends JpaRepository<InsRegAniLec, Integer>{
	
	@Query(nativeQuery = true , value = "SELECT\r\n"
			+ "DISTINCT\r\n"
			+ "ASIGNACIONES.INS_REG_ANI_LEC.CODIGO COD_REG_ANI_LEC,\r\n"
			+ "ASIGNACIONES.INS_INSTITUCION.CODIGO COD_INSTITUCION,\r\n"
			+ "ASIGNACIONES.INS_INC_REGIMEN.DESCRIPCION,\r\n"
			+ "ASIGNACIONES.INS_INC_ANIO_LECTIVO.ANIO_INICIO,\r\n"
			+ "ASIGNACIONES.INS_INC_ANIO_LECTIVO.ANIO_FIN\r\n"
			+ "FROM\r\n"
			+ "ASIGNACIONES.INS_INSTITUCION\r\n"
			+ "INNER JOIN ASIGNACIONES.INS_CURSO_CENSO ON ASIGNACIONES.INS_INSTITUCION.CODIGO = ASIGNACIONES.INS_CURSO_CENSO.COD_INSTITUCION\r\n"
			+ "INNER JOIN ASIGNACIONES.INS_REG_ANI_LEC ON ASIGNACIONES.INS_CURSO_CENSO.COD_REG_ANI_LEC = ASIGNACIONES.INS_REG_ANI_LEC.CODIGO\r\n"
			+ "INNER JOIN ASIGNACIONES.INS_INC_REGIMEN ON ASIGNACIONES.INS_REG_ANI_LEC.COD_INC_REGIMEN = ASIGNACIONES.INS_INC_REGIMEN.CODIGO\r\n"
			+ "INNER JOIN ASIGNACIONES.INS_INC_ANIO_LECTIVO ON ASIGNACIONES.INS_REG_ANI_LEC.COD_INC_ANIO_LECTIVO = ASIGNACIONES.INS_INC_ANIO_LECTIVO.CODIGO\r\n"
			+ "WHERE\r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.ESTADO = 1 AND\r\n"
			+ "ASIGNACIONES.INS_REG_ANI_LEC.ESTADO = 1 AND \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_GRADO IN (16,19) AND\r\n"
			+ "ASIGNACIONES.INS_INSTITUCION.CODIGO =:CodigoIns\r\n"
			+ "ORDER BY ASIGNACIONES.INS_REG_ANI_LEC.CODIGO")
			List<Object[]>  listarPeriodoLectivoIns(@Param("CodigoIns") Integer CodigoIns);
	

}
