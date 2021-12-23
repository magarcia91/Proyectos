package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PEN_NIVEL_PREGUNTA database table.
 * 
 */
@Entity
@Table(name="PEN_NIVEL_PREGUNTA")
@NamedQuery(name="PenNivelPregunta.findAll", query="SELECT p FROM PenNivelPregunta p")
public class PenNivelPregunta implements Serializable {
	private static final long serialVersionUID = 1L;
	private long npeCodigo;
	private BigDecimal codGrado;
	private BigDecimal npeEstado;
	private PenPregunta penPregunta;

	public PenNivelPregunta() {
	}


	@Id
	@SequenceGenerator(name="PEN_NIVEL_PREGUNTA_NPECODIGO_GENERATOR", sequenceName="SEQ_PEN_NIVEL_PREGUNTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_NIVEL_PREGUNTA_NPECODIGO_GENERATOR")
	@Column(name="NPE_CODIGO")
	public long getNpeCodigo() {
		return this.npeCodigo;
	}

	public void setNpeCodigo(long npeCodigo) {
		this.npeCodigo = npeCodigo;
	}


	@Column(name="COD_GRADO")
	public BigDecimal getCodGrado() {
		return this.codGrado;
	}

	public void setCodGrado(BigDecimal codGrado) {
		this.codGrado = codGrado;
	}


	@Column(name="NPE_ESTADO")
	public BigDecimal getNpeEstado() {
		return this.npeEstado;
	}

	public void setNpeEstado(BigDecimal npeEstado) {
		this.npeEstado = npeEstado;
	}


	//bi-directional many-to-one association to PenPregunta
	@ManyToOne
	@JoinColumn(name="PRE_CODIGO")
	public PenPregunta getPenPregunta() {
		return this.penPregunta;
	}

	public void setPenPregunta(PenPregunta penPregunta) {
		this.penPregunta = penPregunta;
	}

}