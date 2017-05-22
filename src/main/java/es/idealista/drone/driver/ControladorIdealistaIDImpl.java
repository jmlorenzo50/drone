package es.idealista.drone.driver;

import es.idealista.drone.exception.FueraAreaException;
import es.idealista.drone.util.Direccion;

/**
 * The Class ControladorIdealistaID.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * Clase mokking para poder testear el sistema. Se ha de sustituir por la desarrollada por el 
 * departamente de I+D
 * 22-may-2017 - Versión inicial
 */
public class ControladorIdealistaIDImpl implements ControladorIdealistaID {
	
	/** The tam area. */
	private int tamArea;
	
	/** The tam matriz. */
	private int tamMatriz;
	
	
	/**
	 * Instantiates a new controlador idealista ID.
	 */
	public ControladorIdealistaIDImpl() {
		super();
	}
	
	/**
	 * Instantiates a new controlador idealista ID.
	 *
	 * @param tamArea the tam area
	 */
	public ControladorIdealistaIDImpl(int tamArea) {
		this.setTamArea(tamArea);
	}
	
	
	/**
	 * Sets the tam area.
	 *
	 * @param tamArea the new tam area
	 */
	public void setTamArea(int tamArea) {
		this.tamArea = tamArea;
		this.tamMatriz = this.tamArea * 2 - 1;
	}
	
	

	/**
	 * Gets the tam area.
	 *
	 * @return the tam area
	 */
	public int getTamArea() {
		return tamArea;
	}

	/**
	 * Obtener identificador urbanización.
	 *
	 * @param coordenadaX the coordenada X
	 * @param coordenadaY the coordenada Y
	 * @return the long
	 */
	public long obtenerIdentificadorUrbanización(double coordenadaX, double coordenadaY) {
		return ((long)coordenadaY) * tamMatriz + ((long)coordenadaX) + 1;
	}
	
	/**
	 * Obtener adyacente.
	 *
	 * @param identificadorUrbanizacionOrigen the identificador urbanizacion origen
	 * @param direccion the direccion
	 * @return the long
	 * @throws FueraAreaException the fuera area exception
	 */
	public long obtenerAdyacente(long identificadorUrbanizacionOrigen, Direccion direccion) throws FueraAreaException {
		long idTemp = identificadorUrbanizacionOrigen - 1;
		
		int filaIni = (int) (idTemp / this.tamMatriz); 
		int columnaIni = (int) (idTemp % this.tamMatriz);
		
		if (columnaIni == 0 && direccion == Direccion.IZQUIERDA){
			throw new FueraAreaException();
		}
		if (columnaIni == tamMatriz - 1 && direccion == Direccion.DERECHA){
			throw new FueraAreaException();
		}
		if (filaIni == 0 && direccion == Direccion.ARRIBA){
			throw new FueraAreaException();
		}
		if (filaIni == tamMatriz - 1 && direccion == Direccion.ABAJO){
			throw new FueraAreaException();
		}

		int columnaFin = columnaIni + direccion.getSentidoX();
		int filaFin = filaIni + direccion.getSentidoY() * -1;
		
		long id = filaFin * tamMatriz + columnaFin + 1;
		
		return id;
	}

}
