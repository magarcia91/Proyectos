package ec.gob.educacion.jubilaciones.util;

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

	// desarrollo
	public static final String URL_REST_SEGURIDAD = "http://10.200.10.15/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	public static final String URL_REST_ROLES = "http://10.200.10.15/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";
	public static final Integer TIPJUB_ACTIVO = 1;
	public static final Integer TIPDIS_ACTIVO = 1;
	public static final Integer TIPJUB_INACTIVO = 0;
	public static final Integer TIPDIS_INACTIVO = 0;
	public static final Integer PARESTADO_ACTIVO = 1;
	public static final Integer PARESTADO_INACTIVO = 0;
	 
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