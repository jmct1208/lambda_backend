package com.taekwondo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_usuario")
	String nombre;
	
	
	String password;
	
	@JsonProperty("tipo")
	@Column(name = "tipo_usuario")
	Boolean tipoUsuario;
	
	public Usuario() {
		
		
	}

	public Usuario(Integer id, String nombre, String password, Boolean tipoUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}
}