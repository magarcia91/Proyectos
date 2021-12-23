package ec.gob.educacion.jubilaciones.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SGD_JUB_TIPO_LEYES database table.
 * 
 */
@Entity
@Table(name="SGD_JUB_TIPO_LEYES")
@NamedQuery(name="SgdJubTipoLeyes.findAll", query="SELECT s FROM SgdJubTipoLeyes s")
public class SgdJubTipoLeyes implements Serializable {
	private static final long serialVersionUID = 1L;
	private long tiplCod;
	private Date tiplFecha;
	private String tiplNombre;

	public SgdJubTipoLeyes() {
	}


	@Id
	@SequenceGenerator(name="SGD_JUB_TIPO_LEYES_TIPLCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_TIPO_LEYES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_TIPO_LEYES_TIPLCOD_GENERATOR")
	@Column(name="TIPL_COD")
	public long getTiplCod() {
		return this.tiplCod;
	}

	public void setTiplCod(long tiplCod) {
		this.tiplCod = tiplCod;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="TIPL_FECHA")
	public Date getTiplFecha() {
		return this.tiplFecha;
	}

	public void setTiplFecha(Date tiplFecha) {
		this.tiplFecha = tiplFecha;
	}


	@Column(name="TIPL_NOMBRE")
	public String getTiplNombre() {
		return this.tiplNombre;
	}

	public void setTiplNombre(String tiplNombre) {
		this.tiplNombre = tiplNombre;
	}

}