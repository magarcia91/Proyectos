package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PEN_ENCUESTA database table.
 * 
 */
@Entity
@Table(name="PEN_ENCUESTA")
@NamedQuery(name="PenEncuesta.findAll", query="SELECT p FROM PenEncuesta p")
public class PenEncuesta implements Serializable {
	private static final long serialVersionUID = 1L;
	private long encCodigo;
	private Integer encEstado;
	private Date encFechaCreacion;
	private long preCodigo;
	private long resCodigo;
	private long usuCodigo;
	private PenEstudiante penEstudiante;

	public PenEncuesta() {
	}


	@Id
	@SequenceGenerator(name="PEN_ENCUESTA_ENCCODIGO_GENERATOR", sequenceName="SEQ_PEN_ENCUESTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_ENCUESTA_ENCCODIGO_GENERATOR")
	@Column(name="ENC_CODIGO")
	public long getEncCodigo() {
		return this.encCodigo;
	}

	public void setEncCodigo(long encCodigo) {
		this.encCodigo = encCodigo;
	}


	@Column(name="ENC_ESTADO")
	public Integer getEncEstado() {
		return this.encEstado;
	}

	public void setEncEstado(Integer encEstado) {
		this.encEstado = encEstado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="ENC_FECHA_CREACION")
	public Date getEncFechaCreacion() {
		return this.encFechaCreacion;
	}

	public void setEncFechaCreacion(Date encFechaCreacion) {
		this.encFechaCreacion = encFechaCreacion;
	}


	@Column(name="PRE_CODIGO")
	public long getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(long preCodigo) {
		this.preCodigo = preCodigo;
	}


	@Column(name="RES_CODIGO")
	public long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(long resCodigo) {
		this.resCodigo = resCodigo;
	}


	@Column(name="USU_CODIGO")
	public long getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(long usuCodigo) {
		this.usuCodigo = usuCodigo;
	}


	//bi-directional many-to-one association to PenEstudiante
	@ManyToOne
	@JoinColumn(name="EST_CODIGO")
	public PenEstudiante getPenEstudiante() {
		return this.penEstudiante;
	}

	public void setPenEstudiante(PenEstudiante penEstudiante) {
		this.penEstudiante = penEstudiante;
	}

}