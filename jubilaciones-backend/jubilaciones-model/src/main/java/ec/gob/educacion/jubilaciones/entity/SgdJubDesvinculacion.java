package ec.gob.educacion.jubilaciones.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SGD_JUB_DESVINCULACION database table.
 * 
 */
@Entity
@Table(name="SGD_JUB_DESVINCULACION")
@NamedQuery(name="SgdJubDesvinculacion.findAll", query="SELECT s FROM SgdJubDesvinculacion s")
public class SgdJubDesvinculacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private long desCod;
	private BigDecimal aspCod;
	private Date desFecha;
	private double desMonto;
	private BigDecimal tipdCod;

	public SgdJubDesvinculacion() {
	}


	@Id
	@SequenceGenerator(name="SGD_JUB_DESVINCULACION_DESCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_DESVINCULACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_DESVINCULACION_DESCOD_GENERATOR")
	@Column(name="DES_COD")
	public long getDesCod() {
		return this.desCod;
	}

	public void setDesCod(long desCod) {
		this.desCod = desCod;
	}


	@Column(name="ASP_COD")
	public BigDecimal getAspCod() {
		return this.aspCod;
	}

	public void setAspCod(BigDecimal aspCod) {
		this.aspCod = aspCod;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DES_FECHA")
	public Date getDesFecha() {
		return this.desFecha;
	}

	public void setDesFecha(Date desFecha) {
		this.desFecha = desFecha;
	}


	@Column(name="DES_MONTO")
	public double getDesMonto() {
		return this.desMonto;
	}

	public void setDesMonto(double desMonto) {
		this.desMonto = desMonto;
	}


	@Column(name="TIPD_COD")
	public BigDecimal getTipdCod() {
		return this.tipdCod;
	}

	public void setTipdCod(BigDecimal tipdCod) {
		this.tipdCod = tipdCod;
	}

}