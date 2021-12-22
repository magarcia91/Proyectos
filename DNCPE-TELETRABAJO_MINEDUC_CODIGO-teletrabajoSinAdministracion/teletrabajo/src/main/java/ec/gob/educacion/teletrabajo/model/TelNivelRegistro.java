package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.sql.Timestamp;


/**
 * The persistent class for the TEL_NIVEL_REGISTRO database table.
 * 
 */
@Entity
@Table(name="tel_nivel_registro")
@NamedQuery(name="TelNivelRegistro.findAll", query="SELECT t FROM TelNivelRegistro t")
public class TelNivelRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_NIVEL_REGISTRO_CODNIVELREGISTRO_GENERATOR", sequenceName="SEQ_TEL_NIVEL_REGISTRO", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_NIVEL_REGISTRO_CODNIVELREGISTRO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_nivel_registro")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codNivelRegistro;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name="sts_estado")
	private String stsEstado;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICO")
	private String usuarioModifico;

	//bi-directional many-to-one association to TelCabeceraRegistro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cabecera_registro")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelCabeceraRegistro telCabeceraRegistro;

	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_asignatura")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelItemCatalogo telAsignatura;

	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_nivel")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelItemCatalogo telNivel;

	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_grado")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelItemCatalogo telGrado;

	public TelNivelRegistro() {
	}

	public long getCodNivelRegistro() {
		return this.codNivelRegistro;
	}

	public void setCodNivelRegistro(long codNivelRegistro) {
		this.codNivelRegistro = codNivelRegistro;
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

	public TelItemCatalogo getTelAsignatura() {
		return this.telAsignatura;
	}

	public void setTelAsignatura(TelItemCatalogo telAsignatura) {
		this.telAsignatura = telAsignatura;
	}

	public TelItemCatalogo getTelNivel() {
		return this.telNivel;
	}

	public void setTelNivel(TelItemCatalogo telNivel) {
		this.telNivel = telNivel;
	}

	public TelItemCatalogo getTelGrado() {
		return this.telGrado;
	}

	public void setTelGrado(TelItemCatalogo telGrado) {
		this.telGrado = telGrado;
	}

}