package org.iesalandalus.programacion.caballoajedrez;
import org.iesalandalus.programacion.utilidades.Entrada;
public class Posicion {
	private int fila;
	private char columna;
	
	public void setFila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("La fila introducida no es válida, porfavor utilice otra entre 1 y 8.");
		}else {
			this.fila = fila;
		}	
	}
	public int getFila() {
		return this.fila;
	}
	public void setColumna(char columna) {
		if (columna < 'a' && columna > 'h' || columna < 'A' && columna > 'H') {
			throw new IllegalArgumentException("La columna introducida no es válida, porfavor utilice otra entre A y H");
		}else {
			this.columna = columna;
		}
	}
	public char getColumna() {
		return this.columna;
	}
}