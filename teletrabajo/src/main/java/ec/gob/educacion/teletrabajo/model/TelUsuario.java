package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

/**
 * The persistent class for the TEL_USUARIO database table.
 * 
 */
@Entity
@Table(name = "tel_usuario")
@NamedQuery(name = "TelUsuario.findAll", query = "SELECT t FROM TelUsuario t")
public class TelUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_USUARIO_CODUSUARIO_GENERATOR", sequenceName="SEQ_TEL_USUARIO", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_USUARIO_CODUSUARIO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usuario")
	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private long codUsuario;

	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String celular;

	@Column(name="correo_electronico")
	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String correoElectronico;

	@Column(name="correo_personal")
	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String correoPersonal;

	@Column(name="dpa_distrito")
	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String dpaDistrito;

	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String identificacion;

	@Column(name="nombres_apellidos")
	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String nombresApellidos;

	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private String rol;

	@Column(name = "sts_estado")
	@JsonView({DocenteController.DocenteView.class})
	private String stsEstado;

	@JsonView({DocenteController.DocenteView.class})
	private String token;

	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	private Integer zona;
	
	@JsonView({DocenteController.DocenteView.class, DocenteController.CabeceraRegistroView.class})
	@Column(name="anio_expedicion_cedula")
	private Integer anioExpedicionCedula;

	public TelUsuario() {
	}

	public TelUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public long getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCorreoPersonal() {
		return this.correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public String getDpaDistrito() {
		return this.dpaDistrito;
	}

	public void setDpaDistrito(String dpaDistrito) {
		this.dpaDistrito = dpaDistrito;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombresApellidos() {
		return this.nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getZona() {
		return this.zona;
	}

	public void setZona(Integer zona) {
		this.zona = zona;
	}

	public Integer getAnioExpedicionCedula() {
		return anioExpedicionCedula;
	}

	public void setAnioExpedicionCedula(Integer anioExpedicionCedula) {
		this.anioExpedicionCedula = anioExpedicionCedula;
	}
}