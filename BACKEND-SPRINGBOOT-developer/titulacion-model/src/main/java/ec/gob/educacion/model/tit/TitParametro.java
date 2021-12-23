package ec.gob.educacion.model.tit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by javier.brito on 18/06/2015.
 */
@Entity
@Table(name="TIT_PARAMETRO")
@SequenceGenerator(name = "SEQ_TIT_PARAMETRO_GEN", sequenceName = "SEQ_TIT_PARAMETRO", allocationSize = 1)

public class TitParametro implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codigo;
    private String nombre;
    private String valor;
	private Date fecInicio;
	private Date fecFin;
    private String descripcion;

    private String stsEstado;
	private Date fecCreacion;
	private String nomUsuarioCrc;
	private Date fecActualizacion;
	private String nomUsuarioAct;
	private String nomAplicacion;
    
    @Id
    @Column(name = "PAR_CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_TIT_PARAMETRO_GEN", strategy = GenerationType.SEQUENCE)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Column(name="PAR_NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name="PAR_VALOR")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    @Column(name="PAR_DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="STS_ESTADO")
	public String getStsEstado() {
		return stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	@Column(name="FEC_CREACION")
	public Date getFecCreacion() {
		return fecCreacion;
	}

	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	
	@Column(name="NOM_USUARIO_CRC")
	public String getNomUsuarioCrc() {
		return nomUsuarioCrc;
	}

	public void setNomUsuarioCrc(String nomUsuarioCrc) {
		this.nomUsuarioCrc = nomUsuarioCrc;
	}

	@Column(name="FEC_ACTUALIZACION")
	public Date getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	@Column(name="NOM_USUARIO_ACT")
	public String getNomUsuarioAct() {
		return nomUsuarioAct;
	}

	public void setNomUsuarioAct(String nomUsuarioAct) {
		this.nomUsuarioAct = nomUsuarioAct;
	}

	@Column(name="NOM_APLICACION")
	public String getNomAplicacion() {
		return nomAplicacion;
	}

	public void setNomAplicacion(String nomAplicacion) {
		this.nomAplicacion = nomAplicacion;
	}

	@Column(name="FEC_INICIO")
	public Date getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	@Column(name="FEC_FIN")
	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}
}