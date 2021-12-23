package ec.gob.educacion.model.asignaciones;


import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by edgar.moreano on 21/02/2015.
 */

/**
 * InsGrado - VIMEWorks Cia. Ltda.
 */
@Entity
@Table(name = "INS_GRADO")
@SequenceGenerator(name = "SEQ_INS_GRADO_GEN", sequenceName = "SEQ_INS_GRADO", allocationSize = 1)

public class InsGrado implements Serializable {
    private static final long serialVersionUID = 8649066220726203757L;

    private long codigo;
    private String descripcion;
    private String nemonico;
    private Date fechaCreacion;
    private int estado;
    
	private InsNivel insNivel;

    private List<InsCursoCenso> insCursoCensos = new ArrayList<InsCursoCenso>(0);

    public InsGrado() {
    }

    public InsGrado(long codigo, String descripcion, InsNivel insNivel,
                    String nemonico, Date fechaCreacion, int estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nemonico = nemonico;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.insNivel = insNivel;
    }

    public InsGrado(long codigo, String descripcion, InsNivel insNivel,
                    String nemonico, Date fechaCreacion, int estado,
                    List<InsRegistroEstudiante> insRegistroEstudiantes,
                    List<InsCursoCenso> insCursoCensos)
                    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nemonico = nemonico;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.insCursoCensos = insCursoCensos;
        this.insNivel = insNivel;
    }

    @Id
    @Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_INS_GRADO_GEN", strategy = GenerationType.SEQUENCE)
    public long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    @Column(name = "DESCRIPCION", nullable = false, length = 60)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "NEMONICO", nullable = false, length = 60)
    public String getNemonico() {
        return this.nemonico;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CREACION", nullable = false, length = 7)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Column(name = "ESTADO", nullable = false, precision = 1, scale = 0)
    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "insGrado")
    public List<InsCursoCenso> getInsCursoCensos() {
        return this.insCursoCensos;
    }

    public void setInsCursoCensos(List<InsCursoCenso> insCursoCensos) {
        this.insCursoCensos = insCursoCensos;
    }

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_NIVEL", nullable = false)
	public InsNivel getInsNivel() {
		return insNivel;
	}

	public void setInsNivel(InsNivel insNivel) {
		this.insNivel = insNivel;
	}
}
