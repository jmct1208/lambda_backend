package com.taekwondo.model;


public class AutenticacionBody {
	
	private String nombre;
	private String password;
	
	public String getNombre() {
		return nombre;
	}
	public void setEmail(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AutenticacionBody [nombre=" + nombre + ", password=" + password + "]";
	}
}
