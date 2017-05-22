package es.idealista.drone.driver;

import java.util.ArrayList;
import java.util.List;

import es.idealista.drone.exception.FueraAreaException;
import es.idealista.drone.util.Direccion;

/**
 * The Class ControladorDrone.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public class ControladorDroneImpl implements ControladorDrone {
	
	/** The control. */
	private ControladorIdealistaID control;
	
	/** The posicion X. */
	private double posicionX;
	
	/** The posicion Y. */
	private double posicionY;
	

	/**
	 * Controlador por defecto.
	 */
	public ControladorDroneImpl() {
		super();
	}

	/**
	 * Instantiates a new controlador drone.
	 *
	 * @param control the control
	 */
	public ControladorDroneImpl(ControladorIdealistaIDImpl control) {
		this.control = control;
	}

	/**
	 * Establece el controlador.
	 *
	 * @param control the new control
	 */
	public void setControl(ControladorIdealistaIDImpl control) {
		this.control = control;
	}

	
	/**
	 * Posicionar parcela inicial.
	 */
	private void posicionarParcelaInicial(){
		// Busca la parte superior del area
		boolean mover = true;
		while (mover) {
			try {
				moverSiguienteParcela(Direccion.ARRIBA);
			} catch (FueraAreaException e) {
				// Se ha ubicado arriba del area
				mover = false;
			}
		}
		
		// Busca la esquina superior izquierda
		mover = true;
		while (mover) {
			try {
				moverSiguienteParcela(Direccion.IZQUIERDA);
			} catch (FueraAreaException e) {
				// Se ha ubicado a la izquierda del area
				mover = false;
			}
		}	

	}
	
	
	/**
	 * Obtener urbanizaciónes de manera ordenada. 
	 *
	 * @param coordenadaX the coordenada X
	 * @param coordenadaY the coordenada Y
	 * @param area the area
	 * @return the list
	 */
	public List<Long> obtenerUrbanizaciones(double coordenadaX, double coordenadaY, int area) {
		this.posicionX = coordenadaX;
		this.posicionY = coordenadaY;
		
		List<Long> listaId = new ArrayList<Long>();
		posicionarParcelaInicial();

		// Calcula posicion actual
		long idIni = control.obtenerIdentificadorUrbanización(posicionX, posicionY);
		listaId.add(idIni);

		boolean mover = true;
		boolean ultimaFila = false;
		
		while(!ultimaFila) {
			long id;
			// Va tomando los ids de las parcelas
			mover = true;
			while (mover) {
				try {
					id = moverSiguienteParcela(Direccion.DERECHA);
					listaId.add(id);
				} catch (FueraAreaException e) {
					mover = false;
				}
			}

			// Vuelve al inicio
			mover = true;
			while (mover) {
				try {
					id = moverSiguienteParcela(Direccion.IZQUIERDA);
				} catch (FueraAreaException e2) {
					mover = false;
				}
			}
			
			// Se baja a la siguiente fila
			try {
				id = moverSiguienteParcela(Direccion.ABAJO);
				listaId.add(id);
			} catch (FueraAreaException e3) {
				ultimaFila = true;
			}	
		}
		return listaId;
	}
	
	
	/**
	 * Mover siguiente parcela.
	 *
	 * @param direccion the direccion
	 * @return the long
	 * @throws FueraAreaException the fuera area exception
	 */
	private long moverSiguienteParcela(Direccion direccion) throws FueraAreaException {
		// Calcula posicion actual
		long idIni = control.obtenerIdentificadorUrbanización(posicionX, posicionY);
		
		// Calcula la siguiente parcela. En caso de estar fuera de area propaga la excepción
		long idFin = control.obtenerAdyacente(idIni, direccion);
		
		System.out.println("Drone se mueve de la parcela " + idIni + " a la " + idFin + " direccion " + direccion.name());
		long idActual = idIni;
		while (idActual != idFin) {
			this.posicionY = this.posicionY - direccion.getIncY();
			this.posicionX = this.posicionX + direccion.getIncX();
			idActual = control.obtenerIdentificadorUrbanización(posicionX, posicionY);
		}
		return idFin;
	}
	
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public int getArea() {
		return control.getTamArea();
	}
	
}
