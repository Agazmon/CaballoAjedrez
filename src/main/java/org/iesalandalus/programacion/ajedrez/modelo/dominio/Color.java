package org.iesalandalus.programacion.ajedrez.modelo.dominio;

public enum Color {
	BLANCO("Blanco"), NEGRO("Negro");
	private String cadenaColor;

	private Color(String cadenaColor) {
		this.cadenaColor = cadenaColor;
	}

	public String toString() {
		return "Color=["+cadenaColor+"]";
	}
}
