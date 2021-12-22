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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the TEL_REGISTRO_ACTIVIDAD database table.
 * 
 */
@Entity
@Table(name = "tel_registro_actividad")
@NamedQuery(name = "TelRegistroActividad.findAll", query = "SELECT t FROM TelRegistroActividad t")
public class TelRegistroActividad implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name = "TEL_REGISTRO_ACTIVIDAD_CODREGISTROACTIVIDAD_GENERATOR", sequenceName = "SEQ_TEL_REGISTRO_ACTIVIDAD", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEL_REGISTRO_ACTIVIDAD_CODREGISTROACTIVIDAD_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_registro_actividad")
	private Long codRegistroActividad;

	@Column(name = "fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name = "sts_estado")
	private String stsEstado;

	@Column(name = "usuario_creacion")
	private String usuarioCreacion;

	@Column(name = "usuario_modifico")
	private String usuarioModifico;

	// bi-directional many-to-one association to TelCabeceraRegistro
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cabecera_registro")
	private TelCabeceraRegistro telCabeceraRegistro;

	// bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_actividad")
	private TelItemCatalogo telActividad;

	// bi-directional many-to-one association to TlSemana
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_semana")
	private TlSemana telSemana;

	public TelRegistroActividad() {
	}

	public TelRegistroActividad(String stsEstado, TelCabeceraRegistro telCabeceraRegistro, TelItemCatalogo telActividad,
			TlSemana telSemana) {
		this.stsEstado = stsEstado;
		this.telCabeceraRegistro = telCabeceraRegistro;
		this.telActividad = telActividad;
		this.telSemana = telSemana;
	}

	public Long getCodRegistroActividad() {
		return this.codRegistroActividad;
	}

	public void setCodRegistroActividad(Long codRegistroActividad) {
		this.codRegistroActividad = codRegistroActividad;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModifico() {
		return this.usuarioModifico;
	}

	public void setUsuarioModifico(String usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}

	public TelCabeceraRegistro getTelCabeceraRegistro() {
		return this.telCabeceraRegistro;
	}

	public void setTelCabeceraRegistro(TelCabeceraRegistro telCabeceraRegistro) {
		this.telCabeceraRegistro = telCabeceraRegistro;
	}

	public TelItemCatalogo getTelActividad() {
		return this.telActividad;
	}

	public void setTelActividad(TelItemCatalogo telActividad) {
		this.telActividad = telActividad;
	}

	public TlSemana getTelSemana() {
		return this.telSemana;
	}

	public void setTelSemana(TlSemana telSemana) {
		this.telSemana = telSemana;
	}

}