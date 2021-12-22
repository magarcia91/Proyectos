package ec.gob.educacion.teletrabajo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.controller.DocenteController;

import java.sql.Timestamp;


@Entity
@Table(name="tel_registro_encuesta")
@NamedQuery(name="TelRegistroEncuesta.findAll", query="SELECT t FROM TelRegistroEncuesta t")
public class TelRegistroEncuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_registro_encuesta")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private long codRegistroEncuesta;

	@Column(name="fecha_creacion")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name="sts_estado")
	private String stsEstado;

	@Column(name="usuario_creacion")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private String usuarioCreacion;

	@Column(name="usuario_modifico")
	private String usuarioModifico;
	
	@Column(name="valor_entero")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private Integer valorEntero;
	
	@Column(name="valor_decimal")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private Double valorDecimal;
	
	@Column(name="valor_texto")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private String valorTexto;
	
	@Column(name="valor_boolean")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private Integer valorBooleano;
	
	@Column(name="valor_opcion")
	@JsonView(DocenteController.ItemCatalogoView.class)
	private Long valorOpcion;

	//bi-directional many-to-one association to TelCabeceraRegistro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cabecera_registro")
	//@JsonView(DocenteController.ItemCatalogoView.class)
	private TelCabeceraRegistro telCabeceraRegistro;
	
	//bi-directional many-to-one association to TelItemCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_pregunta")
	//@JsonView(DocenteController.ItemCatalogoView.class)
	private TelItemCatalogo telPregunta;
	
	
	public TelRegistroEncuesta() {
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getStsEstado() {
		return this.stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModifico() {
		return this.usuarioModifico;
	}

	public void setUsuarioModifico(String usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}

	public TelCabeceraRegistro getTelCabeceraRegistro() {
		return this.telCabeceraRegistro;
	}

	public void setTelCabeceraRegistro(TelCabeceraRegistro telCabeceraRegistro) {
		this.telCabeceraRegistro = telCabeceraRegistro;
	}

	public long getCodRegistroEncuesta() {
		return codRegistroEncuesta;
	}

	public void setCodRegistroEncuesta(long codRegistroEncuesta) {
		this.codRegistroEncuesta = codRegistroEncuesta;
	}

	public Integer getValorEntero() {
		return valorEntero;
	}

	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
	}

	public Double getValorDecimal() {
		return valorDecimal;
	}

	public void setValorDecimal(Double valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	public String getValorTexto() {
		return valorTexto;
	}

	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

	public Integer getValorBooleano() {
		return valorBooleano;
	}

	public void setValorBooleano(Integer valorBooleano) {
		this.valorBooleano = valorBooleano;
	}

	public TelItemCatalogo getTelPregunta() {
		return telPregunta;
	}

	public void setTelPregunta(TelItemCatalogo telPregunta) {
		this.telPregunta = telPregunta;
	}

	public Long getValorOpcion() {
		return valorOpcion;
	}

	public void setValorOpcion(Long valorOpcion) {
		this.valorOpcion = valorOpcion;
	}
}