package com.ipartek.formacion.nidea.pojo;

public class MesaException extends Exception {

	private static final long serialVersion = 1l;// para que el compilador funcione más rapido

	public static final String MENSAJE_PATAS = "La mesa como mínimo, debe tener 1 pata";

	public MesaException(String mensajePatas) {
		super(mensajePatas);// el padre tiene un constructor al que se le puede pasar un mensaje
	}

}
