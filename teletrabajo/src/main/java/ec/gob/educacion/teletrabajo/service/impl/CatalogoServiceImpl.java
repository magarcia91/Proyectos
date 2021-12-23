package ec.gob.educacion.teletrabajo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.enums.EstadoEncuestaConfirmacionEnum;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCatalogo;
import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;
import ec.gob.educacion.teletrabajo.repository.CatalogoRepository;
import ec.gob.educacion.teletrabajo.service.CatalogoService;
import ec.gob.educacion.teletrabajo.service.EncuestaEstadoService;
import ec.gob.educacion.teletrabajo.util.Constantes;
import ec.gob.educacion.teletrabajo.util.Util;

@Service
public class CatalogoServiceImpl implements CatalogoService {

	@Autowired
	private CatalogoRepository catalogoRepository;
	@Autowired
	private EncuestaEstadoService encuestaEstadoService;

	
	public List<TelCatalogo> listarEncuestasPorUsuario(Long codigoCabeceraRegistro, Long codigoOfertaEducativa, String estado){
		List<TelCatalogo> encuestas =  catalogoRepository.listarEncuestasPorEstadoYOfertaEducativa(codigoOfertaEducativa, estado);
		encuestas.stream().forEach(encuesta ->{
			List<TelEncuestaEstado> estadosEncuesta = encuestaEstadoService.listarPorEncuestaCabeceraRegistro(encuesta.getCodCatalogo(), codigoCabeceraRegistro, EstadoEnum.ACTIVO.getValor());
			if(estadosEncuesta.size()==1) {
				TelEncuestaEstado estadoEncuesta = estadosEncuesta.get(0);
				encuesta.setEstadoEncuesta(Util.encuestaConfirmada(estadoEncuesta.getFechaConfirmacion(), Constantes.DIAS_VALIDOS_CONFIRMACION)?EstadoEncuestaConfirmacionEnum.CONFIRMADA.getValor():EstadoEncuestaConfirmacionEnum.POR_CONFIRMAR.getValor());
				encuesta.setCodigoEstadoEncuesta(estadoEncuesta.getCodEncuestaEstado());
			}else if (estadosEncuesta.size()>1) {
				encuestaEstadoService.inactivarListado(estadosEncuesta);
				encuesta.setEstadoEncuesta(EstadoEncuestaConfirmacionEnum.POR_CONFIRMAR.getValor());
			}else {
				encuesta.setEstadoEncuesta(EstadoEncuestaConfirmacionEnum.POR_COMPLETAR.getValor());
			}			
		});
		return encuestas;
	}
	
	public List<TelCatalogo> listarEncuestasPorEstado(String estado, String nemonicoEncuestas){
		return catalogoRepository.listarEncuestasActivas(estado, nemonicoEncuestas);
	}

}
