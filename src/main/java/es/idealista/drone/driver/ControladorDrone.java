package es.idealista.drone.driver;

import java.util.List;

/**
 * The Interface ControladorDrone.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public interface ControladorDrone {
	
	/**
	 * Obtener urbanizaciones.
	 *
	 * @param coordenadaX the coordenada X
	 * @param coordenadaY the coordenada Y
	 * @param area the area
	 * @return the list
	 */
	public List<Long> obtenerUrbanizaciones(double coordenadaX, double coordenadaY, int area);

}
