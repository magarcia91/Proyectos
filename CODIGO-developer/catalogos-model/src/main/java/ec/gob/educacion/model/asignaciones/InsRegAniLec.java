package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * InsRegAniLec - desarrollo.
 */
@Entity
@Table(name = "INS_REG_ANI_LEC")
@SequenceGenerator(name = "SEQ_INS_REG_ANI_LEC_GEN", sequenceName = "SEQ_INS_REG_ANI_LEC", allocationSize = 1)

public class InsRegAniLec implements Serializable {

	private static final long serialVersionUID = 830903760195623642L;

	private Integer codigo;
	private InsIncRegimen insIncRegimen;
	private InsIncAnioLectivo insIncAnioLectivo;
	private int estado;
	private String tipo;
	
	public InsRegAniLec() {
	}

	/*public InsRegAniLec(Integer codigo, InsIncRegimen insIncRegimen,
			InsIncAnioLectivo insIncAnioLectivo, int estado, String tipo) {
		this.codigo = codigo;
		this.insIncRegimen = insIncRegimen;
		this.insIncAnioLectivo = insIncAnioLectivo;
		this.estado = estado;
		this.tipo = tipo;
	}*/
	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_REG_ANI_LEC_GEN", strategy = GenerationType.SEQUENCE)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_INC_REGIMEN", nullable = false)
	@JsonIgnore
	public InsIncRegimen getInsIncRegimen() {
		return this.insIncRegimen;
	}

	public void setInsIncRegimen(InsIncRegimen insIncRegimen) {
		this.insIncRegimen = insIncRegimen;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_INC_ANIO_LECTIVO", nullable = false)
	@JsonIgnore
	public InsIncAnioLectivo getInsIncAnioLectivo() {
		return this.insIncAnioLectivo;
	}

	public void setInsIncAnioLectivo(InsIncAnioLectivo insIncAnioLectivo) {
		this.insIncAnioLectivo = insIncAnioLectivo;
	}

	@Column(name = "ESTADO", nullable = false, precision = 1, scale = 0)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "TIPO", nullable = false, precision = 1, scale = 0)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
