package ec.gob.educacion.teletrabajo.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.RecuperarClaveDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoClaveEnum;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelClaveUsuario;
import ec.gob.educacion.teletrabajo.model.TelUsuario;
import ec.gob.educacion.teletrabajo.repository.ClaveUsuarioRepository;
import ec.gob.educacion.teletrabajo.repository.UsuarioRepository;
import ec.gob.educacion.teletrabajo.service.ClaveUsuarioService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.UserMailerService;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class ClaveUsuarioServiceImpl implements ClaveUsuarioService {

	private static final Logger LOGGER = Logger.getLogger(ClaveUsuarioServiceImpl.class.getName());

	@Autowired
	private UserMailerService mailerService;
	@Autowired
	private ClaveUsuarioRepository claveUsuarioRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public DefaultDTO guardarClave(String token, TelClaveUsuario claveUsuario) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);
			String passEncrypt = Util.encodeMD5(claveUsuario.getClave());
			if (!validarCantidadClavesCoincidentes(dto.getUserId(), passEncrypt)) {
				Date fechaACtual = new Date();
				Timestamp date = new Timestamp(fechaACtual.getTime());
				// inactivamos la clave activa
				inactivarClave(claveUsuario.getCodClaveUsuario(), date);
				TelClaveUsuario nuevaClave = new TelClaveUsuario();
				TelUsuario usuario = new TelUsuario();
				usuario.setCodUsuario(dto.getUserId());
				nuevaClave.setClave(passEncrypt);
				nuevaClave.setFechaCreacion(date);
				nuevaClave.setStsEstado(EstadoEnum.ACTIVO.getValor());
				nuevaClave.setStsEstadoClave(EstadoClaveEnum.HABILITADA.getNemonico());
				nuevaClave.setTelUsuario(usuario);
				claveUsuarioRepository.save(nuevaClave);
				result.setCodigoError(Constantes.GENERAL_OK_CODE);
				result.setMensaje(Constantes.GENERAL_MSG_OK);
			} else {
				result.setCodigoError(Constantes.VALIDACION_CONTRASENIA);
				result.setMensaje(
						"Estimado usuario la contraseña ingresada ha sido usada anteriormente. Por favor verifique e ingrese una nueva contraseña.");
			}
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}


	@Transactional
	public DefaultDTO recuperarClave(RecuperarClaveDTO recuperar) {
		DefaultDTO result = new DefaultDTO();
		try {
			String tokenUsuario = recuperar.getIdentificacion() + recuperar.getAnioNacimiento();
			// extraemos las claves activas del usuario para inactivarlas
			List<TelClaveUsuario> clavesActivasRecuperar = recuperar.isPeticionConCorreoPersonal()
					? claveUsuarioRepository.listaClavesUsuarioActivasRecuperacionConCorreoPersonal(
							recuperar.getIdentificacion(), tokenUsuario, EstadoEnum.ACTIVO.getValor(),
							recuperar.getCorreoElectronico())
					: claveUsuarioRepository.listaClavesUsuarioActivasRecuperacionConCorreoInstitucional(
							recuperar.getIdentificacion(), tokenUsuario, EstadoEnum.ACTIVO.getValor(),
							recuperar.getCorreoElectronico());
			boolean esRecuperarCorreo = false;
			String correoEnvioMensaje = null;
			// operaciones de guardado y actualizacion
			result = operacionesRecuperacionClaveYCorreo(result, recuperar, clavesActivasRecuperar, esRecuperarCorreo,
					correoEnvioMensaje);
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}

	@Transactional
	public DefaultDTO recuperarCorreo(RecuperarClaveDTO recuperar) {
		DefaultDTO result = new DefaultDTO();
		try {
			String tokenUsuario = recuperar.getIdentificacion() + recuperar.getAnioNacimiento();
			// extraemos las claves activas del usuario para inactivarlas
			List<TelClaveUsuario> clavesActivasRecuperar = claveUsuarioRepository
					.listaClavesUsuarioActivasRecuperacionConAnioExpedicion(recuperar.getIdentificacion(), tokenUsuario,
							EstadoEnum.ACTIVO.getValor(), recuperar.getAnioExpedicionCedula());
			boolean esRecuperarCorreo = true;
			String correoEnvioMensaje = recuperar.getCorreoElectronico();
			// operaciones de guardado y actualizacion
			result = operacionesRecuperacionClaveYCorreo(result, recuperar, clavesActivasRecuperar, esRecuperarCorreo,
					correoEnvioMensaje);
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}

	
	/////////////////////////////////////////////////////////////////
	//METODOS DE AUXILIARES
	////////////////////////////////////////////////////////////////
	
	private DefaultDTO operacionesRecuperacionClaveYCorreo(DefaultDTO result, RecuperarClaveDTO recuperar,
			List<TelClaveUsuario> clavesActivasRecuperar, boolean esRecuperarCorreo, String correoEnvioMensaje)
			throws Exception {
		Date fechaACtual = new Date();
		Timestamp date = new Timestamp(fechaACtual.getTime());
		if (clavesActivasRecuperar.isEmpty()) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(
					"No se puede procesar la solicitud debido a que no existe un Usuario que cumpla con los parámetros ingresados. Por favor verifique o comuníquese con el administrador del sistema.");
		} else {
			TelUsuario usuarioPeticion = clavesActivasRecuperar.get(0).getTelUsuario();
			if (esRecuperarCorreo) {
				// actualizamos el correo personal del usuario
				usuarioPeticion.setCorreoPersonal(correoEnvioMensaje);
				usuarioRepository.save(usuarioPeticion);
			} else {
				correoEnvioMensaje = recuperar.isPeticionConCorreoPersonal() ? usuarioPeticion.getCorreoPersonal()
						: usuarioPeticion.getCorreoElectronico();
			}
			// inactivamos las claves activas
			inactivarClavesActivas(clavesActivasRecuperar, date);
			// nueva clave provisional
			TelClaveUsuario nuevaClave = new TelClaveUsuario();
			String claveProvisional = Util.getPassword();
			String passEncrypt = Util.encodeMD5(claveProvisional);
			nuevaClave.setClave(passEncrypt);
			nuevaClave.setFechaCreacion(date);
			nuevaClave.setStsEstado(EstadoEnum.ACTIVO.getValor());
			nuevaClave.setStsEstadoClave(EstadoClaveEnum.RESETEO.getNemonico());
			nuevaClave.setTelUsuario(usuarioPeticion);
			claveUsuarioRepository.save(nuevaClave);
			sendMessageNewPassword(correoEnvioMensaje, claveProvisional, usuarioPeticion.getNombresApellidos(), esRecuperarCorreo);
			result.setCodigoError(Constantes.GENERAL_OK_CODE);
			result.setMensaje("Por favor diríjase al correo electrónico proporcionado para continuar con el proceso.");
		}
		return result;
	}

	private void inactivarClavesActivas(List<TelClaveUsuario> clavesInactivar, Timestamp fechaInactivacion) {
		clavesInactivar.stream().forEach(clave -> {
			clave.setStsEstado(EstadoEnum.INACTIVO.getValor());
			clave.setFechaModificacion(fechaInactivacion);
			claveUsuarioRepository.save(clave);
		});
	}
	
	private void inactivarClave(Long codigoClaveAntigua, Timestamp fechaActual) {
		TelClaveUsuario claveAntigua = claveUsuarioRepository.getOne(codigoClaveAntigua);
		claveAntigua.setStsEstado(EstadoEnum.INACTIVO.getValor());
		claveAntigua.setFechaModificacion(fechaActual);
		claveUsuarioRepository.save(claveAntigua);
	}

	@SuppressWarnings("deprecation")
	private boolean validarCantidadClavesCoincidentes(Long codigoUsuario, String claveActual) {
		List<TelClaveUsuario> resultado = claveUsuarioRepository.getClavesCoincidenConActual(codigoUsuario,
				new PageRequest(0, Constantes.CANTIDAD_REGISTROS_VALIDAR_CONTRASENIA_INGRESADA)).getContent();
		return resultado.stream().anyMatch(clave -> clave.getClave().equals(claveActual));
	}

	private void sendMessageNewPassword(String mail, String claveProvisional, String nombresUsuario, boolean esRecuperarCorreo) {
		String asunto = "Recuperación de "+(esRecuperarCorreo?"correo electrónico":"contraseña")+" - Teletrabajo MinEduc";
		String texto = "Estimado(a) " + nombresUsuario
				+ ", su recuperación de "+(esRecuperarCorreo?"correo electrónico":"contraseña")+" en el sistema Teletrabajo fue exitoso. "
				+ " <br/><br/> <b>Contraseña provisional: " + claveProvisional + "</b>"
				+ "<br/><br/> Para continuar con el proceso, haga clic en el siguiente enlace: <a href=\"https://aplicaciones.educacion.gob.ec/teletrabajo/#/login\">Ingresar al sistema de teletrabajo</a><br/><br/>"
				+ "Recuerde el uso de la cuenta de usuario y contrase&#241;a entregada es de SU RESPONSABILIDAD.<br/><br/> "
				+ "Este correo ha sido generado autom&#225;ticamente, por favor no responda al mismo."
				+ "<br/><br/>Atentamente," + "<br/>Ministerio de Educación.";
		mailerService.createAndSendMessage(mail, asunto, texto);
	}
}
