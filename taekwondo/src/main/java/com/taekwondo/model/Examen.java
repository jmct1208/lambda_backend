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

@Entity
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, message = "El nombre debe tener al menos dos carácteres")
	private String nombre;
	
	@NotBlank
	private String tipo;
	
	@Future
	@Column(name = "fecha_hora")
	private Date fechaHora;
	
	@PositiveOrZero
	private Double costo;
	
	@NotBlank
	@Column(name = "enlace_facebook")
	private String enlaceFacebook;
	
	@NotBlank
	@Column(name = "solicitud_examen")
	private String solicitudExamen;
	
	@ManyToMany()
	@JoinTable(
			name = "alumno_has_examen",
			joinColumns = @JoinColumn(name = "examen_id"),
			inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private Set<Alumno> alumnosParticipantes;
	
	public Examen(Integer id, @Size(min = 2, message = "El nombre debe tener al menos dos carácteres") String nombre,
			@NotBlank String tipo, @Future Date fechaHora, @PositiveOrZero Double costo,
			@NotBlank String enlaceFacebook, @NotBlank String solicitudExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaHora = fechaHora;
		this.costo = costo;
		this.enlaceFacebook = enlaceFacebook;
		this.solicitudExamen = solicitudExamen;
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

	public Set<Alumno> getAlumnosParticipantes() {
		return alumnosParticipantes;
	}

	public void setAlumnosParticipantes(Set<Alumno> alumnosParticipantes) {
		this.alumnosParticipantes = alumnosParticipantes;
	}

	public void setSolicitudExamen(String solicitudExamen) {
		this.solicitudExamen = solicitudExamen;
	}

	@Override
	public String toString() {
		return "Examen [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaHora=" + fechaHora + ", costo="
				+ costo + ", enlaceFacebook=" + enlaceFacebook + ", solicitudExamen=" + solicitudExamen + "]";
	}
	
}
