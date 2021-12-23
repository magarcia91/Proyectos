package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PEN_TIPO_PREGUNTA database table.
 * 
 */
@Entity
@Table(name="PEN_TIPO_PREGUNTA")
@NamedQuery(name="PenTipoPregunta.findAll", query="SELECT p FROM PenTipoPregunta p")
public class PenTipoPregunta implements Serializable {
	private static final long serialVersionUID = 1L;
	private long tpeCodigo;
	private BigDecimal tpeEstado;
	private String tpeNombre;
	private List<PenPregunta> penPreguntas;

	public PenTipoPregunta() {
	}


	@Id
	@SequenceGenerator(name="PEN_TIPO_PREGUNTA_TPECODIGO_GENERATOR", sequenceName="SEQ_PEN_TIPO_PREGUNTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_TIPO_PREGUNTA_TPECODIGO_GENERATOR")
	@Column(name="TPE_CODIGO")
	public long getTpeCodigo() {
		return this.tpeCodigo;
	}

	public void setTpeCodigo(long tpeCodigo) {
		this.tpeCodigo = tpeCodigo;
	}


	@Column(name="TPE_ESTADO")
	public BigDecimal getTpeEstado() {
		return this.tpeEstado;
	}

	public void setTpeEstado(BigDecimal tpeEstado) {
		this.tpeEstado = tpeEstado;
	}


	@Column(name="TPE_NOMBRE")
	public String getTpeNombre() {
		return this.tpeNombre;
	}

	public void setTpeNombre(String tpeNombre) {
		this.tpeNombre = tpeNombre;
	}


	//bi-directional many-to-one association to PenPregunta
	@OneToMany(mappedBy="penTipoPregunta")
	public List<PenPregunta> getPenPreguntas() {
		return this.penPreguntas;
	}

	public void setPenPreguntas(List<PenPregunta> penPreguntas) {
		this.penPreguntas = penPreguntas;
	}

	public PenPregunta addPenPregunta(PenPregunta penPregunta) {
		getPenPreguntas().add(penPregunta);
		penPregunta.setPenTipoPregunta(this);

		return penPregunta;
	}

	public PenPregunta removePenPregunta(PenPregunta penPregunta) {
		getPenPreguntas().remove(penPregunta);
		penPregunta.setPenTipoPregunta(null);

		return penPregunta;
	}

}