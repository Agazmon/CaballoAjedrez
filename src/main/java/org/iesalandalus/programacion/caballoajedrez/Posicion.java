package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	
	}
	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
		}
		posicion.fila=this.getFila();
		posicion.columna=this.getColumna();		
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
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
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[fila=" + fila + ", columna=" + columna + "]";
	}
	
}