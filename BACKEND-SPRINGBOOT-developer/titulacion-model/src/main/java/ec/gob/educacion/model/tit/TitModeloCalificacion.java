package ec.gob.educacion.model.tit;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIT_MODELO_CALIFICACION database table.
 * 
 */
@Entity
@Table(name="TIT_MODELO_CALIFICACION")
@NamedQuery(name="TitModeloCalificacion.findAll", query="SELECT t FROM TitModeloCalificacion t")
public class TitModeloCalificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MCA_CODIGO")
	private Integer mcaCodigo;

	@Column(name="COD_REG_ANI_LEC")
	private Integer codRegAniLec;

	@Column(name="COD_TIPO_EDUCACION")
	private Integer codTipoEducacion;

	@Column(name="MCA_DENOMINACION")
	private String mcaDenominacion;

	@Column(name="MCA_DESDE")
	private double mcaDesde;

	@Column(name="MCA_ESTADO")
	private Integer mcaEstado;

	@Column(name="MCA_HASTA")
	private double mcaHasta;

	@Column(name="MCA_PORCENTAJE")
	private double mcaPorcentaje;

	public TitModeloCalificacion() {
	}

	public Integer getMcaCodigo() {
		return this.mcaCodigo;
	}

	public void setMcaCodigo(Integer mcaCodigo) {
		this.mcaCodigo = mcaCodigo;
	}

	public Integer getCodRegAniLec() {
		return this.codRegAniLec;
	}

	public void setCodRegAniLec(Integer codRegAniLec) {
		this.codRegAniLec = codRegAniLec;
	}

	public Integer getCodTipoEducacion() {
		return this.codTipoEducacion;
	}

	public void setCodTipoEducacion(Integer codTipoEducacion) {
		this.codTipoEducacion = codTipoEducacion;
	}

	public String getMcaDenominacion() {
		return this.mcaDenominacion;
	}

	public void setMcaDenominacion(String mcaDenominacion) {
		this.mcaDenominacion = mcaDenominacion;
	}

	public double getMcaDesde() {
		return this.mcaDesde;
	}

	public void setMcaDesde(double mcaDesde) {
		this.mcaDesde = mcaDesde;
	}

	public Integer getMcaEstado() {
		return this.mcaEstado;
	}

	public void setMcaEstado(Integer mcaEstado) {
		this.mcaEstado = mcaEstado;
	}

	public double getMcaHasta() {
		return this.mcaHasta;
	}

	public void setMcaHasta(double mcaHasta) {
		this.mcaHasta = mcaHasta;
	}

	public double getMcaPorcentaje() {
		return this.mcaPorcentaje;
	}

	public void setMcaPorcentaje(double mcaPorcentaje) {
		this.mcaPorcentaje = mcaPorcentaje;
	}

}