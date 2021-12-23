package ec.gob.educacion.encuentro.dto;

import java.util.Date;


public class EncuestaDTO {

	private long encCodigo;
	private Integer encEstado;
	private Date encFechaCreacion;
	private long preCodigo;
	private long resCodigo;
	private long usuCodigo;
	private long estCodigo;
	
	public long getEncCodigo() {
		return encCodigo;
	}
	public void setEncCodigo(long encCodigo) {
		this.encCodigo = encCodigo;
	}
	public Integer getEncEstado() {
		return encEstado;
	}
	public void setEncEstado(Integer encEstado) {
		this.encEstado = encEstado;
	}
	public Date getEncFechaCreacion() {
		return encFechaCreacion;
	}
	public void setEncFechaCreacion(Date encFechaCreacion) {
		this.encFechaCreacion = encFechaCreacion;
	}
	public long getPreCodigo() {
		return preCodigo;
	}
	public void setPreCodigo(long preCodigo) {
		this.preCodigo = preCodigo;
	}
	public long getResCodigo() {
		return resCodigo;
	}
	public void setResCodigo(long resCodigo) {
		this.resCodigo = resCodigo;
	}
	public long getUsuCodigo() {
		return usuCodigo;
	}
	public void setUsuCodigo(long usuCodigo) {
		this.usuCodigo = usuCodigo;
	}
	public long getEstCodigo() {
		return estCodigo;
	}
	public void setEstCodigo(long estCodigo) {
		this.estCodigo = estCodigo;
	}
	
	
	
}
