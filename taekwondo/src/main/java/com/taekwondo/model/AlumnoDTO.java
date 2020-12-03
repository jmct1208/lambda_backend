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
	private Date fecha;
	
	@NotBlank
	private String fotografia;
	
	@NotBlank
	private String actividad;
	
	@NotBlank
	private String seguro;
	
	@NotBlank
	private String grado;
	
	@NotBlank
	private String certificado;
	
	@NotBlank
	private String carta;
	
	private List<ExamenDTO> examenesParticipados;

	public AlumnoDTO(Integer id,
			String nombre,
			String apellidos,
			Date fecha, String fotografia, String actividad,
			String seguro,  String grado, String certificado,
			String carta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.fotografia = fotografia;
		this.actividad = actividad;
		this.seguro = seguro;
		this.grado = grado;
		this.certificado = certificado;
		this.carta = carta;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getActividadMarcial() {
		return actividad;
	}

	public void setActividadMarcial(String actividad) {
		this.actividad = actividad;
	}

	public String getSeguroMedico() {
		return seguro;
	}

	public void setSeguroMedico(String seguro) {
		this.seguro = seguro;
	}

	public String getGradoActividadMarcial() {
		return grado;
	}

	public void setGradoActividadMarcial(String grado) {
		this.grado = grado;
	}

	public String getCertificadoMedico() {
		return certificado;
	}

	public void setCertificadoMedico(String certificado) {
		this.certificado = certificado;
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public List<ExamenDTO> getExamenesParticipados() {
		return examenesParticipados;
	}

	public void setExamenesParticipados(List<ExamenDTO> examenesParticipados) {
		this.examenesParticipados = examenesParticipados;
	}

	@Override
	public String toString() {
		return "AlumnoDTO [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha="
				+ fecha + ", fotografia=" + fotografia + ", actividad=" + actividad
				+ ", seguro=" + seguro + ", grado=" + grado
				+ ", certificado=" + certificado + ", carta=" + carta + "]";
	}
	
}
