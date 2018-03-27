package com.ipartek.formacion.nidea.pojo;

public class Material {

	public static final String[] NOMBRES = { "madera", "acero", "aluminio", "plastico" };
	public static final int[] PRECIOS = { 4, 6, 5, 2 };
	public static final int[] IDS = { 1, 2, 3, 4 };

	private int id;
	private String nombre;
	private int precio;

	public Material() {
		super();
		this.id = IDS[0];
		this.nombre = NOMBRES[0];
		this.precio = PRECIOS[0];
	}

	public Material(int id) {
		this();
		this.id = id;

		int index = 0;
		for (int i = 0; i < IDS.length; i++) {
			if (id == IDS[i]) {
				index = i;
				break;
			}
		}

		this.nombre = NOMBRES[index];
		this.precio = PRECIOS[index];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
