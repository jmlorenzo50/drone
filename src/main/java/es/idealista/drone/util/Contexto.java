package es.idealista.drone.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.idealista.drone.driver.ControladorDroneImpl;
import es.idealista.drone.driver.ControladorIdealistaIDImpl;

/**
 * The Class Contexto.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public class Contexto {
	
	/** The contexto. */
	private static Contexto contexto;
	
	/** The application context. */
	private ApplicationContext applicationContext;
	
	/** The controlador idealista id. */
	private static String CONTROLADOR_IDEALISTA_ID = "controladorIdealistaID";
	
	/** The controlador drone. */
	private static String CONTROLADOR_DRONE = "controladorDrone";
	
	/**
	 * Instantiates a new contexto.
	 */
	private Contexto() {
		applicationContext = new ClassPathXmlApplicationContext("Spring-Module.xml");
	}
	
	/**
	 * Gets the single instance of Contexto.
	 *
	 * @return single instance of Contexto
	 */
	public static Contexto getInstance() {
		if (contexto == null) {
			contexto = new Contexto();
		}
		return contexto;
	}
	
	
	/**
	 * Gets the controlador.
	 *
	 * @return the controlador
	 */
	public ControladorIdealistaIDImpl getControladorIdealistaID() {
		return (ControladorIdealistaIDImpl) applicationContext.getBean(CONTROLADOR_IDEALISTA_ID); 
	}
	
	/**
	 * Gets the controlador drone.
	 *
	 * @return the controlador drone
	 */
	public ControladorDroneImpl getControladorDrone() {
		return (ControladorDroneImpl) applicationContext.getBean(CONTROLADOR_DRONE);
	}

}
