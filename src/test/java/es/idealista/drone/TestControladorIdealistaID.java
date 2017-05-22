package es.idealista.drone;

import org.junit.Assert;
import org.junit.Test;

import es.idealista.drone.driver.ControladorIdealistaIDImpl;
import es.idealista.drone.util.Direccion;

/**
 * The Class TestControladorIdealistaID.
 *
 * @author jmlorenzo
 * @version 1.0.0
 * 22-may-2017 - Versión inicial
 */
public class TestControladorIdealistaID {
	

	/**
	 * Prueba area 1.
	 */
	@Test
	public void pruebaArea1() {
		// GIVE
		ControladorIdealistaIDImpl control = new ControladorIdealistaIDImpl(1);
		
		// WHEN
		long idControl = control.obtenerIdentificadorUrbanización(0, 0);
		System.out.println("\n\nPara area 1 casilla 1 es " + idControl);
		
		// THEN
		boolean correcto = true;
				
		try {
			System.out.println("Arriba " + control.obtenerAdyacente(idControl, Direccion.ARRIBA));
			correcto = false;
		} catch (Exception e) {
			System.out.println("Arriba fuera de area");
		}
		try {
			System.out.println("Abajo " + control.obtenerAdyacente(idControl, Direccion.ABAJO));
			correcto = false;
		} catch (Exception e) {
			System.out.println("Abajo fuera de area");
		}

		try {
			System.out.println("Izquierda " + control.obtenerAdyacente(idControl, Direccion.IZQUIERDA));
			correcto = false;
		} catch (Exception e) {
			System.out.println("Izquierda fuera de area");
		}
		
		try {
			System.out.println("Derecha " + control.obtenerAdyacente(idControl, Direccion.DERECHA));
			correcto = false;
		} catch (Exception e) {
			System.out.println("Derecha fuera de area");
		}
		
		Assert.assertTrue(correcto);
	}

	/**
	 * Prueba area 2.
	 */
	@Test
	public void pruebaArea2() {
		// GIVE
		ControladorIdealistaIDImpl control = new ControladorIdealistaIDImpl(2);
		
		// WHEN
		long idControl = control.obtenerIdentificadorUrbanización(1, 1);
		System.out.println("\n\nPara area 2 casilla 5 es " + idControl);
		
		// THEN
		boolean correcto = true;
		try {
			System.out.println("Arriba " + control.obtenerAdyacente(idControl, Direccion.ARRIBA));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.ARRIBA) == 2;
		} catch (Exception e) {
			System.out.println("Arriba fuera de area");
			correcto = false;
		}
		try {
			System.out.println("Abajo " + control.obtenerAdyacente(idControl, Direccion.ABAJO));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.ABAJO) == 8;
		} catch (Exception e) {
			System.out.println("Abajo fuera de area");
			correcto = false;
		}

		try {
			System.out.println("Izquierda " + control.obtenerAdyacente(idControl, Direccion.IZQUIERDA));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.IZQUIERDA) == 4;
		} catch (Exception e) {
			System.out.println("Izquierda fuera de area");
			correcto = false;
		}
		
		try {
			System.out.println("Derecha " + control.obtenerAdyacente(idControl, Direccion.DERECHA));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.DERECHA) == 6;
		} catch (Exception e) {
			System.out.println("Derecha fuera de area");
			correcto = false;
		}
		
		Assert.assertTrue(correcto);
	}

	
	/**
	 * Prueba area 3.
	 */
	@Test
	public void pruebaArea3() {
		// GIVE
		ControladorIdealistaIDImpl control = new ControladorIdealistaIDImpl(3);
		
		// WHEN
		long idControl = control.obtenerIdentificadorUrbanización(2, 2);
		System.out.println("\n\nPara area 3 casilla 13 es " + idControl);
		
		// THEN
		boolean correcto = true;
		try {
			System.out.println("Arriba " + control.obtenerAdyacente(idControl, Direccion.ARRIBA));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.ARRIBA) == 8;
		} catch (Exception e) {
			System.out.println("Arriba fuera de area");
			correcto = false;
		}
		try {
			System.out.println("Abajo " + control.obtenerAdyacente(idControl, Direccion.ABAJO));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.ABAJO) == 18;
		} catch (Exception e) {
			System.out.println("Abajo fuera de area");
			correcto = false;
		}

		try {
			System.out.println("Izquierda " + control.obtenerAdyacente(idControl, Direccion.IZQUIERDA));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.IZQUIERDA) == 12;
		} catch (Exception e) {
			System.out.println("Izquierda fuera de area");
			correcto = false;
		}
		
		try {
			System.out.println("Derecha " + control.obtenerAdyacente(idControl, Direccion.DERECHA));
			correcto = correcto && control.obtenerAdyacente(idControl, Direccion.DERECHA) == 14;
		} catch (Exception e) {
			System.out.println("Derecha fuera de area");
			correcto = false;
		}

		Assert.assertTrue(correcto);
	}
	
}
