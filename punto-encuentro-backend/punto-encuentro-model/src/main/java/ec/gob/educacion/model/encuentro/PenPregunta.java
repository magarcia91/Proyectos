package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PEN_PREGUNTA database table.
 * 
 */
@Entity
@Table(name="PEN_PREGUNTA")
@NamedQuery(name="PenPregunta.findAll", query="SELECT p FROM PenPregunta p")
public class PenPregunta implements Serializable {
	private static final long serialVersionUID = 1L;
	private long preCodigo;
	private BigDecimal preEstado;
	private String prePregunta;
	private BigDecimal prePresentar;
	private List<PenNivelPregunta> penNivelPreguntas;
	private PenTipoPregunta penTipoPregunta;
	private List<PenRespuesta> penRespuestas;

	public PenPregunta() {
	}


	@Id
	@SequenceGenerator(name="PEN_PREGUNTA_PRECODIGO_GENERATOR", sequenceName="SEQ_PEN_PREGUNTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_PREGUNTA_PRECODIGO_GENERATOR")
	@Column(name="PRE_CODIGO")
	public long getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(long preCodigo) {
		this.preCodigo = preCodigo;
	}


	@Column(name="PRE_ESTADO")
	public BigDecimal getPreEstado() {
		return this.preEstado;
	}

	public void setPreEstado(BigDecimal preEstado) {
		this.preEstado = preEstado;
	}


	@Column(name="PRE_PREGUNTA")
	public String getPrePregunta() {
		return this.prePregunta;
	}

	public void setPrePregunta(String prePregunta) {
		this.prePregunta = prePregunta;
	}


	@Column(name="PRE_PRESENTAR")
	public BigDecimal getPrePresentar() {
		return this.prePresentar;
	}

	public void setPrePresentar(BigDecimal prePresentar) {
		this.prePresentar = prePresentar;
	}


	//bi-directional many-to-one association to PenNivelPregunta
	@OneToMany(mappedBy="penPregunta")
	public List<PenNivelPregunta> getPenNivelPreguntas() {
		return this.penNivelPreguntas;
	}

	public void setPenNivelPreguntas(List<PenNivelPregunta> penNivelPreguntas) {
		this.penNivelPreguntas = penNivelPreguntas;
	}

	public PenNivelPregunta addPenNivelPregunta(PenNivelPregunta penNivelPregunta) {
		getPenNivelPreguntas().add(penNivelPregunta);
		penNivelPregunta.setPenPregunta(this);

		return penNivelPregunta;
	}

	public PenNivelPregunta removePenNivelPregunta(PenNivelPregunta penNivelPregunta) {
		getPenNivelPreguntas().remove(penNivelPregunta);
		penNivelPregunta.setPenPregunta(null);

		return penNivelPregunta;
	}


	//bi-directional many-to-one association to PenTipoPregunta
	@ManyToOne
	@JoinColumn(name="TPE_CODIGO")
	public PenTipoPregunta getPenTipoPregunta() {
		return this.penTipoPregunta;
	}

	public void setPenTipoPregunta(PenTipoPregunta penTipoPregunta) {
		this.penTipoPregunta = penTipoPregunta;
	}


	//bi-directional many-to-one association to PenRespuesta
	@OneToMany(mappedBy="penPregunta")
	public List<PenRespuesta> getPenRespuestas() {
		return this.penRespuestas;
	}

	public void setPenRespuestas(List<PenRespuesta> penRespuestas) {
		this.penRespuestas = penRespuestas;
	}

	public PenRespuesta addPenRespuesta(PenRespuesta penRespuesta) {
		getPenRespuestas().add(penRespuesta);
		penRespuesta.setPenPregunta(this);

		return penRespuesta;
	}

	public PenRespuesta removePenRespuesta(PenRespuesta penRespuesta) {
		getPenRespuestas().remove(penRespuesta);
		penRespuesta.setPenPregunta(null);

		return penRespuesta;
	}

}