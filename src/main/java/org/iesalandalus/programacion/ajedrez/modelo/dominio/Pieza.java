package org.iesalandalus.programacion.ajedrez.modelo.dominio;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.ajedrez.modelo.dominio.direcciones.IDireccion;

public abstract class Pieza {
	private Color color;
	protected Posicion posicion;
	protected String tipoPieza;

	protected Pieza() {
		// No hace nada
	}

	public abstract Posicion getPosicion();

	public Color getColor() {
		return this.color;
	}

	protected abstract void setPosicion(Posicion posicion) throws OperationNotSupportedException;

	protected void setColor(Color color) throws OperationNotSupportedException {
		if (this.color != null) {
			System.out.println(color.toString());
			throw new OperationNotSupportedException("No se puede cambiar el color a una pieza.");
		} else {
			if (color == null) {
				throw new NullPointerException("El color de la pieza no puede ser nulo.");
			} else {
				this.color = color;
			}
		}
	}

	public abstract void mover(IDireccion direccion) throws OperationNotSupportedException;

	public abstract boolean equals(Object obj);

	public abstract String toString();
}
