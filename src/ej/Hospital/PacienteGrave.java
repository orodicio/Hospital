package ej.Hospital;

/**
 * hereda de la anterior clase, añadiendo un nuevo atributo que el grado de
 * gravedad siendo los valores posible un enumerado TipoGravedad con las
 * constante MUY_GRAVE, GRAVE, MENOS_GRAVE.
 * 
 * @author orodicio
 * @version 1.0
 */
public class PacienteGrave extends Paciente {
//Atributos
	private TipoGravedad gravedad;

	public PacienteGrave(String nombre, TipoGravedad gravedad) {
		super(nombre);
		this.gravedad = gravedad;
	}

	/**
	 * Sobreescribimos el método toString
	 * 
	 * @return string
	 */
	public String toString() {
		return super.toString() + ", " + gravedad;
	}

	/**
	 * 
	 * @return TipoGravedad que es un ennumerado
	 */
	public TipoGravedad getGravedad() {
		return gravedad;
	}
}
