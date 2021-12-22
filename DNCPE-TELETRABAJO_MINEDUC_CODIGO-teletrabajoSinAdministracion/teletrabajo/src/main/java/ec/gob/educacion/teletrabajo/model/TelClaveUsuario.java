package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TEL_CLAVE_USUARIO database table.
 * 
 */
@Entity
@Table(name="tel_clave_usuario")
@NamedQuery(name="TelClaveUsuario.findAll", query="SELECT t FROM TelClaveUsuario t")
public class TelClaveUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_CLAVE_USUARIO_CODCLAVEUSUARIO_GENERATOR", sequenceName="SEQ_TEL_CLAVE_USUARIO", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_CLAVE_USUARIO_CODCLAVEUSUARIO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_clave_usuario")
	private long codClaveUsuario;

	private String clave;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name="sts_estado")
	private String stsEstado;

	//bi-directional many-to-one association to TelUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_usuario_clave")
	private TelUsuario telUsuario;
	
	@Column(name="sts_estado_clave")
	private String stsEstadoClave;
	
	public TelClaveUsuario() {
	}

	public long getCodClaveUsuario() {
		return this.codClaveUsuario;
	}

	public void setCodClaveUsuario(long codClaveUsuario) {
		this.codClaveUsuario = codClaveUsuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public TelUsuario getTelUsuario() {
		return this.telUsuario;
	}

	public void setTelUsuario(TelUsuario telUsuario) {
		this.telUsuario = telUsuario;
	}

	public String getStsEstadoClave() {
		return stsEstadoClave;
	}

	public void setStsEstadoClave(String stsEstadoClave) {
		this.stsEstadoClave = stsEstadoClave;
	}
}