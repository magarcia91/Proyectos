package ec.gob.educacion.teletrabajo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.EncuestaDTO;
import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.enums.TipoPreguntaEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelCatalogo;
import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;
import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.model.TelRegistroEncuesta;
import ec.gob.educacion.teletrabajo.repository.CatalogoRepository;
import ec.gob.educacion.teletrabajo.repository.RegistroEncuestaRepository;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.EncuestaEstadoService;
import ec.gob.educacion.teletrabajo.service.ItemCatalogoService;
import ec.gob.educacion.teletrabajo.service.RegistroEncuestaService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class RegistroEncuestaServiceImpl implements RegistroEncuestaService {
	
	private static final Logger LOGGER = Logger.getLogger(RegistroEncuestaServiceImpl.class.getName());

	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;
	@Autowired
	private ItemCatalogoService itemCatalogoService;
	@Autowired
	private RegistroEncuestaRepository registroEncuestaRepository;
	@Autowired
	private CatalogoRepository catalogoRepository;
	@Autowired
	private EncuestaEstadoService encuestaEstadoService;
	
	public boolean existenRespuestasGuardadas(Long codCabeceraRegistro, String estado) {
		return !registroEncuestaRepository.obtenerEncuestaPorCabecera(codCabeceraRegistro, estado).isEmpty();
	}
	
	public boolean existenRespuestasGuardadasPorEncuesta(Long codCabeceraRegistro, Long codEncuesta, String estado) {
		return registroEncuestaRepository.contarRespuestasGuardadas(codCabeceraRegistro, codEncuesta, estado) > 0;
	}

	public List<TelRegistroEncuesta> obtenerEncuestaPorCabecera(Long codCabeceraRegistro, String estado){
		return registroEncuestaRepository.obtenerEncuestaPorCabecera(codCabeceraRegistro, estado);
	}
	
	public EncuestaDTO generarEncuesta(Long codCabeceraRegistro, Long codigoEncuesta) {
		EncuestaDTO encuesta = new EncuestaDTO();
		TelCatalogo encuestaParametrizada = catalogoRepository.obtenerPorCodigoYEstado(codigoEncuesta, EstadoEnum.ACTIVO.getValor());
		//List<TelItemCatalogo> preguntas = itemCatalogoService.listarPorNemonicoCatalogo(CatalogoEnum.ENCUESTAS.getNemonico(), EstadoEnum.ACTIVO.getValor());
		List<TelItemCatalogo> preguntas = itemCatalogoService.listarPorCodigoCatalogo(codigoEncuesta, EstadoEnum.ACTIVO.getValor());
		if(preguntas.isEmpty()) {
			encuesta.setNombreEncuesta("Encuesta no parametrizada");
			encuesta.setExisteEncuestaParametrizada(false);
		}else {
			List<TelItemCatalogo> preguntasFiltradasEncuesta = new ArrayList<TelItemCatalogo>();
			List<TelRegistroEncuesta> respuestasGuardadas = registroEncuestaRepository.obtenerEncuestaPorCabecera(codCabeceraRegistro, EstadoEnum.ACTIVO.getValor());	
			List<TelItemCatalogo> preguntasDependientes = preguntas.stream().filter(pregunta -> pregunta.getHabilitarPregunta()!=null).collect(Collectors.toList());
			//filtramos las opciones de las preguntas
			preguntas.forEach(pregunta ->{			
				if(pregunta.getItemCatalogoPadre()==null) {
					List<TelRegistroEncuesta> respuestasPregunta= new ArrayList<>();
					//agregamos las opciones en el tipo de pregunta
					if(pregunta.getNemonico().equals(TipoPreguntaEnum.PREGUNTA_OPCION.getNemonico()) || pregunta.getNemonico().equals(TipoPreguntaEnum.PREGUNTA_OPCION_MULTIPLE.getNemonico())) {
						pregunta.setOpcionesPregunta(new ArrayList<TelItemCatalogo>());
						pregunta.setOpcionesPregunta(preguntas.stream().filter(preguntaComparacion -> preguntaComparacion.getItemCatalogoPadre()!=null && preguntaComparacion.getItemCatalogoPadre().equals(pregunta.getCodItemCatalogo())).collect(Collectors.toList()));						
					}
					//agregamos las respuesta a las preguntas	
					respuestasPregunta = respuestasGuardadas.stream().filter(respuesta -> respuesta.getTelPregunta()!=null && respuesta.getTelPregunta().getCodItemCatalogo( )== pregunta.getCodItemCatalogo()).collect(Collectors.toList());
					if(respuestasPregunta.isEmpty()) {
						pregunta.setRespuesta(new TelRegistroEncuesta());
						pregunta.setRespuestasOpcionMultiple(new ArrayList<>());
						//deshabilitamos las preguntas dependientes
						pregunta.setPreguntaDeshabilitada(preguntasDependientes.stream().anyMatch(dependiente -> dependiente.getHabilitarPregunta().contains(String.valueOf(pregunta.getCodItemCatalogo()))));
					}else {
						if(pregunta.getNemonico().equals(TipoPreguntaEnum.PREGUNTA_OPCION_MULTIPLE.getNemonico())) {
							pregunta.setRespuestasOpcionMultiple(respuestasPregunta);
						}else {
							pregunta.setRespuesta(respuestasPregunta.get(0));
						}						
					}
					preguntasFiltradasEncuesta.add(pregunta);
				}
			});
			encuesta.setNombreEncuesta(encuestaParametrizada!=null?encuestaParametrizada.getNombre():"Encuesta");
			encuesta.setDescripcionEncuesta(encuestaParametrizada!=null?encuestaParametrizada.getDescripcion():"");
			encuesta.setPreguntas(preguntasFiltradasEncuesta);
			encuesta.setExisteEncuestaParametrizada(true);
		}
		return encuesta;
	}
	
	@Transactional
	public DefaultDTO guardarEncuesta(String token, List<TelRegistroEncuesta> respuestas, TelEncuestaEstado estadoEncuesta, TelCatalogo encuesta) {
		DefaultDTO result = new DefaultDTO();
		try {
			TokenDTO dto = Util.getInfoToken(token);			
			Date fechaACtual = new Date();
			Timestamp date = new Timestamp(fechaACtual.getTime());
			TelEncuestaEstado encuestaEstadoGuardada = estadoEncuesta != null ?encuestaEstadoService.buscarPorCodigo(estadoEncuesta.getCodEncuestaEstado()):null;
			TelCabeceraRegistro cabeceraGuardada = cabeceraRegistroService.findCabeceraByUser(dto.getUserId());
			List<TelRegistroEncuesta> respuestasGuardadas = registroEncuestaRepository.obtenerEncuestaPorCabeceraYEncuesta(cabeceraGuardada.getCodCabeceraRegistro(), encuesta.getCodCatalogo(), EstadoEnum.ACTIVO.getValor());			
			List<TelRegistroEncuesta> respuestasInactivar = respuestasGuardadas.stream().filter(guardado -> (respuestas.stream().filter(nuevo -> nuevo.getTelPregunta().getCodItemCatalogo() == guardado.getTelPregunta().getCodItemCatalogo() && nuevo.getCodRegistroEncuesta() == guardado.getCodRegistroEncuesta()).count())<1).collect(Collectors.toList());
			List<TelRegistroEncuesta> respuestasOpcionMultipleInactivar = respuestasGuardadas.stream().filter(guardado -> (respuestas.stream().filter(nuevo -> nuevo.getValorOpcion()==guardado.getValorOpcion()).count())<1).collect(Collectors.toList());
			//inactivamos las respuestas no presentes en la nueva peticion
			inactivarRespuestasRegistro(respuestasInactivar,date,dto.getIdentificacion());
			inactivarRespuestasRegistro(respuestasOpcionMultipleInactivar,date,dto.getIdentificacion());
			//creamos los nuevas respuestas
			crearActualizarRespuestasRegistro(respuestas,date,dto.getIdentificacion(),cabeceraGuardada);	
			//creamos la confirmacion de la encuesta
			creacionActualizacionestadoEncuesta(encuestaEstadoGuardada, date, cabeceraGuardada, encuesta);
			result.setCodigoError(Constantes.GENERAL_OK_CODE);
			result.setMensaje(Constantes.GENERAL_MSG_OK);
		} catch (Exception e) {
			result.setCodigoError(Constantes.GENERAL_ERROR_CODE);
			result.setMensaje(e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return result;
	}
	
	private void crearActualizarRespuestasRegistro(List<TelRegistroEncuesta> respuestas, Timestamp date, String identificacionUsuario, TelCabeceraRegistro cabeceraGuardada) {
		respuestas.stream().forEach(respuesta -> {
			respuesta.setStsEstado(EstadoEnum.ACTIVO.getValor());
			if(respuesta.getCodRegistroEncuesta()>0) {
				respuesta.setFechaModificacion(date);
				respuesta.setUsuarioModifico(identificacionUsuario);
			}else {
				respuesta.setFechaCreacion(date);
				respuesta.setUsuarioCreacion(identificacionUsuario);
			}
			
			respuesta.setTelCabeceraRegistro(cabeceraGuardada);
			registroEncuestaRepository.save(respuesta);
		});
	}
	
	private void inactivarRespuestasRegistro(List<TelRegistroEncuesta> respuestasInactivar, Timestamp date, String identificacionUsuario) {
		respuestasInactivar.stream().forEach(respuesta->{
			respuesta.setStsEstado(EstadoEnum.INACTIVO.getValor());
			respuesta.setFechaModificacion(date);
			respuesta.setUsuarioModifico(identificacionUsuario);
			registroEncuestaRepository.save(respuesta);
		});
	}
	
	private void creacionActualizacionestadoEncuesta(TelEncuestaEstado estadoEncuesta, Timestamp date, TelCabeceraRegistro cabeceraGuardada, TelCatalogo encuesta) {
		if(estadoEncuesta==null) {
			estadoEncuesta = new TelEncuestaEstado();
			estadoEncuesta.setFechaConfirmacion(date);
			estadoEncuesta.setStsEstado(EstadoEnum.ACTIVO.getValor());
			estadoEncuesta.setTelCabeceraRegistro(cabeceraGuardada);
			estadoEncuesta.setTelEncuesta(encuesta);
			encuestaEstadoService.crearActualizar(estadoEncuesta);
		}else {
			estadoEncuesta.setFechaConfirmacion(date);
			encuestaEstadoService.crearActualizar(estadoEncuesta);
		}
	}
}
