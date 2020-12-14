package com.taekwondo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventoDto {
	
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	@JsonProperty("fecha_inicio")
	private LocalDate fechaInicio;
	
	@JsonProperty("fecha_fin")
	private LocalDate fechaFin;
	
	private Double costo;
		
	@JsonProperty("enlace_facebook")
	private String enlaceFacebook;
	
	@JsonProperty("tipo_evento")
	private TipoEvento tipoEvento;

	public EventoDto(Integer id, String nombre,
			String descripcion,
			LocalDate fechaInicio, LocalDate fechaFin, Double costo,
			String enlaceFacebook) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo = costo;
		this.enlaceFacebook = enlaceFacebook;
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
	
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String toString() {
		return "EventoDto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + ", enlaceFacebook=" + enlaceFacebook
				+ "]";
	}
}
