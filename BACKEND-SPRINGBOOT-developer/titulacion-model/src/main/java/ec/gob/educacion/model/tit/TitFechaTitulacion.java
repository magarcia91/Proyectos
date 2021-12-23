package ec.gob.educacion.model.tit;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the TIT_FECHA_TITULACIONdatabase table.
 * 
 */
@Entity
@Table(name="TIT_FECHA_TITULACION",schema = "TIT")
@NamedQuery(name="TitFechaTitulacion.findAll", query="SELECT t FROM TitFechaTitulacion t")
@SequenceGenerator(name = "SEQ_TIT_FECHA_TITULACION_GEN", sequenceName = "SEQ_TIT_FECHA_TITULACION", allocationSize = 1)

public class TitFechaTitulacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(generator = "SEQ_TIT_FECHA_TITULACION_GEN", strategy = GenerationType.SEQUENCE)
	@Column(name="FTI_CODIGO" , unique = true, nullable = false, precision = 10, scale = 0)
	private long ftiCodigo;
	
	@Column(name="COD_REG_ANI_LEC")
	private Integer codRegAniLec;

	@Column(name="COD_TIPO_EDUCACION")
	private Integer codTipoEducacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FTI_INICIO_GENERAL")
	private Date ftiInicioGeneral;

	@Temporal(TemporalType.DATE)
	@Column(name="FTI_FIN_GENERAL")
	private Date ftiFinGeneral;

	@Temporal(TemporalType.DATE)
	@Column(name="FTI_INICIO_EXONERADO")
	private Date ftiInicioExonerado;

	@Temporal(TemporalType.DATE)
	@Column(name="FTI_FIN_EXONERADO")
	private Date ftiFinExonerado;

	@Column(name="FTI_ESTADO")
	private Integer ftiEstado;


	public TitFechaTitulacion() {
	}


	public long getFtiCodigo() {
		return ftiCodigo;
	}


	public void setFtiCodigo(long ftiCodigo) {
		this.ftiCodigo = ftiCodigo;
	}


	public Integer getCodRegAniLec() {
		return codRegAniLec;
	}


	public void setCodRegAniLec(Integer codRegAniLec) {
		this.codRegAniLec = codRegAniLec;
	}


	public Integer getCodTipoEducacion() {
		return codTipoEducacion;
	}


	public void setCodTipoEducacion(Integer codTipoEducacion) {
		this.codTipoEducacion = codTipoEducacion;
	}


	public Date getFtiInicioGeneral() {
		return ftiInicioGeneral;
	}


	public void setFtiInicioGeneral(Date ftiInicioGeneral) {
		this.ftiInicioGeneral = ftiInicioGeneral;
	}


	public Date getFtiFinGeneral() {
		return ftiFinGeneral;
	}


	public void setFtiFinGeneral(Date ftiFinGeneral) {
		this.ftiFinGeneral = ftiFinGeneral;
	}


	public Date getFtiInicioExonerado() {
		return ftiInicioExonerado;
	}


	public void setFtiInicioExonerado(Date ftiInicioExonerado) {
		this.ftiInicioExonerado = ftiInicioExonerado;
	}


	public Date getFtiFinExonerado() {
		return ftiFinExonerado;
	}


	public void setFtiFinExonerado(Date ftiFinExonerado) {
		this.ftiFinExonerado = ftiFinExonerado;
	}


	public Integer getFtiEstado() {
		return ftiEstado;
	}


	public void setFtiEstado(Integer ftiEstado) {
		this.ftiEstado = ftiEstado;
	}

	






}