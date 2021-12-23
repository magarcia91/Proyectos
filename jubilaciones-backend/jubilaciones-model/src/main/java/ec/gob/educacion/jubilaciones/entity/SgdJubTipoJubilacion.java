package ec.gob.educacion.jubilaciones.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the SGD_JUB_TIPOJUBILACION database table.
 * 
 */
@Entity
@Table(name="SGD_JUB_TIPOJUBILACION")
@NamedQuery(name="SgdJubTipoJubilacion.findAll", query="SELECT s FROM SgdJubTipoJubilacion s")
public class SgdJubTipoJubilacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SGD_JUB_TIPOJUBILACION_TIPJUBCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_TIPOJUBILACION",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_TIPOJUBILACION_TIPJUBCOD_GENERATOR")
	@Column(name="TIPJUB_COD")
	private Integer tipjubCod;
	
	@Column(name="TIPJUB_NOMBRE")
	private String tipjubNombre;
	
	@Column(name="TIPJUB_ESTADO")
	private Integer tipjubEstado;
	
	@OneToMany(mappedBy = "tipoJubilacion", fetch = FetchType.LAZY)
    private List<SgdJubTipoDiscapacidad> tipoDiscapacidad;
 	
	public SgdJubTipoJubilacion() {
		
	}
	
	public long getTipjubCod() {
		return this.tipjubCod;
	}
	
	public void setTipjubCod(Integer tipjubCod) {
		this.tipjubCod = tipjubCod;
	}
	
	public String getTipjubNombre() {
		return this.tipjubNombre;
	}

	public void setTipjubNombre(String tipjubNombre) {
		this.tipjubNombre = tipjubNombre;
	}
		
	public Integer getTipjubEstado() {
		return tipjubEstado;
	}

	public void setTipjubEstado(Integer tipjubEstado) {
		this.tipjubEstado = tipjubEstado;
	}
	
	public List<SgdJubTipoDiscapacidad> getTipoDiscapacidad() {
		return tipoDiscapacidad;
	}

	public void setTipoDiscapacidad(List<SgdJubTipoDiscapacidad> tipoDiscapacidad) {
		this.tipoDiscapacidad = tipoDiscapacidad;
	}
}