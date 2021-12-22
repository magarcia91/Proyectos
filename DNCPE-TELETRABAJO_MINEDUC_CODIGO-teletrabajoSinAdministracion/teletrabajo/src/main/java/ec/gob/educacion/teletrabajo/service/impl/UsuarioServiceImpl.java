package ec.gob.educacion.teletrabajo.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.ResponseLoginDTO;
import ec.gob.educacion.teletrabajo.enums.AdministracionEncuestaEnum;
import ec.gob.educacion.teletrabajo.enums.CatalogoEnum;
import ec.gob.educacion.teletrabajo.enums.EstadoClaveEnum;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCatalogo;
import ec.gob.educacion.teletrabajo.model.TelClaveUsuario;
import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.model.TelUsuario;
import ec.gob.educacion.teletrabajo.repository.ClaveUsuarioRepository;
import ec.gob.educacion.teletrabajo.repository.UsuarioRepository;
import ec.gob.educacion.teletrabajo.service.CatalogoService;
import ec.gob.educacion.teletrabajo.service.ItemCatalogoService;
import ec.gob.educacion.teletrabajo.service.UsuarioService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.TokenUtil;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioServiceImpl.class.getName());

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ClaveUsuarioRepository claveUsuarioRepository;
	@Autowired
	private ItemCatalogoService itemCatalogoService;
	@Autowired
	private CatalogoService catalogoService;

	@Override
	public ResponseLoginDTO login(String identificacion, String password) {
		ResponseLoginDTO result = new ResponseLoginDTO();
		try {
			String passEncrypt = Util.encodeMD5(password);
			//TelUsuario user = usuarioRepository.login(identificacion, passEncrypt, EstadoEnum.ACTIVO.getValor());
			//TelItemCatalogo encuestaHabilitada = itemCatalogoService.obtenerPorNemonico(AdministracionEncuestaEnum.HABILITACION_ENCUESTA.getNemonico(), EstadoEnum.ACTIVO.getValor());
			List<TelCatalogo> encuestasHabilitadas = catalogoService.listarEncuestasPorEstado(EstadoEnum.ACTIVO.getValor(), CatalogoEnum.ENCUESTAS.getNemonico());
			TelClaveUsuario claveUsuario = claveUsuarioRepository.login(identificacion, passEncrypt, EstadoEnum.ACTIVO.getValor());	
			TelUsuario user = claveUsuario != null ? claveUsuario.getTelUsuario(): null;
			if (user != null) {
				if (validarPicoyPlaca(user)) {
					Map<String, Object> claims = new HashMap<String, Object>();
					claims.put(Constantes.TOKEN_CODE, user.getCodUsuario());
					claims.put(Constantes.TOKEN_ROL, user.getRol());
					claims.put(Constantes.TOKEN_IDENTIFICACION, user.getIdentificacion());
					String customToken = TokenUtil.createJWTWithCustomClaims("" + user.getCodUsuario(), "teletrabajo",
							"teletrabajo", Constantes.VALID_TOKEN_TIME, claims);
					result.setNombre(user.getNombresApellidos());
					result.setUserCode(user.getCodUsuario());
					result.setPassCode(claveUsuario.getCodClaveUsuario());
					result.setRole(user.getRol());
					result.setIdentificacion(user.getIdentificacion());
					result.setZona(user.getZona());
					result.setDistrito(user.getDpaDistrito());
					result.setCodigoError(Constantes.GENERAL_OK_CODE);
					result.setMensaje(Constantes.GENERAL_MSG_OK);
					result.setToken(customToken);
					result.setCambioObligatorioClave(claveUsuario.getStsEstadoClave() == null || claveUsuario.getStsEstadoClave().equals(EstadoClaveEnum.RESETEO.getNemonico()));
					//result.setHabilitadaEncuesta(encuestaHabilitada!=null&&encuestaHabilitada.getValorHabilitante()!=null?encuestaHabilitada.getValorHabilitante().equals(1):false);
					result.setHabilitadaEncuesta(!encuestasHabilitadas.isEmpty());
				} else {
					result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
					result.setMensaje(getMessageZone());
				}

			} else {
				result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
				result.setMensaje("Usuario y/o contraseña incorrecto");
			}
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}

	public TelUsuario obtenerPorIdentificacion(String identificacion) {
		return usuarioRepository.obtenerPorIdentificacion(identificacion, EstadoEnum.ACTIVO.getValor());
	}

	private Boolean validarPicoyPlaca(TelUsuario usuario) {
		Boolean result = false;
		Calendar cal = Calendar.getInstance();
		Integer day = cal.get(Calendar.DAY_OF_WEEK);

		switch (day) {
		case 2:
			if (usuario.getZona() == 1 || usuario.getZona() == 7 || usuario.getZona() == 10) {
				result = true;
			}
			break;
		case 3:
			if (usuario.getZona() == 2 || usuario.getZona() == 4 || usuario.getZona() == 10) {
				result = true;
			}
			break;
		case 4:
			if (usuario.getZona() == 3 || usuario.getZona() == 6 || usuario.getZona() == 10) {
				result = true;
			}
			break;
		case 5:
			if (usuario.getZona() == 5 || usuario.getZona() == 10) {
				result = true;
			}
			break;
		case 6:
			if (usuario.getZona() == 8 || usuario.getZona() == 9 || usuario.getZona() == 10) {
				result = true;
			}
			break;

		default:
			break;
		}

		return result;
	}
	
	private String getMessageZone() {
		return "<p style=\"text-align: center;\"><em>Lo sentimos, el sistema no se encuentra habilitado para su zona:</em></p>\r\n" + 
				"<table style=\"text-align: center;\" border=\"1\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<p style=\"text-align: center;\"><strong><em>D&iacute;a</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<p style=\"text-align: center;\"><strong><em>ZONAS</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<p><strong><em>lunes</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<p><em>1 (Carchi, Esmeraldas, Imbabura y Sucumb&iacute;os) y</em></p>\r\n" + 
				"<p><em>7 (El Oro, Loja y Zamora Chinchipe)</em></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<p><strong><em>martes</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<p><em>2 (Napo, Orellana y Pichincha, excepto Quito) y</em></p>\r\n" + 
				"<p><em>4 (Manab&iacute; y Santo Domingo de los Ts&aacute;chilas)</em></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<p><strong><em>mi&eacute;rcoles</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<p><em>3 (Cotopaxi, Chimborazo, Tungurahua y Pastaza) y</em></p>\r\n" + 
				"<p><em>6 (Azuay, Ca&ntilde;ar y Morona Santiago)</em></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<p><strong><em>jueves</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<p><em>5 (Bol&iacute;var, Guayas, Los R&iacute;os, Santa Elena y Gal&aacute;pagos)</em></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<p><strong><em>viernes</em></strong></p>\r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<p><em>8 (Guayaquil, Dur&aacute;n y Samborond&oacute;n) y</em></p>\r\n" + 
				"<p><em>9 (Quito)</em></p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>";
	}

}
