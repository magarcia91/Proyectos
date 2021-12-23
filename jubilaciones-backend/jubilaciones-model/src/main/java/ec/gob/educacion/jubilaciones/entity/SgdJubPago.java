package ec.gob.educacion.jubilaciones.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "SGD_JUB_PAGO " database table.
 * 
 */
@Entity
@Table(name="\"SGD_JUB_PAGO \"")
@NamedQuery(name="SgdJubPago.findAll", query="SELECT s FROM SgdJubPago s")
public class SgdJubPago implements Serializable {
	private static final long serialVersionUID = 1L;
	private long pagCod;
	private BigDecimal desCod;
	private String pagCargoasp;
	private Date pagFcerpagasp;
	private Date pagFecdesasp;
	private Date pagFecfallasp;
	private BigDecimal tipiCod;

	public SgdJubPago() {
	}


	@Id
	@SequenceGenerator(name="SGD_JUB_PAGO_PAGCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_PAGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_PAGO_PAGCOD_GENERATOR")
	@Column(name="PAG_COD")
	public long getPagCod() {
		return this.pagCod;
	}

	public void setPagCod(long pagCod) {
		this.pagCod = pagCod;
	}


	@Column(name="DES_COD")
	public BigDecimal getDesCod() {
		return this.desCod;
	}

	public void setDesCod(BigDecimal desCod) {
		this.desCod = desCod;
	}


	@Column(name="PAG_CARGOASP")
	public String getPagCargoasp() {
		return this.pagCargoasp;
	}

	public void setPagCargoasp(String pagCargoasp) {
		this.pagCargoasp = pagCargoasp;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PAG_FCERPAGASP")
	public Date getPagFcerpagasp() {
		return this.pagFcerpagasp;
	}

	public void setPagFcerpagasp(Date pagFcerpagasp) {
		this.pagFcerpagasp = pagFcerpagasp;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PAG_FECDESASP")
	public Date getPagFecdesasp() {
		return this.pagFecdesasp;
	}

	public void setPagFecdesasp(Date pagFecdesasp) {
		this.pagFecdesasp = pagFecdesasp;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PAG_FECFALLASP")
	public Date getPagFecfallasp() {
		return this.pagFecfallasp;
	}

	public void setPagFecfallasp(Date pagFecfallasp) {
		this.pagFecfallasp = pagFecfallasp;
	}


	@Column(name="TIPI_COD")
	public BigDecimal getTipiCod() {
		return this.tipiCod;
	}

	public void setTipiCod(BigDecimal tipiCod) {
		this.tipiCod = tipiCod;
	}

}