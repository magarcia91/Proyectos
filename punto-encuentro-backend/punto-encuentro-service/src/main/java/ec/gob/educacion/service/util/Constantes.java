package ec.gob.educacion.service.util;

import java.math.BigDecimal;

/**
 * Constantes
 *
 * @author Belen changoluisa
 * @version $Revision: 1 $
 * 
 */
public class Constantes {

	public static final String FORMATO_YY_MM_DD="yyyy/mm/dd";
	public static final Integer REGISTRO_ACTIVO_NUM = 1;
	public static final BigDecimal REGISTRO_ACTIVO = BigDecimal.valueOf(1);
	public static final String REGISTRO_INACTIVO_NUM = "0";
	public static final String REGISTRO_INSERT = "INS";
	public static final String REGISTRO_UPDATE = "UPD";
	//desarrollo
	public static final String URL_REST_SEGURIDAD = "http://10.200.10.15/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	//preproduccion
    //public static final String URL_REST_SEGURIDAD = "https://pre-academico.educacion.gob.ec/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	//produccion
     //public static final String URL_REST_SEGURIDAD = "https://academico.educarecuador.gob.ec/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	
	//public static final String URL_REST_SEGURIDAD = "http://localhost:8037/usuario/public/seguridadUsuario";

	public static final String URL_REST_ROLES = "http://10.200.10.15//serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";
			
//	public static final String URL_REST_SEGURIDAD = "https://academico.educarecuador.gob.ec/serviciosEducacion-web/resources/ValidarUsuarioSeguridadesEduca/Validar";
//	public static final String URL_REST_SEGURIDAD = "https://pre-academico.educacion.gob.ec/serviciosEducacion-web/resources/ValidarUsuarioSeguridadesEduca/Validar";


}