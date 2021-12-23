package ec.gob.educacion.encuentro.dto;

import java.math.BigDecimal;

public class PreguntasDTO {

	private long preCodigo;
	private BigDecimal prePresentar;
	private String prePregunta;
	private long tpeCodigo ;
	
	public PreguntasDTO(long preCodigo, BigDecimal prePresentar, String prePregunta,
			long tpeCodigo) {
		super();
		this.preCodigo = preCodigo;
		this.prePresentar = prePresentar;
		this.prePregunta = prePregunta;
		this.tpeCodigo = tpeCodigo;
	}
	
	public String getPrePregunta() {
		return prePregunta;
	}

	public void setPrePregunta(String prePregunta) {
		this.prePregunta = prePregunta;
	}

	public long getPreCodigo() {
		return preCodigo;
	}

	public BigDecimal getPrePresentar() {
		return prePresentar;
	}
	public void setPreCodigo(long preCodigo) {
		this.preCodigo = preCodigo;
	}
	public void setPrePresentar(BigDecimal prePresentar) {
		this.prePresentar = prePresentar;
	}

	public long getTpeCodigo() {
		return tpeCodigo;
	}

	public void setTpeCodigo(long tpeCodigo) {
		this.tpeCodigo = tpeCodigo;
	}
	
	
}