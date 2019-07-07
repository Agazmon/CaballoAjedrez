package org.iesalandalus.programacion.ajedrez.modelo.dominio.direcciones;

public enum DireccionCaballo implements IDireccion {
	ARRIBA_IZQUIERDA("Arriba=[2], Izquierda=[1]", 2, -1), ARRIBA_DERECHA("Arriba=[2], Derecha=[1]", 2, 1),
	DERECHA_ARRIBA("Derecha=[2], Arriba=[1]",1,2), DERECHA_ABAJO("Derecha=[2], Abajo=[1]",-1,2),
	ABAJO_DERECHA("Abajo=[2], Derecha=[1]",-2,1), ABAJO_IZQUIERDA("Abajo=[2], Izquierda=[1]",-2,-1),
	IZQUIERDA_ABAJO("Izquierda=[2], Abajo=[1]",-1,-2), IZQUIERDA_ARRIBA("Izquierda=[2], Arriba=[1]",1,-2);

	private String cadenaDireccion;
	public int ejeX;
	public int ejeY;
	private DireccionCaballo(String cadena, int movY, int movX) {
		this.cadenaDireccion = cadena;
		this.ejeX=movX;
		this.ejeY=movY;
	}
	public int getMovX(){
		return this.ejeX;
	}
	public int getMovY(){
		return this.ejeY;
	}
	public String toString() {
		return cadenaDireccion;
	}
}
