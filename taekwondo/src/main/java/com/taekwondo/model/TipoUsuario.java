package com.taekwondo.model;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




 
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {
	
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@JsonProperty("nombre")
	@Column(name="nombre_tipo_usuario")
	private String nombre;
	
	@JsonProperty("descripcion")
	@Column(name="descripcion")
	private String descripcion;
	public TipoUsuario() {}
	public TipoUsuario(int id, String nombre,String descripcion) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_tipo_usuario() {
		return nombre;
	}

	public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
		this.nombre = nombre_tipo_usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
