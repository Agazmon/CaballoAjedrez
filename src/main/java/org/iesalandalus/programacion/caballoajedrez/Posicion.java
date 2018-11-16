package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	public Posicion(Posicion posicion) {
		this.fila=getFila();
		this.columna=getColumna();
	}
	public void setFila(int fila) {
		if (fila < 1 | fila > 8 ) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}else {
			this.fila = fila;
		}	
	}
	public int getFila() {
		return this.fila;
	}
	public void setColumna(char columna) {
		if (columna < 'a' | columna > 'h' ) {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}else {
			this.columna = columna;
		}
	}
	public char getColumna() {
		return this.columna;
	}
}