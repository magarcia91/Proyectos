package ec.gob.educacion.encuentro.dto;

import java.math.BigDecimal;

public class DerespuestasDTO {

	private long preCodigo;
	private long resCodigo;
	private String resOrden;
	private String resRespuesta;
	private BigDecimal resEstado;
	
	public DerespuestasDTO(long preCodigo, long resCodigo, String resOrden, String resRespuesta, BigDecimal resEstado) {
		super();
		this.preCodigo = preCodigo;
		this.resCodigo = resCodigo;
		this.resOrden = resOrden;
		this.resRespuesta = resRespuesta;
		this.resEstado = resEstado;
	}
	
	public long getPreCodigo() {
		return preCodigo;
	}
	public long getResCodigo() {
		return resCodigo;
	}
	public String getResOrden() {
		return resOrden;
	}
	public String getResRespuesta() {
		return resRespuesta;
	}
	public void setPreCodigo(long preCodigo) {
		this.preCodigo = preCodigo;
	}
	public void setResCodigo(long resCodigo) {
		this.resCodigo = resCodigo;
	}
	public void setResOrden(String resOrden) {
		this.resOrden = resOrden;
	}
	public void setResRespuesta(String resRespuesta) {
		this.resRespuesta = resRespuesta;
	}

	public BigDecimal getResEstado() {
		return resEstado;
	}
	public void setResEstado(BigDecimal resEstado) {
		this.resEstado = resEstado;
	}
	
}