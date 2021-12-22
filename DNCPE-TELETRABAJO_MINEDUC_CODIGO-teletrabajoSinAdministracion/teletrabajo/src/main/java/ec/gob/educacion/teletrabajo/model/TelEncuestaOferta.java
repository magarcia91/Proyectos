package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="tel_encuesta_oferta")
@NamedQuery(name="TelEncuestaOferta.findAll", query="SELECT t FROM TelEncuestaOferta t")
public class TelEncuestaOferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_encuesta_oferta")
	private long codEncuestaOferta;

	@Column(name="sts_estado")
	private String stsEstado;
	
	//bi-directional many-to-one association to TelCabeceraRegistro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_encuesta")
	private TelCatalogo telEncuesta;
	
	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_oferta_educativa")
	private TelItemCatalogo telOfertaEducativa;
	
	
	public TelEncuestaOferta() {
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public long getCodEncuestaOferta() {
		return codEncuestaOferta;
	}

	public void setCodEncuestaOferta(long codEncuestaOferta) {
		this.codEncuestaOferta = codEncuestaOferta;
	}

	public TelCatalogo getTelEncuesta() {
		return telEncuesta;
	}

	public void setTelEncuesta(TelCatalogo telEncuesta) {
		this.telEncuesta = telEncuesta;
	}

	public TelItemCatalogo getTelOfertaEducativa() {
		return telOfertaEducativa;
	}

	public void setTelOfertaEducativa(TelItemCatalogo telOfertaEducativa) {
		this.telOfertaEducativa = telOfertaEducativa;
	}
}