package com.taekwondo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamenDTO {
	
	private Integer id;
	
	private String nombre;
	
	private String tipo;
	
	@JsonProperty("fecha_hora")
	private LocalDateTime fechaHora;
	
	private Double costo;
	
	@JsonProperty("enlace")
	private String enlaceFacebook;
	
	@JsonProperty("solicitud")
	private String solicitudExamen;

	public ExamenDTO(Integer id, String nombre, String tipo, LocalDateTime fechaHora, Double costo, String enlaceFacebook,
			String solicitudExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaHora = fechaHora;
		this.costo = costo;
		this.enlaceFacebook = enlaceFacebook;
		this.solicitudExamen = solicitudExamen;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
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

	public String getSolicitudExamen() {
		return solicitudExamen;
	}

	public void setSolicitudExamen(String solicitudExamen) {
		this.solicitudExamen = solicitudExamen;
	}

	@Override
	public String toString() {
		return "ExamenDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaHora=" + fechaHora + ", costo="
				+ costo + ", enlaceFacebook=" + enlaceFacebook + ", solicitudExamen=" + solicitudExamen + "]";
	}
}
