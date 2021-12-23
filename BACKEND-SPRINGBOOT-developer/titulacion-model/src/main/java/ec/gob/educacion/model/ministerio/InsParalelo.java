package ec.gob.educacion.model.ministerio;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.gob.educacion.model.censo.InsParaleloCenso;

/**
 * InsParalelo - desarrollo.
 */
@Entity
@Table(name = "INS_PARALELO")
@SequenceGenerator(name = "SEQ_INS_PARALELO_GEN", sequenceName = "SEQ_INS_PARALELO", allocationSize = 1)

public class InsParalelo implements Serializable {

	private static final long serialVersionUID = -4233311824192750856L;
	
	private long codigo;
	private String descripcion;
	private Date fechaCreacion;
	private int estado;
	private List<InsParaleloCenso> insParaleloCensos = new ArrayList<InsParaleloCenso>(
			0);
	
	private boolean seleccionado;

	public InsParalelo() {
	}

	public InsParalelo(long codigo, String descripcion, Date fechaCreacion,
			int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsParalelo(long codigo, String descripcion, Date fechaCreacion,
			int estado, List<InsParaleloCenso> insParaleloCensos) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insParaleloCensos = insParaleloCensos;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_PARALELO_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 1)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insParalelo")
	public List<InsParaleloCenso> getInsParaleloCensos() {
		return this.insParaleloCensos;
	}

	public void setInsParaleloCensos(List<InsParaleloCenso> insParaleloCensos) {
		this.insParaleloCensos = insParaleloCensos;
	}

	@Transient
	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

}
