package ec.gob.educacion.teletrabajo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;
import ec.gob.educacion.teletrabajo.model.TelCatalogo;
import ec.gob.educacion.teletrabajo.model.TelEncuestaEstado;
import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.model.TelRegistroEncuesta;

public class EncuestaDTO {


	@JsonView({DocenteController.ItemCatalogoView.class})
	private String nombreEncuesta;
	@JsonView({DocenteController.ItemCatalogoView.class})
	private String descripcionEncuesta;
	@JsonView({DocenteController.ItemCatalogoView.class})
	private List<TelItemCatalogo> preguntas = new ArrayList<>();
	@JsonView({DocenteController.ItemCatalogoView.class})
	private boolean existeEncuestaParametrizada;
	
	private List<TelRegistroEncuesta> respuestas;
	private TelEncuestaEstado estadoEncuesta;
	private TelCatalogo encuesta;
	
	
	public String getNombreEncuesta() {
		return nombreEncuesta;
	}
	public void setNombreEncuesta(String nombreEncuesta) {
		this.nombreEncuesta = nombreEncuesta;
	}
	public List<TelItemCatalogo> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<TelItemCatalogo> preguntas) {
		this.preguntas = preguntas;
	}
	public boolean isExisteEncuestaParametrizada() {
		return existeEncuestaParametrizada;
	}
	public void setExisteEncuestaParametrizada(boolean existeEncuestaParametrizada) {
		this.existeEncuestaParametrizada = existeEncuestaParametrizada;
	}
	public TelEncuestaEstado getEstadoEncuesta() {
		return estadoEncuesta;
	}
	public void setEstadoEncuesta(TelEncuestaEstado estadoEncuesta) {
		this.estadoEncuesta = estadoEncuesta;
	}
	public List<TelRegistroEncuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<TelRegistroEncuesta> respuestas) {
		this.respuestas = respuestas;
	}
	public TelCatalogo getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(TelCatalogo encuesta) {
		this.encuesta = encuesta;
	}
	public String getDescripcionEncuesta() {
		return descripcionEncuesta;
	}
	public void setDescripcionEncuesta(String descripcionEncuesta) {
		this.descripcionEncuesta = descripcionEncuesta;
	}

}
