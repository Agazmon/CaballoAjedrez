package org.iesalandalus.programacion.ajedrez.modelo.dominio;

import java.util.Objects;

public class Posicion {
	private int fila;
	private char columna;

	private Posicion() {
		// DO NOTHING
	}

	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	public Posicion(char columna, int fila) {
		setFila(fila);
		setColumna(columna);
	}

	public Posicion(Posicion posicionPasada) {
		if(posicionPasada == null) {
			throw new NullPointerException("La posicion pasada es nula, no es válida para posicionar la pieza.");
		} else {
		setFila(posicionPasada.getFila());
		setColumna(posicionPasada.getColumna());
		}
	}

	private void setFila(int filaPasada) {
		if (filaPasada <= 0 || filaPasada >= 9) {
			throw new IllegalArgumentException("La fila no es válida para posicionar la pieza.");
		} else {
			this.fila = filaPasada;
		}
	}

	private void setColumna(char columnaPasada) {
		if (columnaPasada <= '`' || columnaPasada >= 'i') {
			throw new IllegalArgumentException("La columna no es válida para posicionar la pieza.");
		} else {
			this.columna = columnaPasada;
		}
	}

	public int getFila() {
		return this.fila;
	}

	public char getColumna() {
		return this.columna;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	@Override
	public String toString() {
		return "Posicion=[Fila=" + fila + ", Columna=" + columna + "]";
	}

}
