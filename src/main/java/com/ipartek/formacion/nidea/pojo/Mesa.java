//1.definicion package
package com.ipartek.formacion.nidea.pojo;

//2. Imports => ahora mismo no tenemos ninguno

//3. definicion Clase
/**
 * 
 * @author ur00
 *
 */
public class Mesa implements Cloneable {

	/**
	 * precio en €
	 */
	public static final int PRECIO_PATA = 1;
	public static final int PRECIO_M2 = 5;
	public static final int PRECIO_COLOR_CUSTOM = 23;
	public static final String COLOR_POR_DEFECTO = "#FFF";

	// 4. Atributos siempre PRIVATE para mantener la encapsulacion
	private int numeroPatas;
	private int dimension; // metros cuadrados
	private String color;
	private boolean custom;
	private Material material;

	public Mesa() {

		// llamar siempre a super
		super();

		// inicializar los atributos
		this.numeroPatas = 4;
		this.dimension = 1;
		this.color = COLOR_POR_DEFECTO; // blanco
		this.custom = false;
		this.material = new Material();
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public static int getPrecioPata() {
		return PRECIO_PATA;
	}

	public static int getPrecioM2() {
		return PRECIO_M2;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Mesa(int dimension) {
		this.dimension = dimension;
	}

	public int getNumeroPatas() {
		return numeroPatas;
	}

	/**
	 * Si numeroPatas < 0 asignamos valor 1, else numeroPatas
	 * 
	 * @param numeroPatas
	 *            int
	 * @throws MesaException
	 */
	public void setNumeroPatas(int numeroPatas) throws MesaException {
		if (numeroPatas <= 0) {
			throw new MesaException(MesaException.MENSAJE_PATAS);
		}

		this.numeroPatas = numeroPatas;
	}

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

	public Material getMaterial() {
		return this.material;
	}

	@Override
	public String toString() {
		return "Mesa [numeroPatas=" + numeroPatas + ", dimension=" + dimension + ", color=" + color + ", material="
				+ material + "]";
	}

	/**
	 * Calculamos el precio de la mesa en funcion de los materiales usados.
	 * 
	 * @see consultar todas las constantes definidas para los precios
	 * @return int precio en €
	 */
	public int getPrecio() {

		int resul = 0;

		resul += this.numeroPatas * PRECIO_PATA;
		resul += this.dimension * PRECIO_M2;

		if (!COLOR_POR_DEFECTO.equalsIgnoreCase(this.color)) {
			resul += PRECIO_COLOR_CUSTOM;
		}

		resul += material.getPrecio();

		return resul;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + dimension;
		result = prime * result + numeroPatas;
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
		Mesa other = (Mesa) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dimension != other.dimension)
			return false;
		if (material != other.material)
			return false;
		if (numeroPatas != other.numeroPatas)
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}