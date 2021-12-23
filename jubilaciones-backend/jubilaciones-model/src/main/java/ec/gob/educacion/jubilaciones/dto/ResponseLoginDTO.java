package ec.gob.educacion.jubilaciones.dto;

import java.util.List;
import java.util.Map;

/**
 * 
 * <b>
 * Este DTO representa la respuesta del servicio :.....
 * </b>
 *  
 * @author emilyMelissa
 * @version $Revision: 1.0 $ <p>[$Author: emilyMelissa $, $Date: 27 abr. 2021 $]</p>
 */

public class ResponseLoginDTO extends ErrorDTO {

	//private List<Integer> roles;
	private Map<Integer, String> roles;
	private String identificacion;
	private Long codPersona;
	private int codigo;
	private List<MenuDTO> menu;
	
	public ResponseLoginDTO() {
		
	}

	public Map<Integer, String> getRoles() {
		return roles;
	}
	public void setRoles(Map<Integer, String> roles) {
		this.roles = roles;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public Long getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(Long codPersona) {
		this.codPersona = codPersona;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public List<MenuDTO> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuDTO> menu) {
		this.menu = menu;
	}



}
