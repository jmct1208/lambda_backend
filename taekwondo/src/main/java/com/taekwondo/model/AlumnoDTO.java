package com.taekwondo.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlumnoDTO {
	
	private Integer id;
		
	@Size(min=2, message="El nombre de la persona debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="Los apellidos de la persona deben tener al menos 2 letras")
	private String apellidos;
	
	@Past
	private Date fechaNacimiento;
	
	@NotBlank
	private String fotografia;
	
	@NotBlank
	private String actividadMarcial;
	
	@NotBlank
	private String seguroMedico;
	
	@NotBlank
	private String gradoActividadMarcial;
	
	@NotBlank
	private String certificadoMedico;
	
	@NotBlank
	private String cartaResponsiva;
	
	private List<ExamenDTO> examenesParticipados;

	public AlumnoDTO(Integer id,
			String nombre,
			String apellidos,
			Date fechaNacimiento, String fotografia, String actividadMarcial,
			String seguroMedico,  String gradoActividadMarcial, String certificadoMedico,
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
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

	public List<ExamenDTO> getExamenesParticipados() {
		return examenesParticipados;
	}

	public void setExamenesParticipados(List<ExamenDTO> examenesParticipados) {
		this.examenesParticipados = examenesParticipados;
	}

	@Override
	public String toString() {
		return "AlumnoDTO [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", fotografia=" + fotografia + ", actividadMarcial=" + actividadMarcial
				+ ", seguroMedico=" + seguroMedico + ", gradoActividadMarcial=" + gradoActividadMarcial
				+ ", certificadoMedico=" + certificadoMedico + ", cartaResponsiva=" + cartaResponsiva + "]";
	}
	
}
