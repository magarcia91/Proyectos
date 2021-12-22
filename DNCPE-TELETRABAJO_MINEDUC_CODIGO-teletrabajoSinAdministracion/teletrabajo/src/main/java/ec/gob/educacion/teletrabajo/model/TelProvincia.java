package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.util.List;


/**
 * The persistent class for the TEL_PROVINCIA database table.
 * 
 */
@Entity
@Table(name="tel_provincia")
@NamedQuery(name="TelProvincia.findAll", query="SELECT t FROM TelProvincia t")
public class TelProvincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_PROVINCIA_CODPROVINCIA_GENERATOR", sequenceName="SEQ_TEL_PROVINCIA", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_PROVINCIA_CODPROVINCIA_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_provincia")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codProvincia;

	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String nombre;

	@Column(name="sts_estado")
	private String stsEstado;

	//bi-directional many-to-one association to TelZona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_zona_prov")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelZona telZona;

	public TelProvincia() {
	}

	public long getCodProvincia() {
		return this.codProvincia;
	}

	public void setCodProvincia(long codProvincia) {
		this.codProvincia = codProvincia;
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

	public TelZona getTelZona() {
		return this.telZona;
	}

	public void setTelZona(TelZona telZona) {
		this.telZona = telZona;
	}

}