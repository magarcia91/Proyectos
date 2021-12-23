package ec.gob.educacion.rest.util;

/**
 * Constantes
 *
 * @author Belen changoluisa
 * @version $Revision: 1 $
 * 
 */
public class Constantes {

	public static final String FORMATO_YY_MM_DD = "yyyy/mm/dd";
	public static final String REGISTRO_ACTIVO_NUM = "1";
	public static final String REGISTRO_INACTIVO_NUM = "0";
	public static final String REGISTRO_INSERT = "INS";
	public static final String REGISTRO_UPDATE = "UPD";
	public static final Integer TIPJUB_ACTIVO = 1;
	public static final Integer TIPJUB_INACTIVO = 0;
	public static final Integer TIPDES_ACTIVO = 1;
	public static final Integer TIPDES_INACTIVO = 0;
	

	// desarrollo
	 public static final String URL_REST_SEGURIDAD = "http://10.200.10.15/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	 public static final String URL_REST_ROLES = "http://10.200.10.15/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";
	 
	// preproduccion
	//public static final String URL_REST_SEGURIDAD =
	 //"https://pre-academico.educacion.gob.ec/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	 //public static final String URL_REST_ROLES =
	 //"https://pre-academico.educacion.gob.ec/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";

	// produccion
	// public static final String URL_REST_SEGURIDAD =
	// "https://academico.educarecuador.gob.ec/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	// public static final String URL_REST_ROLES =
	// "https://academico.educarecuador.gob.ec/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";

}