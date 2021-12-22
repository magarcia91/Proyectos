package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

/**
 * The persistent class for the TEL_CATALOGO database table.
 * 
 */
@Entity
@Table(name = "tel_catalogo")
@NamedQuery(name = "TelCatalogo.findAll", query = "SELECT t FROM TelCatalogo t")
public class TelCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name = "TEL_CATALOGO_CODCATALOGO_GENERATOR", sequenceName = "SEQ_TEL_CATALOGO", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEL_CATALOGO_CODCATALOGO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_catalogo")
	@JsonView({ DocenteController.ItemCatalogoView.class })
	private long codCatalogo;

	@JsonView({ DocenteController.ItemCatalogoView.class })
	private String nemonico;

	@JsonView({ DocenteController.ItemCatalogoView.class })
	private String nombre;

	@Column(name = "sts_estado")
	private String stsEstado;
	
	@Column(name = "descripcion")
	private String descripcion;

	@Transient
	private String estadoEncuesta;
	@Transient
	private Long codigoEstadoEncuesta;

	public TelCatalogo() {
	}

	public long getCodCatalogo() {
		return this.codCatalogo;
	}

	public void setCodCatalogo(long codCatalogo) {
		this.codCatalogo = codCatalogo;
	}

	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
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

	public String getEstadoEncuesta() {
		return estadoEncuesta;
	}

	public void setEstadoEncuesta(String estadoEncuesta) {
		this.estadoEncuesta = estadoEncuesta;
	}

	public Long getCodigoEstadoEncuesta() {
		return codigoEstadoEncuesta;
	}

	public void setCodigoEstadoEncuesta(Long codigoEstadoEncuesta) {
		this.codigoEstadoEncuesta = codigoEstadoEncuesta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}