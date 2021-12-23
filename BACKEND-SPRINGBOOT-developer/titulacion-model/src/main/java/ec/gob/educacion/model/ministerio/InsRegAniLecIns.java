package ec.gob.educacion.model.ministerio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InsRegAniLecIns - desarrollo.
 */
@Entity
@Table(name = "INS_REG_ANI_LEC_INS")
@SequenceGenerator(name = "SEQ_INS_REG_ANI_LEC_INS_GEN", sequenceName = "SEQ_INS_REG_ANI_LEC_INS", allocationSize = 1)

public class InsRegAniLecIns implements Serializable {

	private static final long serialVersionUID = -1602834620987216147L;
	
	private long codigo;
	private InsRegAniLec insRegAniLec;
	private InsInstitucion insInstitucion;
	private Date fechaCreacion;
	private int estado;
	//private List<TitAutoridad> titAutoridadList = new ArrayList<TitAutoridad>(0);

	public InsRegAniLecIns() {

	}

	public InsRegAniLecIns(long codigo, InsRegAniLec insRegAniLec,
			InsInstitucion insInstitucion, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insRegAniLec = insRegAniLec;
		this.insInstitucion = insInstitucion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_REG_ANI_LEC_INS_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_REG_ANI_LEC", nullable = false)
	public InsRegAniLec getInsRegAniLec() {
		return this.insRegAniLec;
	}

	public void setInsRegAniLec(InsRegAniLec insRegAniLec) {
		this.insRegAniLec = insRegAniLec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_INSTITUCION", nullable = false)
	public InsInstitucion getInsInstitucion() {
		return this.insInstitucion;
	}

	public void setInsInstitucion(InsInstitucion insInstitucion) {
		this.insInstitucion = insInstitucion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION", nullable = false, length = 7)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "ESTADO", nullable = false, precision = 1, scale = 0)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insRegAniLecIns")
//	public List<TitAutoridad> getTitAutoridadList() {
//		return titAutoridadList;
//	}
//
//	public void setTitAutoridadList(List<TitAutoridad> titAutoridadList) {
//		this.titAutoridadList = titAutoridadList;
//	}
}
