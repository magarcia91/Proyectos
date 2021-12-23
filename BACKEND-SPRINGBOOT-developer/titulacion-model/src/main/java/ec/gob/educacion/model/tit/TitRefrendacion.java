package ec.gob.educacion.model.tit;

import ec.gob.educacion.model.censo.InsAsignacionCenso;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Marco on 15/01/2015.
 */
@Entity
@Table(name = "TIT_REFRENDACION")
@SequenceGenerator(name = "SEQ_TIT_REFRENDACION_GEN", sequenceName = "SEQ_TIT_REFRENDACION", allocationSize = 1)

public class TitRefrendacion implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private InsAsignacionCenso insAsignacionCenso;
    private TitParticipacionEst titParticipacionEst;
    
    private Long apruebaPPE;
    private Integer numRectificacion;
    private Integer numRezagado;
   // private Integer pesCodigo;
  //  private Integer codigo;

    public TitRefrendacion() {
    }

    @Id
    @Column(name = "REF_CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_TIT_REFRENDACION_GEN", strategy = GenerationType.SEQUENCE)
    public Integer getRefCodigo() {
        return refCodigo;
    }

    public void setRefCodigo(Integer refCodigo) {
        this.refCodigo = refCodigo;
    }

    @Column(name = "REF_CALIFUNO")
    public Double getRefCalifuno() {
        return refCalifuno;
    }

    public void setRefCalifuno(Double refCalifuno) {
        this.refCalifuno = refCalifuno;
    }

    @Column(name = "REF_CALIFDOS")
    public Double getRefCalifdos() {
        return refCalifdos;
    }

    public void setRefCalifdos(Double refCalifdos) {
        this.refCalifdos = refCalifdos;
    }

    @Column(name = "REF_CALIFTRES")
    public Double getRefCaliftres() {
        return refCaliftres;
    }

    public void setRefCaliftres(Double refCaliftres) {
        this.refCaliftres = refCaliftres;
    }

    @Column(name = "REF_CALIFCUATRO")
    public Double getRefCalifcuatro() {
        return refCalifcuatro;
    }

    public void setRefCalifcuatro(Double refCalifcuatro) {
        this.refCalifcuatro = refCalifcuatro;
    }

    @Column(name = "REF_PROMEDIO")
    public Double getRefPromedio() {
        return refPromedio;
    }

    public void setRefPromedio(Double refPromedio) {
        this.refPromedio = refPromedio;
    }

    @Column(name = "REF_ENES")
    public Long getRefEnes() {
        return refEnes;
    }

    public void setRefEnes(Long refEnes) {
        this.refEnes = refEnes;
    }

    @Column(name = "REF_VALUNO")
    public Long getRefValuno() {
        return refValuno;
    }

    public void setRefValuno(Long refValuno) {
        this.refValuno = refValuno;
    }

    @Column(name = "REF_VALDOS")
    public Long getRefValdos() {
        return refValdos;
    }

    public void setRefValdos(Long refValdos) {
        this.refValdos = refValdos;
    }

    @Column(name = "REF_VALTRES")
    public Long getRefValtres() {
        return refValtres;
    }

    public void setRefValtres(Long refValtres) {
        this.refValtres = refValtres;
    }

    @Column(name = "REF_VALCUATRO")
    public Long getRefValcuatro() {
        return refValcuatro;
    }

    public void setRefValcuatro(Long refValcuatro) {
        this.refValcuatro = refValcuatro;
    }

    @Column(name = "REF_VALCINCO")
    public Long getRefValcinco() {
        return refValcinco;
    }

    public void setRefValcinco(Long refValcinco) {
        this.refValcinco = refValcinco;
    }

    @Column(name = "REF_IMPRESION")
    public Long getRefImpresion() {
        return refImpresion;
    }

    public void setRefImpresion(Long refImpresion) {
        this.refImpresion = refImpresion;
    }

    
    @Column(name = "REF_FECHA_GRADO")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getRefFechaGrado() {
        return refFechaGrado;
    }

    public void setRefFechaGrado(Timestamp refFechaGrado) {
        this.refFechaGrado = refFechaGrado;
    }

    @Column(name = "REF_FECHA_REFRENDACION")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getRefFechaRefrendacion() {
        return refFechaRefrendacion;
    }

    public void setRefFechaRefrendacion(Timestamp refFechaRefrendacion) {
        this.refFechaRefrendacion = refFechaRefrendacion;
    }

    @Column(name = "REF_CODIGO_REF")
    public String getRefCodigoRef() {
        return refCodigoRef;
    }

    public void setRefCodigoRef(String refCodigoRef) {
        this.refCodigoRef = refCodigoRef;
    }

    @Column(name = "REF_PROMEDIO_LETRAS")
    public String getRefPromedioLetras() {
        return refPromedioLetras;
    }

    public void setRefPromedioLetras(String refPromedioLetras) {
        this.refPromedioLetras = refPromedioLetras;
    }

    @ManyToOne
	@JsonIgnore
    @JoinColumn(name = "CODIGO")
    public InsAsignacionCenso getInsAsignacionCenso() {
        return insAsignacionCenso;
    }

    public void setInsAsignacionCenso(InsAsignacionCenso insAsignacionCenso) {
        this.insAsignacionCenso = insAsignacionCenso;
    }

    @ManyToOne
	@JsonIgnore
    @JoinColumn(name = "PES_CODIGO")
    public TitParticipacionEst getTitParticipacionEst() {
        return titParticipacionEst;
    }

    public void setTitParticipacionEst(TitParticipacionEst titParticipacionEst) {
        this.titParticipacionEst = titParticipacionEst;
    }
 /*   @Column(name = "PES_CODIGO")
    public Integer getPesCodigo() {
		return pesCodigo;
	}

	public void setPesCodigo(Integer pesCodigo) {
		this.pesCodigo = pesCodigo;
	}

	 @Column(name = "CODIGO")
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}*/

    @Column(name = "APRUEBA_PPE")
	public Long getApruebaPPE() {
		return apruebaPPE;
	}

	public void setApruebaPPE(Long apruebaPPE) {
		this.apruebaPPE = apruebaPPE;
	}


    @Column(name = "NUM_RECTIFICACION")
	public Integer getNumRectificacion() {
		return numRectificacion;
	}

	public void setNumRectificacion(Integer numRectificacion) {
		this.numRectificacion = numRectificacion;
	}
	
	@Column(name = "NUM_REZAGADO")
	public Integer getNumRezagado() {
		return numRezagado;
	}

	public void setNumRezagado(Integer numRezagado) {
		this.numRezagado = numRezagado;
	}
}
