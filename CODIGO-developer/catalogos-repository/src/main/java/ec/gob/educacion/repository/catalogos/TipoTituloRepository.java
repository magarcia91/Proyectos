package ec.gob.educacion.repository.catalogos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.asignaciones.InsCursoCenso;

@Repository
public interface TipoTituloRepository extends JpaRepository<InsCursoCenso, Integer>{
	
	@Query(nativeQuery = true , value ="SELECT\r\n"
			+ "DISTINCT\r\n"
			+ "DECODE (ASIGNACIONES.INS_CURSO_CENSO.COD_ESPECIALIDAD, NULL , 0 , COD_ESPECIALIDAD, 99) COD_TIPO_TITULO, \r\n"
			+ "DECODE (ASIGNACIONES.INS_CURSO_CENSO.COD_ESPECIALIDAD, NULL , 'CIENCIAS' , COD_ESPECIALIDAD, 'TECNICO') TIPO_TITULO, \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_REG_ANI_LEC COD_REG_ANI_LEC, \r\n"
			+ "ASIGNACIONES.INS_INSTITUCION.CODIGO COD_INSTITUCION \r\n"
			+ "FROM \r\n"
			+ "ASIGNACIONES.INS_INSTITUCION \r\n"
			+ "INNER JOIN ASIGNACIONES.INS_CURSO_CENSO ON ASIGNACIONES.INS_INSTITUCION.CODIGO = ASIGNACIONES.INS_CURSO_CENSO.COD_INSTITUCION \r\n"
			+ "WHERE \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.ESTADO = 1 AND \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_GRADO IN (16,19) AND  \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_REG_ANI_LEC =:codRegAniLec AND \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_JORNADA = 1 AND \r\n"
			+ "ASIGNACIONES.INS_CURSO_CENSO.COD_MODALIDAD = 2 AND \r\n"
			+ "ASIGNACIONES.INS_INSTITUCION.CODIGO =:codigoIns")
			List<Object[]>  listarTipoTitulo(@Param("codigoIns") Integer codigoIns, @Param("codRegAniLec") Integer codRegAniLec);
	

}
