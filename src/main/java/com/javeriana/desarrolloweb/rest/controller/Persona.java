package com.javeriana.desarrolloweb.rest.controller;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	String nombre;
	String tipo;
	String numero;
	List<Pelicula> favoritas = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Pelicula> getFavoritas() {
		return favoritas;
	}

	public void setFavoritas(List<Pelicula> favoritas) {
		this.favoritas = favoritas;
	}
	
	public void addPelicula (Pelicula pelicula) {
		getFavoritas().add(pelicula);
	}
}

class Pelicula {
	String nombre;
	int anio;
	String genero;

	public Pelicula() {
		super();
	}
	
	public Pelicula(String nombre, int anio, String genero) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.genero = genero;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
