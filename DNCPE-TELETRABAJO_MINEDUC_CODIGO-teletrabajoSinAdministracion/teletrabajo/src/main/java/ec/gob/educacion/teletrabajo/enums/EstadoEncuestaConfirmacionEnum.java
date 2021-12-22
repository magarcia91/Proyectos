package ec.gob.educacion.teletrabajo.enums;

public enum EstadoEncuestaConfirmacionEnum {

	CONFIRMADA("C"), POR_CONFIRMAR("P"), POR_COMPLETAR("E");

	private String valor;

	private EstadoEncuestaConfirmacionEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
