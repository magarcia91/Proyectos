package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INS_PAIS database table.
 * 
 */
@Entity
@Table(name="PEN_TEXTOS")
@NamedQuery(name="PenTextos.findAll", query="SELECT i FROM PenTextos i")
public class PenTextos implements Serializable {
	private static final long serialVersionUID = 1L;
    
	
	private long txtCodigo;
	private Integer txtEstado;
	private Integer graCodigo;
	private String txt_texto;


	public PenTextos() {
	}
	
	@Id
	@Column(name = "TXT_CODIGO")
	public long getTxtCodigo() {
		return txtCodigo;
	}


	public void setTxtCodigo(long txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	@Column(name = "TXT_ESTADO")
	public Integer getTxtEstado() {
		return txtEstado;
	}


	public void setTxtEstado(Integer txtEstado) {
		this.txtEstado = txtEstado;
	}

	@Column(name = "GRA_CODIGO")
	public Integer getGraCodigo() {
		return graCodigo;
	}


	public void setGraCodigo(Integer graCodigo) {
		this.graCodigo = graCodigo;
	}

	
	



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setTxt_texto(String txt_texto) {
		this.txt_texto = txt_texto;
	}
	@Column(name = "TXT_TEXTO")
	public String getTxt_texto() {
		return txt_texto;
	}

	

}