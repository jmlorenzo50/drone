package es.idealista.drone.driver;

import es.idealista.drone.exception.FueraAreaException;
import es.idealista.drone.util.Direccion;

/**
 * The Interface ControladorIdealistaID.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public interface ControladorIdealistaID {
	
	/**
	 * Obtener adyacente.
	 *
	 * @param identificadorUrbanizacionOrigen the identificador urbanizacion origen
	 * @param direccion the direccion
	 * @return the long
	 * @throws FueraAreaException the fuera area exception
	 */
	public long obtenerAdyacente(long identificadorUrbanizacionOrigen, Direccion direccion) throws FueraAreaException;
	
	/**
	 * Obtener identificador urbanización.
	 *
	 * @param coordenadaX the coordenada X
	 * @param coordenadaY the coordenada Y
	 * @return the long
	 */
	public long obtenerIdentificadorUrbanización(double coordenadaX, double coordenadaY);
	
	/**
	 * Gets the tam area.
	 *
	 * @return the tam area
	 */
	public int getTamArea();
}
