package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class TipoEvento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, message="El nombre del tipo de evento debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="La descripcion del tipo de evento debe tener al menos 4 letras")
	private String descripcion;
	
	
	public TipoEvento() {
		
	}

	public TipoEvento(Integer id,
			@Size(min = 2, message = "El nombre del tipo de evento debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "La descripcion del tipo de evento debe tener al menos 4 letras") String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoEvento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
