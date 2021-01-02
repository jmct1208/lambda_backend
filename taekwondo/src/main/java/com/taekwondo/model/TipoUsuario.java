package com.taekwondo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {
	
	@Override
	public String toString() {
		return "TipoUsuario [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="nombre_tipo_usuario")
	private String nombre;
	
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

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
