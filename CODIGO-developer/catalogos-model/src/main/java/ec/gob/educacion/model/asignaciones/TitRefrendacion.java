package ec.gob.educacion.model.asignaciones;

import javax.persistence.*;
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

    private long refCodigo;
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

    public TitRefrendacion() {
    }

    public TitRefrendacion(long refCodigo, Double refCalifuno, Double refCalifdos, Double refCaliftres, Double refCalifcuatro, Double refPromedio, Long refEnes, Long refValuno, Long refValdos, Long refValtres, Long refValcuatro, Long refValcinco, Long refImpresion, Timestamp refFechaGrado, Timestamp refFechaRefrendacion, String refCodigoRef, String refPromedioLetras,InsAsignacionCenso insAsignacionCenso, TitParticipacionEst titParticipacionEst, Long apruebaPPE, Integer numRectificacion, Integer numRezagado) {
        this.refCodigo = refCodigo;
        this.refCalifuno = refCalifuno;
        this.refCalifdos = refCalifdos;
        this.refCaliftres = refCaliftres;
        this.refCalifcuatro = refCalifcuatro;
        this.refPromedio = refPromedio;
        this.refEnes = refEnes;
        this.refValuno = refValuno;
        this.refValdos = refValdos;
        this.refValtres = refValtres;
        this.refValcuatro = refValcuatro;
        this.refValcinco = refValcinco;
        this.refImpresion = refImpresion;
        this.refFechaGrado = refFechaGrado;
        this.refFechaRefrendacion = refFechaRefrendacion;
        this.refCodigoRef = refCodigoRef;
        this.refPromedioLetras = refPromedioLetras;
        this.insAsignacionCenso = insAsignacionCenso;
        this.titParticipacionEst = titParticipacionEst;
        this.apruebaPPE = apruebaPPE;
        this.numRectificacion = numRectificacion;
        this.numRezagado = numRezagado;
    }

    @Id
    @Column(name = "REF_CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_TIT_REFRENDACION_GEN", strategy = GenerationType.SEQUENCE)
    public long getRefCodigo() {
        return refCodigo;
    }

    public void setRefCodigo(long refCodigo) {
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
    public Timestamp getRefFechaGrado() {
        return refFechaGrado;
    }

    public void setRefFechaGrado(Timestamp refFechaGrado) {
        this.refFechaGrado = refFechaGrado;
    }

    @Column(name = "REF_FECHA_REFRENDACION")
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
    @JoinColumn(name = "CODIGO")
    public InsAsignacionCenso getInsAsignacionCenso() {
        return insAsignacionCenso;
    }

    public void setInsAsignacionCenso(InsAsignacionCenso insAsignacionCenso) {
        this.insAsignacionCenso = insAsignacionCenso;
    }

    @ManyToOne
    @JoinColumn(name = "PES_CODIGO")
    public TitParticipacionEst getTitParticipacionEst() {
        return titParticipacionEst;
    }

    public void setTitParticipacionEst(TitParticipacionEst titParticipacionEst) {
        this.titParticipacionEst = titParticipacionEst;
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitRefrendacion that = (TitRefrendacion) o;

        if (refCodigo != that.refCodigo) return false;
        if (refCalifcuatro != null ? !refCalifcuatro.equals(that.refCalifcuatro) : that.refCalifcuatro != null) return false;
        if (refCalifdos != null ? !refCalifdos.equals(that.refCalifdos) : that.refCalifdos != null) return false;
        if (refCaliftres != null ? !refCaliftres.equals(that.refCaliftres) : that.refCaliftres != null) return false;
        if (refCalifuno != null ? !refCalifuno.equals(that.refCalifuno) : that.refCalifuno != null) return false;
        if (refCodigoRef != null ? !refCodigoRef.equals(that.refCodigoRef) : that.refCodigoRef != null) return false;
        if (refPromedioLetras != null ? !refPromedioLetras.equals(that.refPromedioLetras) : that.refPromedioLetras != null) return false;
        if (refEnes != null ? !refEnes.equals(that.refEnes) : that.refEnes != null) return false;
        if (refFechaGrado != null ? !refFechaGrado.equals(that.refFechaGrado) : that.refFechaGrado != null) return false;
        if (refFechaRefrendacion != null ? !refFechaRefrendacion.equals(that.refFechaRefrendacion) : that.refFechaRefrendacion != null) return false;
        if (refImpresion != null ? !refImpresion.equals(that.refImpresion) : that.refImpresion != null) return false;
        if (refPromedio != null ? !refPromedio.equals(that.refPromedio) : that.refPromedio != null) return false;
        if (refValcinco != null ? !refValcinco.equals(that.refValcinco) : that.refValcinco != null) return false;
        if (refValcuatro != null ? !refValcuatro.equals(that.refValcuatro) : that.refValcuatro != null) return false;
        if (refValdos != null ? !refValdos.equals(that.refValdos) : that.refValdos != null) return false;
        if (refValtres != null ? !refValtres.equals(that.refValtres) : that.refValtres != null) return false;
        if (refValuno != null ? !refValuno.equals(that.refValuno) : that.refValuno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (refCodigo ^ (refCodigo >>> 32));
        result = 31 * result + (refCalifuno != null ? refCalifuno.hashCode() : 0);
        result = 31 * result + (refCalifdos != null ? refCalifdos.hashCode() : 0);
        result = 31 * result + (refCaliftres != null ? refCaliftres.hashCode() : 0);
        result = 31 * result + (refCalifcuatro != null ? refCalifcuatro.hashCode() : 0);
        result = 31 * result + (refPromedio != null ? refPromedio.hashCode() : 0);
        result = 31 * result + (refEnes != null ? refEnes.hashCode() : 0);
        result = 31 * result + (refValuno != null ? refValuno.hashCode() : 0);
        result = 31 * result + (refValdos != null ? refValdos.hashCode() : 0);
        result = 31 * result + (refValtres != null ? refValtres.hashCode() : 0);
        result = 31 * result + (refValcuatro != null ? refValcuatro.hashCode() : 0);
        result = 31 * result + (refValcinco != null ? refValcinco.hashCode() : 0);
        result = 31 * result + (refImpresion != null ? refImpresion.hashCode() : 0);
        result = 31 * result + (refFechaGrado != null ? refFechaGrado.hashCode() : 0);
        result = 31 * result + (refFechaRefrendacion != null ? refFechaRefrendacion.hashCode() : 0);
        result = 31 * result + (refCodigoRef != null ? refCodigoRef.hashCode() : 0);
        result = 31 * result + (refPromedioLetras != null ? refPromedioLetras.hashCode() : 0);
        return result;
    }

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
