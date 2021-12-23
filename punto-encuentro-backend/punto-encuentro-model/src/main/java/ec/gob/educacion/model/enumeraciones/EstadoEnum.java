package ec.gob.educacion.model.enumeraciones;

/**
 * Enumeración para el manejo de estados de los registros
 *
 * @author Jorge Quishpe
 * @version $Revision: 1 $
 * 
 */
public enum EstadoEnum {

	ACTIVO(1), ELIMINADO(0);

	private final int estado;

	EstadoEnum(final int estado) {
		this.estado = estado;
	}

	public int getEstado() {
		return estado;
	}
}
