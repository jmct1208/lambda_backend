package com.taekwondo.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlumnoDTO {
	
	private Integer id;
		
	private String nombre;
	
	private String apellidos;
	
	@JsonProperty("fecha")
	private LocalDate fechaNacimiento;
	
	private String fotografia;
	
	@JsonProperty("actividad")
	private String actividadMarcial;
	
	@JsonProperty("seguro")
	private String seguroMedico;
	
	@JsonProperty("grado")
	private String gradoActividadMarcial;
	
	@JsonProperty("certificado")
	private String certificadoMedico;
	
	@JsonProperty("carta")
	private String cartaResponsiva;

	public AlumnoDTO(Integer id,
			String nombre,
			String apellidos,
			LocalDate fechaNacimiento, String fotografia, 
			String actividadMarcial, String seguroMedico,
			String gradoActividadMarcial, String certificadoMedico,
			String cartaResponsiva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.fotografia = fotografia;
		this.actividadMarcial = actividadMarcial;
		this.seguroMedico = seguroMedico;
		this.gradoActividadMarcial = gradoActividadMarcial;
		this.certificadoMedico = certificadoMedico;
		this.cartaResponsiva = cartaResponsiva;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getActividadMarcial() {
		return actividadMarcial;
	}

	public void setActividadMarcial(String actividadMarcial) {
		this.actividadMarcial = actividadMarcial;
	}

	public String getSeguroMedico() {
		return seguroMedico;
	}

	public void setSeguroMedico(String seguroMedico) {
		this.seguroMedico = seguroMedico;
	}

	public String getGradoActividadMarcial() {
		return gradoActividadMarcial;
	}

	public void setGradoActividadMarcial(String gradoActividadMarcial) {
		this.gradoActividadMarcial = gradoActividadMarcial;
	}

	public String getCertificadoMedico() {
		return certificadoMedico;
	}

	public void setCertificadoMedico(String certificadoMedico) {
		this.certificadoMedico = certificadoMedico;
	}

	public String getCartaResponsiva() {
		return cartaResponsiva;
	}

	public void setCartaResponsiva(String cartaResponsiva) {
		this.cartaResponsiva = cartaResponsiva;
	}


	@Override
	public String toString() {
		return "AlumnoDTO [id=" + id + ", nombre=" + nombre + ", apellidos=" +
				apellidos + ", fechaNacimiento=" + fechaNacimiento + 
				", fotografia=" + fotografia + ", actividadMarcial=" + 
				actividadMarcial + ", seguroMedico=" + seguroMedico + 
				", gradoActividadMarcial=" + gradoActividadMarcial + 
				", certificadoMedico=" + certificadoMedico + 
				", cartaResponsiva=" + cartaResponsiva + "]";
	}
	
}
