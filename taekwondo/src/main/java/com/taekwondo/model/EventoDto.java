package com.taekwondo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventoDto {
	
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	@JsonProperty("fecha")
	private LocalDate fechaInicio;
	
	@JsonProperty("fechaf")
	private LocalDate fechaFin;
	
	private Double costo;
		
	@JsonProperty("enlace")
	private String enlaceFacebook;
	
	@JsonProperty("tipo")
	private TipoEvento tipoEvento;

	public EventoDto(Integer id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			Double costo, String enlaceFacebook) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo = costo;
		this.enlaceFacebook = enlaceFacebook;
	}
	
	public EventoDto(Integer id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			Double costo, String enlaceFacebook, Integer idTipo, String nombreTipo, String descripcionTipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo = costo;
		this.enlaceFacebook = enlaceFacebook;
		this.tipoEvento = new TipoEvento(idTipo, nombreTipo, descripcionTipo);
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getEnlaceFacebook() {
		return enlaceFacebook;
	}

	public void setEnlaceFacebook(String enlaceFacebook) {
		this.enlaceFacebook = enlaceFacebook;
	}
	
	@Override
	public String toString() {
		return "EventoDto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + ", enlaceFacebook=" + enlaceFacebook
				+ "]";
	}
}
