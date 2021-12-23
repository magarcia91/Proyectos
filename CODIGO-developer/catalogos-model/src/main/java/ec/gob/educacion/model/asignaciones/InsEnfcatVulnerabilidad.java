package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the INS_ENFCAT_VULNERABILIDAD database table.
 * 
 */
@Entity
@Table(name="INS_ENFCAT_VULNERABILIDAD")
@NamedQuery(name="InsEnfcatVulnerabilidad.findAll", query="SELECT i FROM InsEnfcatVulnerabilidad i")

public class InsEnfcatVulnerabilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INS_ENFCAT_VULNERABILIDAD_CODIGO_GENERATOR", sequenceName="SEQ_INS_ENFCAT_VULNERABILIDAD", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INS_ENFCAT_VULNERABILIDAD_CODIGO_GENERATOR")
	private long codigo;

	@Column(name="COD_ENFERMEDAD")
	private Long codEnfermedad;

	@Column(name="COD_VULNERABILIDAD")
	private Long codVulnerabilidad;

	private boolean tipo;

	//bi-directional many-to-one association to InsRegistroEstudiante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_REGISTRO_ESTUDIANTE")
	private InsRegistroEstudiante insRegistroEstudiante;

	public InsEnfcatVulnerabilidad() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Long getCodEnfermedad() {
		return this.codEnfermedad;
	}

	public void setCodEnfermedad(Long codEnfermedad) {
		this.codEnfermedad = codEnfermedad;
	}

	public Long getCodVulnerabilidad() {
		return this.codVulnerabilidad;
	}

	public void setCodVulnerabilidad(Long codVulnerabilidad) {
		this.codVulnerabilidad = codVulnerabilidad;
	}

	public boolean getTipo() {
		return this.tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public InsRegistroEstudiante getInsRegistroEstudiante() {
		return this.insRegistroEstudiante;
	}

	public void setInsRegistroEstudiante(InsRegistroEstudiante insRegistroEstudiante) {
		this.insRegistroEstudiante = insRegistroEstudiante;
	}

}