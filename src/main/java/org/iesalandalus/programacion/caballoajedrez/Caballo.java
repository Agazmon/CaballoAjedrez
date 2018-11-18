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

	public void mover(Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		} else {
			switch (direccion) {
			case ARRIBA_IZQUIERDA:
				try {
					this.posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna() - 1));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case ARRIBA_DERECHA:
				try {
					this.posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna() + 1));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case DERECHA_ARRIBA:
				try {
					this.posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 2));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case DERECHA_ABAJO:
				try {
					this.posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 2));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case ABAJO_DERECHA:
				try {
					this.posicion = new Posicion(posicion.getFila() - 2, (char) (posicion.getColumna() + 1));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case ABAJO_IZQUIERDA:
				try {
					this.posicion = new Posicion(posicion.getFila() - 2, (char) (posicion.getColumna() - 1));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					} else {
						this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case IZQUIERDA_ARRIBA:
				try {
					this.posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 2));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					}
				} catch (IllegalArgumentException e) {
					this.posicion = new Posicion(posicion.getFila(), posicion.getColumna());
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
			case IZQUIERDA_ABAJO:
				try {
					this.posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 2));
					if ((posicion.getFila() < 1 | posicion.getColumna() < 'a')
							| (posicion.getFila() > 8 | posicion.getColumna() > 'g')) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido.");

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (direccion != other.direccion)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

}
/*
 * } else if (this.color.equals(Color.NEGRO)) { this.posicion = new
 * Posicion(posicion.getFila()-2, (char)(posicion.getColumna()+1)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); } } else if
 * (this.color.equals(Color.NEGRO)) {
 * 
 * this.posicion = new Posicion(posicion.getFila()-2,
 * (char)(posicion.getColumna()-1)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); } } else if
 * (this.color.equals(Color.NEGRO)) {
 * 
 * this.posicion = new Posicion(posicion.getFila()-1,
 * (char)(posicion.getColumna()-2)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); } } else if
 * (this.color.equals(Color.NEGRO)) {
 * 
 * this.posicion = new Posicion(posicion.getFila()+1,
 * (char)(posicion.getColumna()-2)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); }
 * 
 * 
 * 
 * 
 * } else if (this.color.equals(Color.NEGRO)) {
 * 
 * this.posicion = new Posicion(posicion.getFila()+2,
 * (char)(posicion.getColumna()-1)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); } } else if
 * (this.color.equals(Color.NEGRO)) {
 * 
 * this.posicion = new Posicion(posicion.getFila()+2,
 * (char)(posicion.getColumna()+1)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); } } else if
 * (this.color.equals(Color.NEGRO)) { this.posicion = new
 * Posicion(posicion.getFila()-1, (char)(posicion.getColumna()+2)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); } } else if
 * (this.color.equals(Color.NEGRO)) { this.posicion = new
 * Posicion(posicion.getFila()+1, (char)(posicion.getColumna()+2)); if
 * ((posicion.getFila()<1|posicion.getColumna()<'a')|(posicion.getFila()>8|
 * posicion.getColumna()>'g')) { throw new
 * OperationNotSupportedException("ERROR: Movimiento no válido."); }
 */