package org.iesalandalus.programacion.ajedrez.modelo.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ColorTest {
	Color color;

	@Test
	public void identificadoresValidosTest() {
		this.color = Color.BLANCO;
		assertEquals(Color.BLANCO, this.color);
		this.color = Color.NEGRO;
		assertEquals(Color.NEGRO, this.color);
	}

	@Test
	public void identificadoresNoValidosTest() {
		this.color = Color.BLANCO;
		assertNotEquals(Color.NEGRO, this.color);
		this.color = Color.NEGRO;
		assertNotEquals(Color.BLANCO, this.color);
	}

	@Test
	public void toStringTest() {
		this.color = Color.BLANCO;
		assertEquals(this.color.toString(),"Blanco");
		this.color = Color.NEGRO;
		assertEquals(this.color.toString(),"Negro");
	}
}
