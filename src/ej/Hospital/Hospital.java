package ej.Hospital;

/**
 * Tiene una relación de los pacientes ingresados, almacenando en una arrays 
 * de objetos paciente. Tiene los métodos básicos de gestión: ingreso en el hospital,
 * alta hospitalaria, lista pacientes, buscar pacientes por id y obtener el paciente más urgente.
 * 
 * @author orodicio
 * @version 1.0
 */
import java.util.Arrays;

public class Hospital {
//atributos
	private Paciente tpacientes[];
	private int contadorpacientes;

	public Hospital(int numpacientes) {
		tpacientes = new Paciente[numpacientes];
		contadorpacientes = 0;
	}

	/**
	 * 
	 * @param p-tipo pacieente
	 * @return-booleano NoEstlleno que indica si se ha ingresado al paciente o no
	 */
	public boolean ingreso(Paciente p) {
		boolean Noestalleno = false;
		if (contadorpacientes < tpacientes.length) {
			this.tpacientes[contadorpacientes] = p;
			contadorpacientes++;
			Arrays.sort(tpacientes, 0, contadorpacientes);
			Noestalleno = true;
		}
		return Noestalleno;
	}

	/**
	 * 
	 * @param id_paciente-entero
	 * @return booleano que indica si se ha dado de alta el paciente o no
	 */
	public boolean alta(int id_paciente) {
		for (int i = 0; i < contadorpacientes; i++) {
			if (tpacientes[i].getId() == id_paciente) {
				for (int j = i; j < contadorpacientes - 1; j++) {
					tpacientes[j] = tpacientes[j + 1];
				}
				tpacientes[contadorpacientes - 1] = null;
				contadorpacientes--;
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param id-entero
	 * @return o un objeto de tipo paciente o null si el paciente no está en la
	 *         array
	 */
	public Paciente buscar(int id) {
		for (int i = 0; i < contadorpacientes; i++) {
			if (tpacientes[i].getId() == id) {
				return tpacientes[i];
			}
		}
		return null;
	}

	/**
	 * Imprime por consola la lista de los pacientes ordenados por nombre
	 */

	public void listapacientes() {
		for (int i = 0; i < contadorpacientes; i++) {
			System.out.println(tpacientes[i]);
		}
	}

	/**
	 * 
	 * @return el paciente que más gravedad tiene o el que tiene el id más bajo
	 * @see PacienteGrave.getGravedad
	 * @see TipoGravedad.getRango
	 */
	public Paciente pacienteMasUrgente() {
		PacienteGrave pacienteMasgrave = null;
		PacienteGrave acumulador = null;
		int veces = 0;// Sólo es para inicializar el objeto pacienteMasGrave. No me importa que apunte
						// a otro objeto, es sólo para comparar
		for (int i = 0; i < contadorpacientes; i++) {
			if (tpacientes[i] instanceof PacienteGrave) {// busco los que son pacientes graves
				if (veces == 0) {
					pacienteMasgrave = (PacienteGrave) tpacientes[i];
					veces++;// Lo aumento y no vuelve a entrar aquí
				} else {
					acumulador = (PacienteGrave) tpacientes[i];// el objeto acummulador es sólo para comparar. no me
																// importa ue apunte al mismo objeto
					if (pacienteMasgrave.getGravedad().getRango() > acumulador.getGravedad().getRango()) {
						pacienteMasgrave = acumulador;
					}
					if (pacienteMasgrave.getGravedad().getRango() == acumulador.getGravedad().getRango()) {
						if (pacienteMasgrave.getId() > acumulador.getId()) {
							pacienteMasgrave = acumulador;
						}
					}
				}
			}
		}
		return pacienteMasgrave;

	}
}
