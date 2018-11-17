package org.iesalandalus.programacion.caballoajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Caballo {
	private Color color;
	private Posicion posicion;

	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'b');
	}

	public Caballo(Color color) {
		this.color = color;
		if (this.color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		} else {
			if (color.equals(Color.BLANCO)) {
				this.posicion = new Posicion(1, 'b');
			} else if (color.equals(Color.NEGRO)) {
				this.posicion = new Posicion(8, 'b');
			} else {
				throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
			}
		}
	}

	public Caballo(Color color, char columna) {
		this.color = color;
		System.out.println(this.color);
		if (this.color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		} else {
			if (columna == 'b' | columna == 'g') {
				if (color.equals(Color.BLANCO)) {
					this.posicion = new Posicion(1, columna);
				} else if (color.equals(Color.NEGRO)) {
					this.posicion = new Posicion(8, columna);
				}
			} else {
				throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
			}
		}
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