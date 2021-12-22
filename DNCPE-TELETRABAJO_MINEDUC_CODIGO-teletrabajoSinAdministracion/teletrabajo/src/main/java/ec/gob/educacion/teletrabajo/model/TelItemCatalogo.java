package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;


/**
 * The persistent class for the TEL_ITEM_CATALOGO database table.
 * 
 */
@Entity
@Table(name="tel_item_catalogo")
@NamedQuery(name="TelItemCatalogo.findAll", query="SELECT t FROM TelItemCatalogo t")
public class TelItemCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TEL_ITEM_CATALOGO_CODITEMCATALOGO_GENERATOR", sequenceName="SEQ_TEL_ITEM_CATALOGO", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_ITEM_CATALOGO_CODITEMCATALOGO_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_item_catalogo")
	@JsonView({DocenteController.ItemCatalogoView.class, DocenteController.CabeceraRegistroView.class})
	private long codItemCatalogo;

	@JsonView({DocenteController.ItemCatalogoView.class, DocenteController.CabeceraRegistroView.class})
	private String nemonico;

	@JsonView({DocenteController.ItemCatalogoView.class, DocenteController.CabeceraRegistroView.class})
	private String nombre;

	@Column(name="sts_estado")
	private String stsEstado;
	
	@Column(name="fk_item_catal_padre")	
	@JsonView({DocenteController.ItemCatalogoView.class, DocenteController.CabeceraRegistroView.class})
	private Long itemCatalogoPadre;

	//bi-directional many-to-one association to TelCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_catal_item_catal")
	@JsonView({DocenteController.ItemCatalogoView.class})
	private TelCatalogo telCatalogo;
	
	//OPCIONES DE ENCUESTA
	@Column(name="habilitar_preguntas")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private String habilitarPregunta;
	
	@Column(name="valor_habilitante")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private Integer valorHabilitante;
	
	@Column(name="valor_maximo")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private Integer valorMaximo;
	
	@Column(name="valor_minimo")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private Integer valorMinimo;
	
	@Column(name="valor_texto")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private String valorTexto;
	
	@Column(name="rango_min_max_padre")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private Long rangoValidacionEstablecidoPorPadre;
	
	@Column(name="valor_complemento")	
	@JsonView({DocenteController.ItemCatalogoView.class})
	private Long valorComplemento;
	
	@Transient
	@JsonView({DocenteController.ItemCatalogoView.class})
	private List<TelItemCatalogo> opcionesPregunta;
	
	@Transient
	@JsonView({DocenteController.ItemCatalogoView.class})
	private TelRegistroEncuesta respuesta;
	
	@Transient
	@JsonView({DocenteController.ItemCatalogoView.class})
	private List<TelRegistroEncuesta> respuestasOpcionMultiple;
	
	@Transient
	@JsonView({DocenteController.ItemCatalogoView.class})
	private boolean preguntaDeshabilitada;

	public TelItemCatalogo() {
	}

	public long getCodItemCatalogo() {
		return this.codItemCatalogo;
	}

	public void setCodItemCatalogo(long codItemCatalogo) {
		this.codItemCatalogo = codItemCatalogo;
	}

	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
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


	public TelCatalogo getTelCatalogo() {
		return this.telCatalogo;
	}

	public void setTelCatalogo(TelCatalogo telCatalogo) {
		this.telCatalogo = telCatalogo;
	}

	public List<TelItemCatalogo> getOpcionesPregunta() {
		return opcionesPregunta;
	}

	public void setOpcionesPregunta(List<TelItemCatalogo> opcionesPregunta) {
		this.opcionesPregunta = opcionesPregunta;
	}

	public Long getItemCatalogoPadre() {
		return itemCatalogoPadre;
	}

	public void setItemCatalogoPadre(Long itemCatalogoPadre) {
		this.itemCatalogoPadre = itemCatalogoPadre;
	}
	
	public boolean isPreguntaDeshabilitada() {
		return preguntaDeshabilitada;
	}

	public void setPreguntaDeshabilitada(boolean preguntaDeshabilitada) {
		this.preguntaDeshabilitada = preguntaDeshabilitada;
	}

	public String getHabilitarPregunta() {
		return habilitarPregunta;
	}

	public void setHabilitarPregunta(String habilitarPregunta) {
		this.habilitarPregunta = habilitarPregunta;
	}

	public TelRegistroEncuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(TelRegistroEncuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Integer getValorHabilitante() {
		return valorHabilitante;
	}

	public void setValorHabilitante(Integer valorHabilitante) {
		this.valorHabilitante = valorHabilitante;
	}

	public Integer getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Integer valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Integer getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Integer valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public String getValorTexto() {
		return valorTexto;
	}

	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

	public Long getRangoValidacionEstablecidoPorPadre() {
		return rangoValidacionEstablecidoPorPadre;
	}

	public void setRangoValidacionEstablecidoPorPadre(Long rangoValidacionEstablecidoPorPadre) {
		this.rangoValidacionEstablecidoPorPadre = rangoValidacionEstablecidoPorPadre;
	}

	public Long getValorComplemento() {
		return valorComplemento;
	}

	public void setValorComplemento(Long valorComplemento) {
		this.valorComplemento = valorComplemento;
	}

	public List<TelRegistroEncuesta> getRespuestasOpcionMultiple() {
		return respuestasOpcionMultiple;
	}

	public void setRespuestasOpcionMultiple(List<TelRegistroEncuesta> respuestasOpcionMultiple) {
		this.respuestasOpcionMultiple = respuestasOpcionMultiple;
	}

}