package es.idealista.drone;

import java.util.List;

import org.junit.Test;
import es.idealista.drone.driver.ControladorDroneImpl;
import es.idealista.drone.util.Contexto;
import junit.framework.Assert;

/**
 * The Class TestControladorDrone.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public class TestControladorDrone {
	
	/**
	 * The main method.
	 *
	 */
	@Test
	public void pruebaObtenerUrbanizaciones() {
		// GIVE
		double coordenadaX = 2.0;
		double coordenadaY = 2.0;
		
		Contexto contexto = Contexto.getInstance();
		ControladorDroneImpl controlDrone = contexto.getControladorDrone();
		
		// WHEN
		List<Long> listaIds = controlDrone.obtenerUrbanizaciones(coordenadaX, coordenadaY, controlDrone.getArea());
		
		// THEN
		boolean numerosValidos = true;
		for (int n = 1; n <= 25; n++) {
			numerosValidos = numerosValidos && n == listaIds.get(n-1);
		}
		Assert.assertTrue(numerosValidos);
		
		// Muestra por consola los ids oredenados
		StringBuffer ids = new StringBuffer();
		for (Long id : listaIds) {
			ids.append(id + " ");
		}
		System.out.println("Los ids calculados en orden son: " + ids);
	}

}
