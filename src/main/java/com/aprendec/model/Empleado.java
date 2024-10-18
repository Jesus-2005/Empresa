package com.aprendec.model;

public class Empleado {
	public String nombre;
	public String dni;
	public char sexo;
	private int categoria;
	public int anyos;



public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}


public Empleado() {
	super();
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getDni() {
	return dni;
}


public void setDni(String dni) {
	this.dni = dni;
}


public char getSexo() {
	return sexo;
}


public void setSexo(char sexo) {
	this.sexo = sexo;
}


public int getAnyos() {
	return anyos;
}


public void setAnyos(int anyos) {
	this.anyos = anyos;
}


public void setCategoria(int categoria) {
	this.categoria = categoria;
}


/**
 * Este metodo retorna  categoria
 * @return
 */
	public int getCategoria() {
		return categoria;
	}

/**
 * Con este metodo imprimiremos los datos de empleado
 */
	public void imprime() {
		System.out.println("Nombre: " + nombre + "  DNI: " + dni + "  Categoria: " + categoria + "  Años: " + anyos);

	}
}
