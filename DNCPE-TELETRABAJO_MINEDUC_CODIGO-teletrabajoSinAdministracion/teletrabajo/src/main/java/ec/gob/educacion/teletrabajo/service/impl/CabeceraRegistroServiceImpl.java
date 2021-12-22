package ec.gob.educacion.teletrabajo.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelUsuario;
import ec.gob.educacion.teletrabajo.repository.CabeceraRegistroRepository;
import ec.gob.educacion.teletrabajo.repository.UsuarioRepository;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class CabeceraRegistroServiceImpl implements CabeceraRegistroService {	
	
	private static final Logger LOGGER = Logger.getLogger(CabeceraRegistroServiceImpl.class.getName());

	@Autowired
	private CabeceraRegistroRepository cabeceraRegistroRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public TelCabeceraRegistro findCabeceraByUser(Long usuario) {
		return cabeceraRegistroRepository.findCabeceraByUser(EstadoEnum.ACTIVO.getValor(), usuario);
	}
	public TelCabeceraRegistro obtenerCabeceraRegistroUsuario(String identificacion, String estado) {
		return cabeceraRegistroRepository.obtenerCabeceraRegistroUsuario(identificacion, estado);
	}
	@Transactional
	public DefaultDTO guardarCabeceraRegistro(String token, TelCabeceraRegistro cabecera) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);			
			Date fechaACtual = new Date();
			Timestamp date = new Timestamp(fechaACtual.getTime());
			//actualizamos el usuario
			TelUsuario usuario = usuarioRepository.obtenerPorIdentificacion(dto.getIdentificacion(), EstadoEnum.ACTIVO.getValor());
			usuario.setCorreoElectronico(cabecera.getTelUsuario().getCorreoElectronico());
			usuario.setCorreoPersonal(cabecera.getTelUsuario().getCorreoPersonal());
			usuario.setCelular(cabecera.getTelUsuario().getCelular());
			//cambiamos la referencia geografica del usuario
			cabecera.setTelDistritoCabecera(cabecera.getTelInsEducativa()!=null?null:cabecera.getTelDistritoCabecera());
			if(cabecera.getTelInsEducativa()!=null || cabecera.getTelDistritoCabecera()!=null) {
				String distrito = cabecera.getTelDistritoCabecera()!=null?cabecera.getTelDistritoCabecera().getDpaDistrito():cabecera.getTelInsEducativa()!=null?cabecera.getTelInsEducativa().getTelDistrito().getDpaDistrito():null;
				Long zona = cabecera.getTelDistritoCabecera()!=null?cabecera.getTelDistritoCabecera().getTelProvincia().getTelZona().getCodZona():cabecera.getTelInsEducativa()!=null?cabecera.getTelInsEducativa().getTelDistrito().getTelProvincia().getTelZona().getCodZona():null;
				if(zona!=null && usuario.getZona()!=null && usuario.getZona().intValue()!=zona.intValue()) {
					usuario.setDpaDistrito(distrito);
					usuario.setZona(zona.intValue());
				}
			}
			usuarioRepository.save(usuario);
			//inactivar cabecera
			TelCabeceraRegistro cabeceraGuardada = findCabeceraByUser(dto.getUserId());
			if(cabeceraGuardada != null && cabeceraGuardada.getTelOfertaEducativa() != null && cabeceraGuardada.getTelOfertaEducativa().getCodItemCatalogo() != cabecera.getTelOfertaEducativa().getCodItemCatalogo()) {
				cabeceraGuardada.setStsEstado(EstadoEnum.INACTIVO.getValor());
				cabeceraGuardada.setFechaModificacion(date);
				cabeceraGuardada.setUsuarioModifico(dto.getIdentificacion());
				cabeceraRegistroRepository.save(cabeceraGuardada);
				cabecera.setCodCabeceraRegistro(0);
			}			
			//crear la nueva cabecera
			cabecera.setTelUsuario(usuario);
			cabecera.setFechaCreacion(date);
			cabecera.setStsEstado(EstadoEnum.ACTIVO.getValor());
			cabecera.setUsuarioCreacion(dto.getIdentificacion());			
			cabeceraRegistroRepository.save(cabecera);			
			result.setCodigoError(Constantes.GENERAL_OK_CODE);
			result.setMensaje(Constantes.GENERAL_MSG_OK);
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}
}
