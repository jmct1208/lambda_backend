package com.taekwondo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamenDTO {
	
	private Integer id;
	
	@Size(min = 2, message = "El nombre debe tener al menos dos carácteres")
	private String nombre;
	
	@NotBlank
	private String tipo;
	
	@Future
	private Date fechaHora;
	
	@PositiveOrZero
	private Double costo;
	
	@NotBlank
	@Column(name = "enlace_facebook")
	private String enlaceFacebook;
	
	@NotBlank
	@Column(name = "solicitud_examen")
	private String solicitudExamen;
	
	private List<AlumnoDTO> alumnosParticipantes;
	
	public ExamenDTO(Integer id, String nombre,
			String tipo, Date fechaHora, Double costo,
			String enlaceFacebook, String solicitudExamen) {
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

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
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

	public List<AlumnoDTO> getAlumnosParticipantes() {
		return alumnosParticipantes;
	}

	public void setAlumnosParticipantes(List<AlumnoDTO> alumnosParticipantes) {
		this.alumnosParticipantes = alumnosParticipantes;
	}

	@Override
	public String toString() {
		return "ExamenDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaHora=" + fechaHora + ", costo="
				+ costo + ", enlaceFacebook=" + enlaceFacebook + ", solicitudExamen=" + solicitudExamen + "]";
	}
	
}
