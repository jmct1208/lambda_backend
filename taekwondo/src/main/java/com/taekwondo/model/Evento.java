package com.taekwondo.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
	private String nombre;
	
	@Size(min = 2, message = "La descripción debe tener al menos 4 caracteres")
	private String descripcion;
	
	@Future
	@Column(name = "fecha_inicio")
	@JsonProperty("fecha")
	private LocalDate fechaInicio;
	
	@Future
	@Column(name = "fecha_fin")
	@JsonProperty("fechaf")
	private LocalDate fechaFin;
	
	@PositiveOrZero
	private Double costo;
	
	@NotBlank
	@Column(name = "enlace_facebook")
	@JsonProperty("enlace")
	private String enlaceFacebook;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_evento_id")
	private TipoEvento tipoEvento;
	
	@ManyToMany
	@JoinTable(
			name = "alumno_has_evento",
			joinColumns = @JoinColumn(name = "Evento_id"),
			inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private Set<Alumno> alumnosParticipantesEvento;
	
	
	public Evento() {
		
	}

	public Evento(Integer id,
			@Size(min = 2, message = "El nombre debe tener al menos dos caracteres") String nombre,
			@Size(min = 2, message = "La descripción debe tener al menos 4 caracteres") String descripcion,
			@Future LocalDate fechaInicio, @Future LocalDate fechaFin, @PositiveOrZero Double costo,
			@NotBlank String enlaceFacebook) {
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

	public Set<Alumno> getAlumnosParticipantesEvento() {
		return alumnosParticipantesEvento;
	}

	public void setAlumnosParticipantesEvento(Set<Alumno> alumnosParticipantesEvento) {
		this.alumnosParticipantesEvento = alumnosParticipantesEvento;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + ", enlaceFacebook=" + enlaceFacebook
				+ ", tipoEvento=" + tipoEvento + "]";
	}
	
	
}
