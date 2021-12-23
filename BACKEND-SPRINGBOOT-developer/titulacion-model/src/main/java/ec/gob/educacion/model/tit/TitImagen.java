package ec.gob.educacion.model.tit;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TIT_IMAGEN database table.
 * 
 */
@Entity
@Table(name="TIT_IMAGEN")
//@NamedQuery(name="TitImagen.findAllByEstado", query="SELECT t FROM TitImagen t where t.imsEstado = :estado and t.imgNombre = :nombre")
public class TitImagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IMG_CODIGO")
	private Integer imgCodigo;

	@Column(name="IMG_APLICACION")
	private String imgAplicacion;

	@Lob
	@Column(name="IMG_ARCHIVO")
	private byte[] imgArchivo;

	@Temporal(TemporalType.DATE)
	@Column(name="IMG_FECHA_ACTUALIZACION")
	private Date imgFechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="IMG_FECHA_CREACION")
	private Date imgFechaCreacion;


	@Column(name="IMG_NOMBRE")
	private String imgNombre;

	@Column(name="IMG_USUARIO_ACT")
	private String imgUsuarioAct;

	@Column(name="IMG_USUARIO_CREA")
	private String imgUsuarioCrea;

	@Column(name="IMS_ESTADO")
	private BigDecimal imsEstado;

	@Column(name="COD_REG_ANI_LEC")
	private Integer codRefAniLec;
	

	public TitImagen() {
	}

	public Integer getImgCodigo() {
		return this.imgCodigo;
	}

	public void setImgCodigo(Integer imgCodigo) {
		this.imgCodigo = imgCodigo;
	}

	public String getImgAplicacion() {
		return this.imgAplicacion;
	}

	public void setImgAplicacion(String imgAplicacion) {
		this.imgAplicacion = imgAplicacion;
	}

	public byte[] getImgArchivo() {
		return this.imgArchivo;
	}

	public void setImgArchivo(byte[] imgArchivo) {
		this.imgArchivo = imgArchivo;
	}

	public Date getImgFechaActualizacion() {
		return this.imgFechaActualizacion;
	}

	public void setImgFechaActualizacion(Date imgFechaActualizacion) {
		this.imgFechaActualizacion = imgFechaActualizacion;
	}

	public Date getImgFechaCreacion() {
		return this.imgFechaCreacion;
	}

	public void setImgFechaCreacion(Date imgFechaCreacion) {
		this.imgFechaCreacion = imgFechaCreacion;
	}

	public String getImgNombre() {
		return this.imgNombre;
	}

	public void setImgNombre(String imgNombre) {
		this.imgNombre = imgNombre;
	}

	public String getImgUsuarioAct() {
		return this.imgUsuarioAct;
	}

	public void setImgUsuarioAct(String imgUsuarioAct) {
		this.imgUsuarioAct = imgUsuarioAct;
	}

	public String getImgUsuarioCrea() {
		return this.imgUsuarioCrea;
	}

	public void setImgUsuarioCrea(String imgUsuarioCrea) {
		this.imgUsuarioCrea = imgUsuarioCrea;
	}

	public BigDecimal getImsEstado() {
		return this.imsEstado;
	}

	public void setImsEstado(BigDecimal imsEstado) {
		this.imsEstado = imsEstado;
	}

	public Integer getCodRefAniLec() {
		return codRefAniLec;
	}

	public void setCodRefAniLec(Integer codRefAniLec) {
		this.codRefAniLec = codRefAniLec;
	}

}