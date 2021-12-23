package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PEN_RESPUESTA database table.
 * 
 */
@Entity
@Table(name="PEN_RESPUESTA")
@NamedQuery(name="PenRespuesta.findAll", query="SELECT p FROM PenRespuesta p")
public class PenRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;
	private long resCodigo;
	private BigDecimal resCorrecta;
	private BigDecimal resEstado;
	private String resOrden;
	private String resRespuesta;
	private PenPregunta penPregunta;
	private PenRespuesta penRespuesta1;
	private PenRespuesta penRespuesta2;

	public PenRespuesta() {
	}


	@Id
	@SequenceGenerator(name="PEN_RESPUESTA_RESCODIGO_GENERATOR", sequenceName="SEQ_PEN_RESPUESTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_RESPUESTA_RESCODIGO_GENERATOR")
	@Column(name="RES_CODIGO")
	public long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(long resCodigo) {
		this.resCodigo = resCodigo;
	}


	@Column(name="RES_CORRECTA")
	public BigDecimal getResCorrecta() {
		return this.resCorrecta;
	}

	public void setResCorrecta(BigDecimal resCorrecta) {
		this.resCorrecta = resCorrecta;
	}


	@Column(name="RES_ESTADO")
	public BigDecimal getResEstado() {
		return this.resEstado;
	}

	public void setResEstado(BigDecimal resEstado) {
		this.resEstado = resEstado;
	}


	@Column(name="RES_ORDEN")
	public String getResOrden() {
		return this.resOrden;
	}

	public void setResOrden(String resOrden) {
		this.resOrden = resOrden;
	}


	@Column(name="RES_RESPUESTA")
	public String getResRespuesta() {
		return this.resRespuesta;
	}

	public void setResRespuesta(String resRespuesta) {
		this.resRespuesta = resRespuesta;
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


	//bi-directional one-to-one association to PenRespuesta
	@OneToOne
	@JoinColumn(name="RES_CODIGO")
	public PenRespuesta getPenRespuesta1() {
		return this.penRespuesta1;
	}

	public void setPenRespuesta1(PenRespuesta penRespuesta1) {
		this.penRespuesta1 = penRespuesta1;
	}


	//bi-directional one-to-one association to PenRespuesta
	@OneToOne(mappedBy="penRespuesta1")
	public PenRespuesta getPenRespuesta2() {
		return this.penRespuesta2;
	}

	public void setPenRespuesta2(PenRespuesta penRespuesta2) {
		this.penRespuesta2 = penRespuesta2;
	}

}