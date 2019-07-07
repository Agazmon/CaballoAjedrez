package org.iesalandalus.programacion.ajedrez.modelo.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PosicionTest {
	private static final String FALTA_EXCEPCION = "Debería haber saltado una excepción";
	private static final String SOBRA_EXCEPCION = "No debería haber saltado una excepción";
	Posicion posicionValida, posicionLimiteInferiorIzquierda, posicionLimiteInferiorDerecha,
			posicionLimiteSuperiorIzquierda, posicionLimiteSuperiorDerecha;

	@Before
	public void setUp() {
		this.posicionValida = new Posicion(7, 'd');
		this.posicionLimiteInferiorIzquierda = new Posicion(1, 'a');
		this.posicionLimiteInferiorDerecha = new Posicion(1, 'h');
		this.posicionLimiteSuperiorIzquierda = new Posicion(8, 'a');
		this.posicionLimiteSuperiorDerecha = new Posicion(8, 'h');
	}

	@Test
	public void constructorCopiaValido() {
		Posicion posicionCopia = new Posicion(posicionValida);
		assertEquals(posicionCopia, posicionValida);
	}

	@Test
	public void posicionValidaTest() {
		assertEquals('d', posicionValida.getColumna());
		assertNotEquals('a', posicionValida.getColumna());
		assertEquals(7, posicionValida.getFila());
		assertNotEquals(1, posicionValida.getFila());
	}

	@Test
	public void posicionNoValidaLimitesTest() {
		Posicion posicionNoValida;
		try {
			posicionNoValida = new Posicion(4, '`');
			fail(FALTA_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "La columna no es válida para posicionar la pieza.");
		}
		try {
			posicionNoValida = new Posicion(4, 'i');
			fail(FALTA_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "La columna no es válida para posicionar la pieza.");
		}
		try {
			posicionNoValida = new Posicion(0, 'd');
			fail(FALTA_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "La fila no es válida para posicionar la pieza.");
		}
		try {
			posicionNoValida = new Posicion(9, 'd');
			fail(FALTA_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "La fila no es válida para posicionar la pieza.");
		}
	}

	@Test
	public void posicionLimitesTest() {
		try {
			assertEquals('a', posicionLimiteInferiorIzquierda.getColumna());
			assertEquals('h', posicionLimiteInferiorDerecha.getColumna());
			assertEquals('a', posicionLimiteSuperiorIzquierda.getColumna());
			assertEquals('h', posicionLimiteSuperiorDerecha.getColumna());
			assertEquals(1, posicionLimiteInferiorIzquierda.getFila());
			assertEquals(1, posicionLimiteInferiorDerecha.getFila());
			assertEquals(8, posicionLimiteSuperiorIzquierda.getFila());
			assertEquals(8, posicionLimiteSuperiorDerecha.getFila());
		} catch (Exception e) {
			fail(SOBRA_EXCEPCION);
		}
	}

	@Test
	public void posicionNulaTest() {
		try {
			Posicion posicionNula = new Posicion(null); 
			fail(FALTA_EXCEPCION);
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "La posicion pasada es nula, no es válida para posicionar la pieza.");
		}
	}

	@Test
	public void getValidosTest() {
		assertEquals('d', posicionValida.getColumna());
		assertEquals(7, posicionValida.getFila());
	}

	@Test
	public void equalsTest() {
		assertEquals(posicionValida, posicionValida);
		assertNotEquals(null, posicionValida);
		assertNotEquals(new Integer(1), posicionValida);
	}

	@Test
	public void toStringTest() {
		assertEquals("Posicion [fila=7, columna=d]",posicionValida.toString());
	}

}
