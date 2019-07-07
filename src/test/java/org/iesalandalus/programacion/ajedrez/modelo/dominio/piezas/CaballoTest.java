package org.iesalandalus.programacion.ajedrez.modelo.dominio.piezas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.ajedrez.modelo.dominio.Color;
import org.iesalandalus.programacion.ajedrez.modelo.dominio.Posicion;
import org.iesalandalus.programacion.ajedrez.modelo.dominio.direcciones.DireccionCaballo;
import org.junit.Before;
import org.junit.Test;

public class CaballoTest {
	Caballo caballoBlanco1, caballoBlanco2, caballoNegro1, caballoNegro2;
	final String SOBRA_EXCEPCION = "No debería saltar excepción";
	final String FALTA_EXCEPCION = "Debería saltar excepción";

	@Before
	public void setUp() throws OperationNotSupportedException {
		try {
			this.caballoBlanco2 = new Caballo(Color.BLANCO, new Posicion('g', 1));
			this.caballoNegro2 = new Caballo(Color.NEGRO, new Posicion('g', 8));
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			fail(SOBRA_EXCEPCION);
		}

	}

	@Test
	public void caballoNoValidoTest() {
		try {
			Caballo caballoNoValidoColorNulo = new Caballo(null, new Posicion('b', 1));
		} catch (NullPointerException e) {
			assertEquals("El color de la pieza no puede ser nulo.", e.getMessage());
		} catch (OperationNotSupportedException e) {
			fail(SOBRA_EXCEPCION);
		}
		try {
			Caballo caballoNoValidoPosNula = new Caballo(Color.BLANCO, new Posicion(null));
		} catch (NullPointerException e) {
			assertEquals("La posicion pasada es nula, no es válida para posicionar la pieza.", e.getMessage());
		} catch (OperationNotSupportedException e) {
			fail(SOBRA_EXCEPCION);
		}
		try {
			Caballo caballoNoValidoFilaIncorrecta = new Caballo(Color.BLANCO, new Posicion(2, 'b'));
		} catch (NullPointerException e) {
			fail(SOBRA_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals("Fila no valida para posicionar la pieza: Caballo.", e.getMessage());
		}
		try {
			Caballo caballoNoValidoColumnaIncorrecta = new Caballo(Color.BLANCO, new Posicion('d', 2));
		} catch (NullPointerException e) {
			fail(SOBRA_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals("Columna no valida para posicionar la pieza: Caballo.", e.getMessage());
		}

	}

	@Test
	public void todosConstructoresTest() {
		try {
			Caballo caballoConstructores = new Caballo(new Posicion('b', 1), Color.BLANCO);
			caballoConstructores = new Caballo(caballoBlanco2);
			caballoConstructores = new Caballo(caballoBlanco1);
		} catch (OperationNotSupportedException e) {
			fail(SOBRA_EXCEPCION);
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "La pieza pasada es nula, no es válida.");
		}

	}

	@Test
	public void caballosPosicionOtroColorTest() {
		try {
			Caballo caballoBlancoPosNegro1 = new Caballo(Color.BLANCO, new Posicion('b', 8));
		} catch (OperationNotSupportedException e) {
			assertEquals("Posición inicial no válida para la pieza: Caballo.", e.getMessage());
		}
		try {
			Caballo caballoNegroPosBlanco1 = new Caballo(Color.NEGRO, new Posicion('b', 1));
		} catch (OperationNotSupportedException e) {
			assertEquals("Posición inicial no válida para la pieza: Caballo.", e.getMessage());
		}
	}
	@Test
	public void getMovimientosPieza(){
		assertEquals(caballoBlanco2.getMovimientosPieza(),new ArrayList<DireccionCaballo>(Arrays.asList(DireccionCaballo.values())));
	}

	@Test
	public void movimientosValidosTest() {
		try {
			caballoBlanco1 = new Caballo(Color.BLANCO, new Posicion('b', 1));
			caballoBlanco1.mover(DireccionCaballo.ARRIBA_DERECHA);
			caballoBlanco1.mover(DireccionCaballo.ARRIBA_IZQUIERDA);
			caballoBlanco1.mover(DireccionCaballo.ABAJO_DERECHA);
			caballoBlanco1.mover(DireccionCaballo.ABAJO_IZQUIERDA);
			caballoNegro1 = new Caballo(Color.NEGRO, new Posicion('b', 8));
			caballoNegro1.mover(DireccionCaballo.ABAJO_IZQUIERDA);
			caballoNegro1.mover(DireccionCaballo.ABAJO_DERECHA);
			caballoNegro1.mover(DireccionCaballo.ARRIBA_IZQUIERDA);
			caballoNegro1.mover(DireccionCaballo.ARRIBA_DERECHA);
		} catch (OperationNotSupportedException e) {
			fail(SOBRA_EXCEPCION);
		}
	}

	@Test
	public void movimientosFueraTest() {
		try {
			caballoBlanco1 = new Caballo(Color.BLANCO, new Posicion('b', 1));
			caballoBlanco1.mover(DireccionCaballo.ABAJO_DERECHA);
			fail(FALTA_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals(caballoBlanco1.getPosicion(), new Posicion('b', 1));
			assertEquals("El movimiento sacaría a la ficha del tablero.", e.getMessage());
		}
		try {
			caballoBlanco1.mover(DireccionCaballo.ABAJO_IZQUIERDA);
			fail(FALTA_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals(caballoBlanco1.getPosicion(), new Posicion('b', 1));
			assertEquals("El movimiento sacaría a la ficha del tablero.", e.getMessage());
		}
		try {
			caballoBlanco2.mover(DireccionCaballo.DERECHA_ABAJO);
			fail(FALTA_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals(caballoBlanco2.getPosicion(), new Posicion('g', 1));
			assertEquals("El movimiento sacaría a la ficha del tablero.", e.getMessage());
		}
		try {
			caballoNegro2.mover(DireccionCaballo.ARRIBA_IZQUIERDA);
			fail(FALTA_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals(caballoNegro2.getPosicion(), new Posicion('g', 8));
			assertEquals("El movimiento sacaría a la ficha del tablero.", e.getMessage());
		}
	}

	@Test
	public void movimientoNoPropio() {
		/*
		 * try { //caballoBlanco2.mover(DireccionPeon.ARRIBA_UNO); } catch
		 * (OperationNotSupportedException e) {
		 * assertEquals("El movimiento no es valido para esta pieza",e.getMessage()); }
		 */
	}

	@Test
	public void toStringTest() {
		assertEquals("Pieza: Caballo, Color=[Blanco], Posicion=[Fila=1, Columna=g]", caballoBlanco2.toString());
	}

	@Test
	public void equalsTest() {
		assertEquals(caballoBlanco2, caballoBlanco2);
		assertNotEquals(caballoBlanco2, null);
		assertNotEquals(caballoBlanco2, new Integer(2));
		assertNotEquals(caballoBlanco2, caballoNegro1);
		assertNotEquals(caballoBlanco2, caballoNegro2);
	}

}
