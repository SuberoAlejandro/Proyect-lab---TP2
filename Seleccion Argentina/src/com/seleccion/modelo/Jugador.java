package com.seleccion.modelo;

public class Jugador extends Persona {

	private int edad;
	private double peso;
	private double altura;
	private String posicion;
	private int calificasion;
	private int id;

	public Jugador(String nombre, String apellido, int edad, double peso, double altura, String posicion) {

		super(nombre, apellido);
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.posicion = posicion;

	}

	public Jugador(String nombre, String apellido, int edad, double peso, double altura, String posicion,
			int calificasion) {

		super(nombre, apellido);
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.posicion = posicion;
		this.calificasion = calificasion;
	}

	public Jugador(String nombre, String apellido, int edad, double peso, double altura, String posicion,
			int calificasion, int id) {

		super(nombre, apellido);
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.posicion = posicion;
		this.calificasion = calificasion;
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getCalificasion() {
		return calificasion;
	}

	public void setCalificasion(int calificasion) {
		this.calificasion = calificasion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
