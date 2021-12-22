package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TL_SEMANA database table.
 * 
 */
@Entity
@Table(name = "tel_semana")
@NamedQuery(name = "TlSemana.findAll", query = "SELECT t FROM TlSemana t")
public class TlSemana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name = "TL_SEMANA_CODSEMANA_GENERATOR", sequenceName = "SEQ_TL_SEMANA", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TL_SEMANA_CODSEMANA_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_semana")
	private Long codSemana;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	private String nombre;

	@Column(name = "sts_estado")
	private String stsEstado;

	public TlSemana() {
	}

	public TlSemana(Long codSemana) {
		this.codSemana = codSemana;
	}

	public Long getCodSemana() {
		return this.codSemana;
	}

	public void setCodSemana(Long codSemana) {
		this.codSemana = codSemana;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

}