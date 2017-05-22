package es.idealista.drone.util;

/**
 * The Enum Direccion.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public enum Direccion {
	
	/** The arriba. */
	ARRIBA(0, 1),
	
	/** The abajo. */
	ABAJO(0, -1),
	
	/** The derecha. */
	DERECHA(1, 0),
	
	/** The izquierda. */
	IZQUIERDA(-1, 0);
	
	/** The sentido X. */
	private int sentidoX;
	
	/** The sentido Y. */
	private int sentidoY;
	
	/** The incremento. */
	private double INCREMENTO = 0.5;
	
	/**
	 * Instantiates a new direccion.
	 *
	 * @param incX the sentido X
	 * @param incY the sentido Y
	 */
	private Direccion(int sentidoX, int sentidoY) {
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
	}
	
	/**
	 * Gets the inc X.
	 *
	 * @return the inc X
	 */
	public double getIncX(){
		return INCREMENTO * sentidoX;
	}

	/**
	 * Gets the inc Y.
	 *
	 * @return the inc Y
	 */
	public double getIncY(){
		return INCREMENTO * sentidoY;
	}

	/**
	 * Gets the sentido X.
	 *
	 * @return the sentido X
	 */
	public int getSentidoX() {
		return this.sentidoX;
	}

	/**
	 * Gets the sentido Y.
	 *
	 * @return the sentido Y
	 */
	public int getSentidoY() {
		return this.sentidoY;
	}
	
	
}
	