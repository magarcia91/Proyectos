package ec.gob.educacion.jubilaciones.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SGD_JUB_ASPIRANTE database table.
 * 
 */
@Entity
@Table(name="SGD_JUB_ASPIRANTE")
@NamedQuery(name="SgdJubAspirante.findAll", query="SELECT s FROM SgdJubAspirante s")
public class SgdJubAspirante implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aspCod;
	private BigDecimal aspAportacionespri;
	private BigDecimal aspAportacionespub;
	private String aspCorreo;
	private String aspDireccion;
	private String aspDiscapacidad;
	private BigDecimal aspImpedimento;
	private BigDecimal aspModalidadcon;
	private BigDecimal aspNumerores;
	private BigDecimal aspPartidagen;
	private BigDecimal aspPartidaind;
	private BigDecimal aspRegimenlab;
	private String aspTelefono;
	private String aspUnidadedu;

	public SgdJubAspirante() {
	}


	@Id
	@SequenceGenerator(name="SGD_JUB_ASPIRANTE_ASPCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_ASPIRANTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_ASPIRANTE_ASPCOD_GENERATOR")
	@Column(name="ASP_COD")
	public String getAspCod() {
		return this.aspCod;
	}

	public void setAspCod(String aspCod) {
		this.aspCod = aspCod;
	}


	@Column(name="ASP_APORTACIONESPRI")
	public BigDecimal getAspAportacionespri() {
		return this.aspAportacionespri;
	}

	public void setAspAportacionespri(BigDecimal aspAportacionespri) {
		this.aspAportacionespri = aspAportacionespri;
	}


	@Column(name="ASP_APORTACIONESPUB")
	public BigDecimal getAspAportacionespub() {
		return this.aspAportacionespub;
	}

	public void setAspAportacionespub(BigDecimal aspAportacionespub) {
		this.aspAportacionespub = aspAportacionespub;
	}


	@Column(name="ASP_CORREO")
	public String getAspCorreo() {
		return this.aspCorreo;
	}

	public void setAspCorreo(String aspCorreo) {
		this.aspCorreo = aspCorreo;
	}


	@Column(name="ASP_DIRECCION")
	public String getAspDireccion() {
		return this.aspDireccion;
	}

	public void setAspDireccion(String aspDireccion) {
		this.aspDireccion = aspDireccion;
	}


	@Column(name="ASP_DISCAPACIDAD")
	public String getAspDiscapacidad() {
		return this.aspDiscapacidad;
	}

	public void setAspDiscapacidad(String aspDiscapacidad) {
		this.aspDiscapacidad = aspDiscapacidad;
	}


	@Column(name="ASP_IMPEDIMENTO")
	public BigDecimal getAspImpedimento() {
		return this.aspImpedimento;
	}

	public void setAspImpedimento(BigDecimal aspImpedimento) {
		this.aspImpedimento = aspImpedimento;
	}


	@Column(name="ASP_MODALIDADCON")
	public BigDecimal getAspModalidadcon() {
		return this.aspModalidadcon;
	}

	public void setAspModalidadcon(BigDecimal aspModalidadcon) {
		this.aspModalidadcon = aspModalidadcon;
	}


	@Column(name="ASP_NUMERORES")
	public BigDecimal getAspNumerores() {
		return this.aspNumerores;
	}

	public void setAspNumerores(BigDecimal aspNumerores) {
		this.aspNumerores = aspNumerores;
	}


	@Column(name="ASP_PARTIDAGEN")
	public BigDecimal getAspPartidagen() {
		return this.aspPartidagen;
	}

	public void setAspPartidagen(BigDecimal aspPartidagen) {
		this.aspPartidagen = aspPartidagen;
	}


	@Column(name="ASP_PARTIDAIND")
	public BigDecimal getAspPartidaind() {
		return this.aspPartidaind;
	}

	public void setAspPartidaind(BigDecimal aspPartidaind) {
		this.aspPartidaind = aspPartidaind;
	}


	@Column(name="ASP_REGIMENLAB")
	public BigDecimal getAspRegimenlab() {
		return this.aspRegimenlab;
	}

	public void setAspRegimenlab(BigDecimal aspRegimenlab) {
		this.aspRegimenlab = aspRegimenlab;
	}


	@Column(name="ASP_TELEFONO")
	public String getAspTelefono() {
		return this.aspTelefono;
	}

	public void setAspTelefono(String aspTelefono) {
		this.aspTelefono = aspTelefono;
	}


	@Column(name="ASP_UNIDADEDU")
	public String getAspUnidadedu() {
		return this.aspUnidadedu;
	}

	public void setAspUnidadedu(String aspUnidadedu) {
		this.aspUnidadedu = aspUnidadedu;
	}

}