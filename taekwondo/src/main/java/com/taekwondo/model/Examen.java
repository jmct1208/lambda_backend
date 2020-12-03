package com.taekwondo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, message = "El nombre debe tener al menos dos carácteres")
	private String nombre;
	
	@NotBlank
	@JsonProperty("tipo")
	private String tipo;
	
	@Future
	@JsonProperty("fecha")
	@Column(name = "fecha")
	private Date fecha;
	
	@PositiveOrZero
	@JsonProperty("costo")
	private Double costo;
	
	@NotBlank
	@JsonProperty("enlace")
	@Column(name = "enlace")
	private String enlace;
	
	@NotBlank
	@JsonProperty("solicitud")
	@Column(name = "solicitud")
	private String solicitud;
	
	@ManyToMany()
	@JoinTable(
			name = "alumno_has_examen",
			joinColumns = @JoinColumn(name = "examen_id"),
			inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private Set<Alumno> alumnosParticipantes;
	
	public Examen(Integer id, @Size(min = 2, message = "El nombre debe tener al menos dos carácteres") String nombre,
			@NotBlank String tipo, @Future Date fecha, @PositiveOrZero Double costo,
			@NotBlank String enlace, @NotBlank String solicitud) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.costo = costo;
		this.enlace = enlace;
		this.solicitud = solicitud;
	}

	public Examen() {
		
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

	public Set<Alumno> getAlumnosParticipantes() {
		return alumnosParticipantes;
	}

	public void setAlumnosParticipantes(Set<Alumno> alumnosParticipantes) {
		this.alumnosParticipantes = alumnosParticipantes;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	@Override
	public String toString() {
		return "Examen [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fecha=" + fecha + ", costo="
				+ costo + ", enlace=" + enlace + ", solicitud=" + solicitud + "]";
	}
	
}
