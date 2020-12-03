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
	private Date fecha;
	
	@PositiveOrZero
	private Double costo;
	
	@NotBlank
	@Column(name = "enlace")
	private String enlace;
	
	@NotBlank
	@Column(name = "solicitud")
	private String solicitud;
	
	private List<AlumnoDTO> alumnosParticipantes;
	
	public ExamenDTO(Integer id, String nombre,
			String tipo, Date fecha, Double costo,
			String enlace, String solicitud) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.costo = costo;
		this.enlace = enlace;
		this.solicitud = solicitud;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public List<AlumnoDTO> getAlumnosParticipantes() {
		return alumnosParticipantes;
	}

	public void setAlumnosParticipantes(List<AlumnoDTO> alumnosParticipantes) {
		this.alumnosParticipantes = alumnosParticipantes;
	}

	@Override
	public String toString() {
		return "ExamenDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fecha=" + fecha + ", costo="
				+ costo + ", enlace=" + enlace + ", solicitud=" + solicitud + "]";
	}
	
}
