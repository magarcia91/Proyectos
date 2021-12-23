package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.util.List;


/**
 * The persistent class for the TEL_ZONA database table.
 * 
 */
@Entity
@Table(name="tel_zona")
@NamedQuery(name="TelZona.findAll", query="SELECT t FROM TelZona t")
public class TelZona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_ZONA_CODZONA_GENERATOR", sequenceName="SEQ_TEL_ZONA", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_ZONA_CODZONA_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_zona")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codZona;

	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String nombre;

	@Column(name="sts_estado")
	private String stsEstado;

	public TelZona() {
	}

	public long getCodZona() {
		return this.codZona;
	}

	public void setCodZona(long codZona) {
		this.codZona = codZona;
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
}