package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Column;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_usuario")
	@JsonProperty("nombre")
	String nombre;
	
	@JsonProperty("tipo")
	@ManyToOne(optional=true,fetch = FetchType.EAGER )
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_usuario"), name="tipo_usuario",referencedColumnName="id" ,nullable=false)
	private TipoUsuario tipoUsuario;
	
	String password;
	
	public Usuario() {
		
		
	}

	public Usuario(Integer id, String nombre, String password, 
			TipoUsuario tipoUsuario) {
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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}
}
