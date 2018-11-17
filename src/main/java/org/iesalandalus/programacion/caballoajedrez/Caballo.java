package org.iesalandalus.programacion.caballoajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Caballo {
	private Color color;
	private Posicion posicion;
	
	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8,'b');
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
}