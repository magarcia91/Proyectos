package ec.gob.educacion.jubilaciones.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the SGD_JUB_TIPODESVINCULACION database table.
 * 
 */
@Entity
@Table(name="SGD_JUB_TIPODISCAPACIDAD")
@NamedQuery(name="SgdJubTipoDiscapacidad.findAll", query="SELECT s FROM SgdJubTipoDiscapacidad s")
public class SgdJubTipoDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SGD_JUB_TIPODISCAPACIDAD_TIPDISCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_TIPODISCAPACIDAD",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_TIPODESVINCULACION_TIPDCOD_GENERATOR")
	@Column(name="TIPDIS_COD")
	private Integer tipdisCod;
	
	@Column(name="TIPDIS_NOMBRE")
	private String tipdisNombre;
	
	@Column(name="TIPDIS_ESTADO")
	private Integer tipdisEstado;
	
	@JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "FK_TIPJUB_COD")
    private SgdJubTipoJubilacion tipoJubilacion;
	
	
	public SgdJubTipoDiscapacidad() {
	}

	public Integer getTipdisCod() {
		return this.tipdisCod;
	}

	public void setTipdisCod(Integer tipdisCod) {
		this.tipdisCod = tipdisCod;
	}
	
	public String getTipdisNombre() {
		return this.tipdisNombre;
	}

	public void setTipdisNombre(String tipdisNombre) {
		this.tipdisNombre = tipdisNombre;
	}
	
	public Integer getTipdisEstado() {
		return tipdisEstado;
	}

	public void setTipdisEstado(Integer tipdisEstado) {
		this.tipdisEstado = tipdisEstado;
	}

	public SgdJubTipoJubilacion getTipoJubilacion() {
		return tipoJubilacion;
	}

	public void setTipoJubilacion(SgdJubTipoJubilacion tipoJubilacion) {
		this.tipoJubilacion = tipoJubilacion;
	}

}