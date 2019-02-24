package ej.Hospital;

/**
 * Paciente: representa un paciente normal que ingresa en el hospital, cada
 * paciente tiene un identificador único que se genera consecutivamente cuando
 * se crea el objeto y el nombre de la persona.
 * 
 * @author orodicio
 * @version 1.0
 * 
 */
public class Paciente implements Comparable<Paciente> {
	/**
	 * variables de clase
	 */
	private static int numpaciente = 0;
	private int id;

	private String nombre;

	public Paciente(String nombre) {
		this.nombre = nombre;
		numpaciente++;
		this.id = numpaciente;
	}

	/**
	 * sobreescribimos el método toString
	 * 
	 * @return String
	 */
	public String toString() {
		return id + ":" + nombre;
	}

	/**
	 * Sobreescribimos el método compareto de la interfaz comparable para quee nos
	 * ordene por nombre el arrays.sort
	 */

	@Override
	public int compareTo(Paciente o) {
		return this.getNombre().toUpperCase().compareTo(o.getNombre().toUpperCase());

	}

	/**
	 * 
	 * @return devuelve el ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return devuelve el nombre del paciente
	 */

	public String getNombre() {
		return nombre;
	}
}
