package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.util.List;


/**
 * The persistent class for the TEL_DISTRITO database table.
 * 
 */
@Entity
@Table(name="tel_distrito")
@NamedQuery(name="TelDistrito.findAll", query="SELECT t FROM TelDistrito t")
public class TelDistrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_DISTRITO_CODDISTRITO_GENERATOR", sequenceName="SEQ_TEL_DISTRITO", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_DISTRITO_CODDISTRITO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_distrito")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codDistrito;

	@Column(name="dpa_distrito")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String dpaDistrito;

	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String nombre;

	@Column(name="sts_estado")
	private String stsEstado;

	//bi-directional many-to-one association to TelProvincia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_prov_distrito")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelProvincia telProvincia;

	public TelDistrito() {
	}

	public long getCodDistrito() {
		return this.codDistrito;
	}

	public void setCodDistrito(long codDistrito) {
		this.codDistrito = codDistrito;
	}

	public String getDpaDistrito() {
		return this.dpaDistrito;
	}

	public void setDpaDistrito(String dpaDistrito) {
		this.dpaDistrito = dpaDistrito;
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

	public TelProvincia getTelProvincia() {
		return this.telProvincia;
	}

	public void setTelProvincia(TelProvincia telProvincia) {
		this.telProvincia = telProvincia;
	}
}