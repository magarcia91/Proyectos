package ec.gob.educacion.model.ministerio;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.gob.educacion.model.ministerio.InsRegAniLec;

/**
 * InsIncRegimen - desarrollo.
 */
@Entity
@Table(name = "INS_INC_REGIMEN")
@NamedQuery(name="InsIncRegimen.findAll", query="SELECT i FROM InsIncRegimen i")

public class InsIncRegimen implements Serializable {

	private static final long serialVersionUID = 5060310410408732801L;
	
	private long codigo;
	private String descripcion;
	private String estado;
	private List<InsRegAniLec> insRegAniLecs = new ArrayList<InsRegAniLec>(0);

	public InsIncRegimen() {
	}

	public InsIncRegimen(long codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public InsIncRegimen(long codigo, String descripcion, String estado,
			List<InsRegAniLec> insRegAniLecs) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.insRegAniLecs = insRegAniLecs;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@SequenceGenerator(name="INS_INC_REGIMEN_CODIGO_GENERATOR", sequenceName="SEQ_INS_INC_REGIMEN", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INS_INC_REGIMEN_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "ESTADO", length = 1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insIncRegimen")
	public List<InsRegAniLec> getInsRegAniLecs() {
		return this.insRegAniLecs;
	}

	public void setInsRegAniLecs(List<InsRegAniLec> insRegAniLecs) {
		this.insRegAniLecs = insRegAniLecs;
	}

}
