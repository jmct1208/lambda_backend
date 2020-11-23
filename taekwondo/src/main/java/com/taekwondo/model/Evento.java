package com.taekwondo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo_evento_id")
	private Integer idTipoEvento;
	
	@Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
	private String nombre;
	
	@Size(min = 2, message = "La descripción debe tener al menos 4 caracteres")
	private String descripcion;
	
	@Future
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Future
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@PositiveOrZero
	private Double costo;
	
	@NotBlank
	@Column(name = "enlace_facebook")
	private String enlaceFacebook;
	
	@ManyToMany
	@JoinTable(
			name = "alumno_has_evento",
			joinColumns = @JoinColumn(name = "Evento_id"),
			inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private Set<Alumno> alumnosParticipantes;
	
	
	public Evento() {
		
	}

	public Evento(Integer id, Integer idTipoEvento,
			@Size(min = 2, message = "El nombre debe tener al menos dos caracteres") String nombre,
			@Size(min = 2, message = "La descripción debe tener al menos 4 caracteres") String descripcion,
			@Future Date fechaInicio, @Future Date fechaFin, @PositiveOrZero Double costo,
			@NotBlank String enlaceFacebook) {
		super();
		this.id = id;
		this.idTipoEvento = idTipoEvento;
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

	public Integer getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(Integer idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
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
	
	
}
