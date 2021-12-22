package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="tel_encuesta_estado")
@NamedQuery(name="TelEncuestaEstado.findAll", query="SELECT t FROM TelEncuestaEstado t")
public class TelEncuestaEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_encuesta_estado")
	private long codEncuestaEstado;

	@Column(name="sts_estado")
	private String stsEstado;
	
	@Column(name="fecha_confirmacion")
	private Timestamp fechaConfirmacion;
	
	//bi-directional many-to-one association to TelCabeceraRegistro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_encuesta")
	private TelCatalogo telEncuesta;
	
	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cabecera_registro")
	private TelCabeceraRegistro telCabeceraRegistro;
	
	
	public TelEncuestaEstado() {
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public TelCatalogo getTelEncuesta() {
		return telEncuesta;
	}

	public void setTelEncuesta(TelCatalogo telEncuesta) {
		this.telEncuesta = telEncuesta;
	}

	public Timestamp getFechaConfirmacion() {
		return fechaConfirmacion;
	}

	public void setFechaConfirmacion(Timestamp fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	public TelCabeceraRegistro getTelCabeceraRegistro() {
		return telCabeceraRegistro;
	}

	public void setTelCabeceraRegistro(TelCabeceraRegistro telCabeceraRegistro) {
		this.telCabeceraRegistro = telCabeceraRegistro;
	}

	public long getCodEncuestaEstado() {
		return codEncuestaEstado;
	}

	public void setCodEncuestaEstado(long codEncuestaEstado) {
		this.codEncuestaEstado = codEncuestaEstado;
	}
}