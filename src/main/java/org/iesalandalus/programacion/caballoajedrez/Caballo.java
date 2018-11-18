package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Caballo {
	private Color color;
	private Posicion posicion;
	private Direccion direccion;

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
	public void mover(Direccion direccion) throws OperationNotSupportedException{ 
		if (direccion == null) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		} else {
		switch (direccion) {
			case ARRIBA_IZQUIERDA:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()+2, (char)(posicion.getColumna()-1));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()-2, (char)(posicion.getColumna()+1));
					}
				} catch (IllegalArgumentException e) {
					this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case ARRIBA_DERECHA:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()+2, (char)(posicion.getColumna()+1));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()-2, (char)(posicion.getColumna()-1));
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case DERECHA_ARRIBA:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()+1, (char)(posicion.getColumna()+2));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()-1, (char)(posicion.getColumna()-2));
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case DERECHA_ABAJO:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()-1, (char)(posicion.getColumna()+2));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()+1, (char)(posicion.getColumna()-2));
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case ABAJO_DERECHA:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()-2, (char)(posicion.getColumna()+1));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()+2, (char)(posicion.getColumna()-1));
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case ABAJO_IZQUIERDA:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()-2, (char)(posicion.getColumna()-1));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()+2, (char)(posicion.getColumna()+1));
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case IZQUIERDA_ARRIBA:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()+1, (char)(posicion.getColumna()-2));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()-1, (char)(posicion.getColumna()+2));
					}
				} catch (IllegalArgumentException e) {
					this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case IZQUIERDA_ABAJO:
				try {
					if (this.color.equals(Color.BLANCO)) {
						this.posicion = new Posicion(posicion.getFila()-1, (char)(posicion.getColumna()-2));
					} else if (this.color.equals(Color.NEGRO)) {
						this.posicion = new Posicion(posicion.getFila()+1, (char)(posicion.getColumna()+2));
					} else {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			}
		}
	}
}
