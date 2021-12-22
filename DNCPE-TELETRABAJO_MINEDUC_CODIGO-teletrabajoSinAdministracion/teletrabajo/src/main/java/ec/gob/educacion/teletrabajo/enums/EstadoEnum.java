package ec.gob.educacion.teletrabajo.enums;

public enum EstadoEnum {

	ACTIVO("A"), INACTIVO("I");

	private String valor;

	private EstadoEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
