package org.iesalandalus.programacion.caballoajedrez;

/*
 * @author Alejandro Jesús Gázquez Monedero
 */
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.caballoajedrez.*;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.caballoajedrez.Caballo;

public class MainApp {

	public static void main(String[] args) {
		MainApp.mostrarMenu();
		MainApp.ejecutarOpcion(elegirOpcion());
	}

	private static void mostrarMenu() {
		System.out.println("1:");
		System.out.println("2:");
		System.out.println("3:");
		System.out.println("4:");
		System.out.println("5: Salir");
	}

	private static int elegirOpcion() {
		int opcion;
		do {
			System.out.println("Elige una opcion entre 1 y 5");
			opcion = Entrada.entero();
		} while (opcion < 1 | opcion > 5);
		return opcion;
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			crearCaballoDefecto();
			System.out.println("Se ha creado un caballo por defecto");
		case 2:
			crearCaballoDefectoColor();
			System.out.println("Se ha creado un caballo con el color indicado");
		case 3:
			crearCaballoColorPosicion();
		case 4:
			moverCaballo();
			System.out.println("Movido el caballo");
		case 5:
			System.out.println("Has salido");
			break;
		}
	}

	private static void crearCaballoDefecto() {
		Caballo caballoDefecto;
		caballoDefecto = new Caballo();
	}

	private static void crearCaballoDefectoColor() {
		Caballo caballoDefectoColor;
		caballoDefectoColor = new Caballo(elegirColor());
	}

	private static Color elegirColor() {
		String colorCadena;
		Color color;
		do {
			System.out.println("Indica el color (BLANCO o NEGRO)");
			colorCadena = Entrada.cadena();
			if (colorCadena.equals("BLANCO")) {
				color = Color.BLANCO;
			} else if (colorCadena.equals("NEGRO")) {
				color = Color.NEGRO;
			} else {
				throw new IllegalArgumentException("Color no válido");
			}
		} while (!(colorCadena.equals("BLANCO")) | !(colorCadena.equals("NEGRO")));
		return color;
	}

	private static void crearCaballoColorPosicion() {
		Caballo caballoColorPosicion;
		caballoColorPosicion = new Caballo(elegirColor(), elegirColumnaInicial());
	}

	private static char elegirColumnaInicial() {
		char columna;
		do {
			System.out.println("Indica la columna inicial");
			columna = Entrada.caracter();
		} while (columna != 'g' | columna != 'b');
		return columna;
	}

	private static void moverCaballo() {
		Direccion direccion;
		mostrarMenuDirecciones();
		direccion=elegirDireccion();
		Caballo.mover(direccion);
	}
	private static void mostrarMenuDirecciones() {
		System.out.println("ARRIBA_IZQUIERDA");
		System.out.println("ARRIBA_DERECHA");
		System.out.println("DERECHA_ARRIBA");
		System.out.println("DERECHA_ABAJO");
		System.out.println("ABAJO_DERECHA");
		System.out.println("ABAJO_IZQUIERDA");
		System.out.println("IZQUIERDA_ARRIBA");
		System.out.println("IZQUIERDA_ABAJO");
	}
	private static Direccion elegirDireccion() {
		String cadenaDireccion;
		Direccion direccion;
		cadenaDireccion = Entrada.cadena();
		if (cadenaDireccion == "ARRIBA_IZQUIERDA") {
			direccion = Direccion.ARRIBA_IZQUIERDA;
		} else if (cadenaDireccion == "ARRIBA_DERECHA") {
			direccion = Direccion.ARRIBA_DERECHA;
		} else if (cadenaDireccion == "DERECHA_ARRIBA") {
			direccion = Direccion.DERECHA_ARRIBA;
		} else if (cadenaDireccion == "DERECHA_ABAJO") {
			direccion = Direccion.DERECHA_ABAJO;
		} else if (cadenaDireccion == "ABAJO_DERECHA") {
			direccion = Direccion.ABAJO_DERECHA;
		} else if (cadenaDireccion == "ABAJO_IZQUIERDA") {
			direccion = Direccion.ABAJO_IZQUIERDA;
		} else if (cadenaDireccion == "IZQUIERDA_ARRIBA") {
			direccion = Direccion.IZQUIERDA_ARRIBA;
		} else if (cadenaDireccion == "IZQUIERDA_ABAJO") {
			direccion = Direccion.IZQUIERDA_ABAJO;
		} else {
			direccion = null;
		}
			return direccion;
	}
}