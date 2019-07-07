package org.iesalandalus.programacion.ajedrez.modelo.dominio.piezas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.ajedrez.modelo.dominio.Color;
import org.iesalandalus.programacion.ajedrez.modelo.dominio.Pieza;
import org.iesalandalus.programacion.ajedrez.modelo.dominio.Posicion;
import org.iesalandalus.programacion.ajedrez.modelo.dominio.direcciones.DireccionCaballo;
import org.iesalandalus.programacion.ajedrez.modelo.dominio.direcciones.IDireccion;

public class Caballo extends Pieza {
	protected ArrayList<DireccionCaballo> movimientosPieza;
	public Caballo() {
		super();
	}

	public Caballo(Color color, Posicion posicion) throws OperationNotSupportedException {
		setColor(color);
		setPosicion(posicion);
		setMovimientosPieza(new ArrayList<DireccionCaballo>(Arrays.asList(DireccionCaballo.values())));
		setTipoPieza("Caballo");
	}


	public Caballo(Posicion posicion, Color color) throws OperationNotSupportedException {
		setColor(color);
		setPosicion(posicion);
	}

	public Caballo(Caballo caballo) throws OperationNotSupportedException {
		if (caballo == null) {
			throw new NullPointerException("La pieza pasada es nula, no es válida.");
		} else {
			setColor(caballo.getColor());
			setPosicion(caballo.getPosicion());
		}
	}

	@Override
	public Posicion getPosicion() {
		return new Posicion(this.posicion);
	}

	@Override
	protected void setPosicion(Posicion posicion) throws OperationNotSupportedException {
		if (!(posicion.getColumna() == 'b') && !(posicion.getColumna() == 'g')) {
			throw new OperationNotSupportedException("Columna no valida para posicionar la pieza: Caballo.");
		} else if ((posicion.getFila() != 1) && (posicion.getFila() != 8)) {
			throw new OperationNotSupportedException("Fila no valida para posicionar la pieza: Caballo.");
		} else {
			if (getColor() == Color.BLANCO && (posicion.getFila() == 1)
					|| (getColor() == Color.NEGRO && (posicion.getFila() == 8))) {
				this.posicion = new Posicion(posicion);
			} else {
				throw new OperationNotSupportedException("Posición inicial no válida para la pieza: Caballo.");
			}
		}
	}
	public List<DireccionCaballo> getMovimientosPieza() {
		return this.movimientosPieza;
	}

	public void setMovimientosPieza(ArrayList<DireccionCaballo> movimientos) {
		this.movimientosPieza = movimientos;
	}
	private void setTipoPieza(String cadena) {
		this.tipoPieza=cadena;
	}
	public String getTipoPieza() {
		return this.tipoPieza;
	}

	@Override
	public void mover(IDireccion direccion) throws OperationNotSupportedException {
		if (!(movimientosPieza.contains(direccion))) {
			throw new OperationNotSupportedException("El movimiento no es valido para esta pieza.");
		} else {
			int nuevaFila = (direccion.getMovY() + getPosicion().getFila());
			char nuevaColumna = (char) (direccion.getMovX() + getPosicion().getColumna());
			if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'g') {
				throw new OperationNotSupportedException("El movimiento sacaría a la ficha del tablero.");
			} else {
				this.posicion = new Posicion(nuevaFila, nuevaColumna);
			}
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(posicion, getColor());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Caballo)) {
			return false;
		}
		Caballo other = (Caballo) obj;
		return posicion == other.posicion && getColor() == other.getColor() && tipoPieza == other.tipoPieza;
	}

	@Override
	public String toString() {
		return "Pieza: Caballo, " + getColor().toString() + ", " + getPosicion().toString();
	}

}
