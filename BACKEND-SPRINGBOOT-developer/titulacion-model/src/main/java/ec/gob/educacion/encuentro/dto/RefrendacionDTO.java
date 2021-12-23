package ec.gob.educacion.encuentro.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RefrendacionDTO {

	    private Integer refCodigo;
	    private Double refCalifuno;
	    private Double refCalifdos;
	    private Double refCaliftres;
	    private Double refCalifcuatro;
	    private Double refPromedio;
	    private Long refEnes;
	    private Long refValuno;
	    private Long refValdos;
	    private Long refValtres;
	    private Long refValcuatro;
	    private Long refValcinco;
	    private Long refImpresion;
	    private Timestamp refFechaGrado;
	    private Timestamp refFechaRefrendacion;
	    private String refCodigoRef;
	    private String refPromedioLetras;	    
	    private Long apruebaPPE;
	    private Integer numRectificacion;
	    private Integer numRezagado;
	    
	    private Integer pesCodigo;
	    private Integer codigo;

	
	public RefrendacionDTO() {
	}


	public Integer getRefCodigo() {
		return refCodigo;
	}


	public void setRefCodigo(Integer refCodigo) {
		this.refCodigo = refCodigo;
	}


	public Double getRefCalifuno() {
		return refCalifuno;
	}


	public void setRefCalifuno(Double refCalifuno) {
		this.refCalifuno = refCalifuno;
	}


	public Double getRefCalifdos() {
		return refCalifdos;
	}


	public void setRefCalifdos(Double refCalifdos) {
		this.refCalifdos = refCalifdos;
	}


	public Double getRefCaliftres() {
		return refCaliftres;
	}


	public void setRefCaliftres(Double refCaliftres) {
		this.refCaliftres = refCaliftres;
	}


	public Double getRefCalifcuatro() {
		return refCalifcuatro;
	}


	public void setRefCalifcuatro(Double refCalifcuatro) {
		this.refCalifcuatro = refCalifcuatro;
	}


	public Double getRefPromedio() {
		return refPromedio;
	}


	public void setRefPromedio(Double refPromedio) {
		this.refPromedio = refPromedio;
	}


	public Long getRefEnes() {
		return refEnes;
	}


	public void setRefEnes(Long refEnes) {
		this.refEnes = refEnes;
	}


	public Long getRefValuno() {
		return refValuno;
	}


	public void setRefValuno(Long refValuno) {
		this.refValuno = refValuno;
	}


	public Long getRefValdos() {
		return refValdos;
	}


	public void setRefValdos(Long refValdos) {
		this.refValdos = refValdos;
	}


	public Long getRefValtres() {
		return refValtres;
	}


	public void setRefValtres(Long refValtres) {
		this.refValtres = refValtres;
	}


	public Long getRefValcuatro() {
		return refValcuatro;
	}


	public void setRefValcuatro(Long refValcuatro) {
		this.refValcuatro = refValcuatro;
	}


	public Long getRefValcinco() {
		return refValcinco;
	}


	public void setRefValcinco(Long refValcinco) {
		this.refValcinco = refValcinco;
	}


	public Long getRefImpresion() {
		return refImpresion;
	}


	public void setRefImpresion(Long refImpresion) {
		this.refImpresion = refImpresion;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Timestamp getRefFechaGrado() {
		return refFechaGrado;
	}

	
	public void setRefFechaGrado(Timestamp refFechaGrado) {
		this.refFechaGrado = refFechaGrado;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Timestamp getRefFechaRefrendacion() {
		return refFechaRefrendacion;
	}


	public void setRefFechaRefrendacion(Timestamp refFechaRefrendacion) {
		this.refFechaRefrendacion = refFechaRefrendacion;
	}


	public String getRefCodigoRef() {
		return refCodigoRef;
	}


	public void setRefCodigoRef(String refCodigoRef) {
		this.refCodigoRef = refCodigoRef;
	}


	public String getRefPromedioLetras() {
		return refPromedioLetras;
	}


	public void setRefPromedioLetras(String refPromedioLetras) {
		this.refPromedioLetras = refPromedioLetras;
	}


	public Long getApruebaPPE() {
		return apruebaPPE;
	}


	public void setApruebaPPE(Long apruebaPPE) {
		this.apruebaPPE = apruebaPPE;
	}


	public Integer getNumRectificacion() {
		return numRectificacion;
	}


	public void setNumRectificacion(Integer numRectificacion) {
		this.numRectificacion = numRectificacion;
	}


	public Integer getNumRezagado() {
		return numRezagado;
	}


	public void setNumRezagado(Integer numRezagado) {
		this.numRezagado = numRezagado;
	}


	public Integer getPesCodigo() {
		return pesCodigo;
	}


	public void setPesCodigo(Integer pesCodigo) {
		this.pesCodigo = pesCodigo;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	

}
