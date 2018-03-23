//definici�n package
package com.ipartek.formacion.nidea.pojo;

//import (ahora mismo no tenemos ninguno)

//definici�n Clase
public class Mesa {

	// precio en �
	public static final int PRECIO_PATA = 1;
	public static final int PRECIO_M2 = 5;
	public static final int PRECIO_MATERIAL_MADERA = 4;
	public static final int PRECIO_MATERIAL_ACERO = 6;
	public static final int PRECIO_MATERIAL_ALUMINIO = 5;
	public static final int PRECIO_MATERIAL_PLASTICO = 2;
	public static final int PRECIO_COLOR_CUSTOM = 23;

	public static String PRECIO_COLOR_NAME_CUSTOM = "custom";

	// tipo material
	public static final int MATERIAL_MADERA = 1;
	public static final int MATERIAL_ACERO = 2;
	public static final int MATERIAL_ALUMINIO = 3;
	public static final int MATERIAL_PLASTICO = 4;

	// atributos
	// siempre privados para mantener la encapsulaci�n
	private int numeroPatas;
	private int dimension;// m2
	private String color;
	private int material;
	private boolean custom;

	private int total;

	/*
	 * 5. M�todos 5.1 Constructores 5.2 Getters y Setters 5.3 Otros
	 */

	/**
	 * sirve para documenta JavaDoc
	 * 
	 * @author para firmar
	 * @param numeroPatas
	 *            int en caso de ser negativo se inicializa con 0
	 */

	/*
	 * public Mesa() { super();
	 * 
	 * this.setNumeroPatas(numeroPatas); }
	 */

	public Mesa() {
		super();
		this.numeroPatas = 4;
		this.color = "blanco";
		this.material = MATERIAL_MADERA;
		this.dimension = 1;
	}

	// constructor con un parametro mas, primero llamas al constructor
	// padre(constructor por defecto) this
	public Mesa(int material) {
		this();
		this.material = material;
	}

	// sobrecargar, para que llame al que sobrecargas tienes que pasarle el
	// parametro
	public Mesa(int material, int dimesion) {
		this(material);
		this.material = material;
	}
	/* getters y setters */

	@Override
	public String toString() {
		return "Mesa [numeroPatas=" + numeroPatas + ", dimension=" + dimension + ", color=" + color + ", material="
				+ material + ", total=" + total + "]";
	}

	public int getNumeroPatas() {
		return numeroPatas;
	}

	/**
	 * if numero de patas es menos que cero, me devuelves un cero, else las patas q
	 * me pases, para que nunca pueda ser negativa la cantidad
	 * 
	 * @param numeroPatas
	 */
	public void setNumeroPatas(int numeroPatas) {

		this.numeroPatas = (numeroPatas <= 0) ? 1 : numeroPatas;
	}

	/**
	 * Calculamos el precio de la mesa en funcion de los materiales usados
	 * 
	 * @see consultar todas las constantes definidas para los precios
	 * @return int precio en �
	 */

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public int getPrecio() {
		int result = 0;

		result = (this.numeroPatas * this.PRECIO_PATA) + (this.dimension * this.PRECIO_M2);

		switch (this.material) {

		case MATERIAL_MADERA:
			result = result + PRECIO_MATERIAL_MADERA;
			break;

		case MATERIAL_ACERO:
			result = result + PRECIO_MATERIAL_ACERO;
			break;

		case MATERIAL_ALUMINIO:
			result = result + PRECIO_MATERIAL_ALUMINIO;
			break;

		default:
			result = result + PRECIO_MATERIAL_PLASTICO;
			break;

		}

		if (PRECIO_COLOR_NAME_CUSTOM.equalsIgnoreCase(this.color)) {
			result += PRECIO_COLOR_CUSTOM;
		}

		return result;

	}

	public void setTotal(int total) {
		this.total = total;
	}

}
