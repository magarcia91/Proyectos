package ec.gob.educacion.teletrabajo.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import ec.gob.educacion.teletrabajo.model.TlSemana;

public class SemanaResumenDTO implements Serializable {

	private static final long serialVersionUID = 3984266694344454358L;
	
	private Long codigoRegistro;

	private Long codSemana;

	private Date fechaFin;

	private Date fechaInicio;

	private List<ActividadDTO> actividades;
	
	private boolean esTrabajoPresencial; 

	public SemanaResumenDTO() {
	}

	public SemanaResumenDTO(TlSemana semana) {
		semana = semana == null ? new TlSemana() : semana;
		this.codSemana = semana.getCodSemana();
		this.fechaFin = semana.getFechaFin();
		this.fechaInicio = semana.getFechaInicio();
	}

	public Long getCodSemana() {
		return codSemana;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setCodSemana(Long codSemana) {
		this.codSemana = codSemana;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<ActividadDTO> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadDTO> actividades) {
		this.actividades = actividades;
	}

	public Long getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Long codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public boolean isEsTrabajoPresencial() {
		return esTrabajoPresencial;
	}

	public void setEsTrabajoPresencial(boolean esTrabajoPresencial) {
		this.esTrabajoPresencial = esTrabajoPresencial;
	}

}
