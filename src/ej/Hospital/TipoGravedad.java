package ej.Hospital;
/**
 * 
 * @author orodicio
 * @version 1.0
 */
public enum TipoGravedad {
	/**
	 * ennumerados
	 */
	MUY_GRAVE(1), GRAVE(2), MENOS_GRAVE(3);
	private int rango;

	// constructor
	TipoGravedad(int rango) {
		this.rango = rango;
	}

/**
 * 
 * @return entero rango
 */
	int getRango() {
		return rango;
	}
}
