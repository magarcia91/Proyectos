package ec.gob.educacion.repository.catalogos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.InsJornada;
import ec.gob.educacion.model.asignaciones.InsRegAniLec;

@Repository
public interface InsJornadaRepository extends JpaRepository<InsJornada, Integer>{
	
	@Query(nativeQuery = true , value = "SELECT \r\n"
			+ "DISTINCT\r\n"
			+ "ASIGNACIONES.INS_JORNADA.CODIGO COD_JORNADA,\r\n"
			+ "ASIGNACIONES.INS_JORNADA.DESCRIPCION JORNADA,\r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_REG_ANI_LEC COD_REG_ANI_LEC,\r\n"
			+ "ASIGNACIONES.INS_INSTITUCION.CODIGO COD_INSTITUCION \r\n"
			+ "FROM \r\n"
			+ "ASIGNACIONES.INS_INSTITUCION \r\n"
			+ "INNER JOIN ASIGNACIONES.INS_CURSO_CENSO ON ASIGNACIONES.INS_INSTITUCION.CODIGO = ASIGNACIONES.INS_CURSO_CENSO.COD_INSTITUCION \r\n"
			+ "INNER JOIN ASIGNACIONES.INS_JORNADA ON ASIGNACIONES.INS_CURSO_CENSO.COD_JORNADA = ASIGNACIONES.INS_JORNADA.CODIGO \r\n"
			+ "WHERE \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.ESTADO = 1 AND\r\n"
			+ "ASIGNACIONES.INS_JORNADA.ESTADO = 1 AND\r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_GRADO IN (16,19) AND\r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_REG_ANI_LEC =:codInstitucion AND\r\n"
			+ "ASIGNACIONES.INS_INSTITUCION.CODIGO =:codJornada")
			List<Object[]>  listarJornada(@Param("codJornada") Integer codJornada, @Param("codInstitucion") Integer codInstitucion);
	

}
