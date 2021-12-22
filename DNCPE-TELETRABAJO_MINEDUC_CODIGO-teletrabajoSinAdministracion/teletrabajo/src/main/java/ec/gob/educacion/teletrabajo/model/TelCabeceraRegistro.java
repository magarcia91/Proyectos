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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

/**
 * The persistent class for the TEL_CABECERA_REGISTRO database table.
 * 
 */
@Entity
@Table(name = "tel_cabecera_registro")
@NamedQuery(name = "TelCabeceraRegistro.findAll", query = "SELECT t FROM TelCabeceraRegistro t")
public class TelCabeceraRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_CABECERA_REGISTRO_CODCABECERAREGISTRO_GENERATOR", sequenceName="SEQ_TEL_CABECERA_REGISTRO", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_CABECERA_REGISTRO_CODCABECERAREGISTRO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cabecera_registro")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codCabeceraRegistro;

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

	//bi-directional many-to-one association to TelInsEducativa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_ins_educativa")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelInsEducativa telInsEducativa;

	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cargo_ie")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelItemCatalogo telCargo;

	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_oferta_educativa")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelItemCatalogo telOfertaEducativa;

	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_regimen")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelItemCatalogo telRegimen;

	//bi-directional many-to-one association to TelUsuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelUsuario telUsuario;
	
	//bi-directional many-to-one association to TelDistrito
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_distrito")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelDistrito telDistritoCabecera;
	
	@Transient
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private boolean habilitadaEncuesta;

	public TelCabeceraRegistro() {
	}

	public long getCodCabeceraRegistro() {
		return this.codCabeceraRegistro;
	}

	public void setCodCabeceraRegistro(long codCabeceraRegistro) {
		this.codCabeceraRegistro = codCabeceraRegistro;
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

	public TelInsEducativa getTelInsEducativa() {
		return this.telInsEducativa;
	}

	public void setTelInsEducativa(TelInsEducativa telInsEducativa) {
		this.telInsEducativa = telInsEducativa;
	}

	public TelItemCatalogo getTelCargo() {
		return this.telCargo;
	}

	public void setTelCargo(TelItemCatalogo telCargo) {
		this.telCargo = telCargo;
	}

	public TelItemCatalogo getTelOfertaEducativa() {
		return this.telOfertaEducativa;
	}

	public void setTelOfertaEducativa(TelItemCatalogo telOfertaEducativa) {
		this.telOfertaEducativa = telOfertaEducativa;
	}

	public TelItemCatalogo getTelRegimen() {
		return this.telRegimen;
	}

	public void setTelRegimen(TelItemCatalogo telRegimen) {
		this.telRegimen = telRegimen;
	}

	public TelUsuario getTelUsuario() {
		return this.telUsuario;
	}

	public void setTelUsuario(TelUsuario telUsuario) {
		this.telUsuario = telUsuario;
	}

	public TelDistrito getTelDistritoCabecera() {
		return telDistritoCabecera;
	}

	public void setTelDistritoCabecera(TelDistrito telDistritoCabecera) {
		this.telDistritoCabecera = telDistritoCabecera;
	}

	public boolean isHabilitadaEncuesta() {
		return habilitadaEncuesta;
	}

	public void setHabilitadaEncuesta(boolean habilitadaEncuesta) {
		this.habilitadaEncuesta = habilitadaEncuesta;
	}

}