package ec.gob.educacion.encuentro.dto;

import ec.gob.educacion.model.encuentro.PenTipoPregunta;

/**
 * 
 * @author emilyMelissa
 * @version $Revision: 1.0 $ <p>[$Author: emilyMelissa $, $Date: 27 abr. 2021 $]</p>
 */

public class EncuEstPregDTO extends ErrorDTO {


	private long encCodigo;
	private long tpeCodigo;
	private String estCedula;
	
	public EncuEstPregDTO() {
		
	}

	public String getEstCedula() {
		return estCedula;
	}


	public void setEstCedula(String estCedula) {
		this.estCedula = estCedula;
	}
	public long getEncCodigo() {
		return encCodigo;
	}


	public void setEncCodigo(long encCodigo) {
		this.encCodigo = encCodigo;
	}



	public long getTpeCodigo() {
		return tpeCodigo;
	}

	public void setTpeCodigo(long tpeCodigo) {
		this.tpeCodigo = tpeCodigo;
	}
	

	public EncuEstPregDTO(long encCodigo, long tpeCodigo, String estCedula) {
		super();
		this.encCodigo = encCodigo;
		this.tpeCodigo = tpeCodigo;
		this.estCedula = estCedula;
	}

}
