package ec.gob.educacion.jubilaciones.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SGD_JUB_INTERES database table.
 * 
 */
@Entity
@Table(name="SGD_JUB_INTERES")
@NamedQuery(name="SgdJubInteres.findAll", query="SELECT s FROM SgdJubInteres s")
public class SgdJubInteres implements Serializable {
	private static final long serialVersionUID = 1L;
	private long intCod;
	private String intNombre;

	public SgdJubInteres() {
	}


	@Id
	@SequenceGenerator(name="SGD_JUB_INTERES_INTCOD_GENERATOR", sequenceName="SEQ_SGD_JUB_INTERES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SGD_JUB_INTERES_INTCOD_GENERATOR")
	@Column(name="INT_COD")
	public long getIntCod() {
		return this.intCod;
	}

	public void setIntCod(long intCod) {
		this.intCod = intCod;
	}


	@Column(name="INT_NOMBRE")
	public String getIntNombre() {
		return this.intNombre;
	}

	public void setIntNombre(String intNombre) {
		this.intNombre = intNombre;
	}

}