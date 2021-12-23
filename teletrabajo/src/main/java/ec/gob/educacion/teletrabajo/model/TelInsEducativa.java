package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.util.List;


/**
 * The persistent class for the TEL_INS_EDUCATIVA database table.
 * 
 */
@Entity
@Table(name="tel_ins_educativa")
@NamedQuery(name="TelInsEducativa.findAll", query="SELECT t FROM TelInsEducativa t")
public class TelInsEducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_INS_EDUCATIVA_CODINSEDUCATIVA_GENERATOR", sequenceName="SEQ_TEL_INS_EDUCATIVA", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_INS_EDUCATIVA_CODINSEDUCATIVA_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_ins_educativa")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private long codInsEducativa;

	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String amie;

	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String nombre;

	@Column(name="sts_estado")
	private String stsEstado;

	//bi-directional many-to-one association to TelDistrito
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_distri_ins_educ")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private TelDistrito telDistrito;
	
	@Column(name="nemonico_oferta")
	@JsonView({DocenteController.CabeceraRegistroView.class})
	private String nemonicoOfertaEducativa;

	public TelInsEducativa() {
	}

	public long getCodInsEducativa() {
		return this.codInsEducativa;
	}

	public void setCodInsEducativa(long codInsEducativa) {
		this.codInsEducativa = codInsEducativa;
	}

	public String getAmie() {
		return this.amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public TelDistrito getTelDistrito() {
		return this.telDistrito;
	}

	public void setTelDistrito(TelDistrito telDistrito) {
		this.telDistrito = telDistrito;
	}

	public String getNemonicoOfertaEducativa() {
		return nemonicoOfertaEducativa;
	}

	public void setNemonicoOfertaEducativa(String nemonicoOfertaEducativa) {
		this.nemonicoOfertaEducativa = nemonicoOfertaEducativa;
	}

}