package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.sql.Timestamp;


/**
 * The persistent class for the tel_distrito_registro database table.
 * 
 */
@Entity
@Table(name="tel_distrito_registro")
public class TelDistritoRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_distrito_registro")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codDistritoRegistro;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name="sts_estado")
	private String stsEstado;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modifico")
	private String usuarioModifico;

	//bi-directional many-to-one association to TelCabeceraRegistro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cabecera_registro")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelCabeceraRegistro telCabeceraRegistro;

	//bi-directional many-to-one association to TelDistrito
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_distrito")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelDistrito telDistrito;


	public TelDistritoRegistro() {
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

	public long getCodDistritoRegistro() {
		return codDistritoRegistro;
	}

	public void setCodDistritoRegistro(long codDistritoRegistro) {
		this.codDistritoRegistro = codDistritoRegistro;
	}

	public TelDistrito getTelDistrito() {
		return telDistrito;
	}

	public void setTelDistrito(TelDistrito telDistrito) {
		this.telDistrito = telDistrito;
	}

}