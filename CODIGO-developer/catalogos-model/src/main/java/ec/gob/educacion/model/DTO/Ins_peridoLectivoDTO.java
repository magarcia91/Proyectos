package ec.gob.educacion.model.DTO;

/**
 * Created by edgar.moreano on 09/02/2015.
 */
public class Ins_peridoLectivoDTO {
	
	private Integer codRegAniLec;
	private Integer codInstitucion;
	private String regimenDescripcion;
	private Integer anioInicio;
	private Integer anioFin;
	
	
	public Integer getCodRegAniLec() {
		return codRegAniLec;
	}
	public void setCodRegAniLec(Integer codRegAniLec) {
		this.codRegAniLec = codRegAniLec;
	}
	public Integer getCodInstitucion() {
		return codInstitucion;
	}
	public void setCodInstitucion(Integer codInstitucion) {
		this.codInstitucion = codInstitucion;
	}
	public String getRegimenDescripcion() {
		return regimenDescripcion;
	}
	public void setRegimenDescripcion(String regimenDescripcion) {
		this.regimenDescripcion = regimenDescripcion;
	}
	public Integer getAnioInicio() {
		return anioInicio;
	}
	public void setAnioInicio(Integer anioInicio) {
		this.anioInicio = anioInicio;
	}
	public Integer getAnioFin() {
		return anioFin;
	}
	public void setAnioFin(Integer anioFin) {
		this.anioFin = anioFin;
	}


   

   
}
