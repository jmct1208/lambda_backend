package com.taekwondo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "usuario")
	private Integer usuario;
	
	@Size(min=2, message="El nombre de la persona debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="Los apellidos de la persona deben tener al menos 2 letras")
	private String apellidos;
	
	@Past
	@JsonProperty("fecha")
	private Date fecha;
	
	private String fotografia;
	
	@JsonProperty("actividad")
	@Column(name = "actividad")
	private String actividad;
	
	@JsonProperty("seguro")
	private String seguro;

	@JsonProperty("grado")
	@Column(name = "grado")
	private String grado;

	@JsonProperty("certificado")
	private String certificado;
	
	@JsonProperty("carta")
	private String carta;
	
	@ManyToMany(mappedBy = "alumnosParticipantes")
	private Set<Examen> examenesParticipados;
	
	public Alumno() {
		
	}

	public Alumno(Integer id, Integer usuario,
			String nombre,
			String apellidos,
			Date fecha, String fotografia, String actividad, String seguro,
			String grado, String certificado, String carta) {
		super();
		this.id = id;
		this.usuario = usuario;
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

	public Integer getIdUsuario() {
		return usuario;
	}

	public void setIdUsuario(Integer usuario) {
		this.usuario = usuario;
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

	public String getCartaResponsiva() {
		return carta;
	}

	public void setCartaResponsiva(String carta) {
		this.carta = carta;
	}

	public Set<Examen> getExamenesParticipados() {
		return examenesParticipados;
	}

	public void setExamenesParticipados(Set<Examen> examenesParticipados) {
		this.examenesParticipados = examenesParticipados;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fecha=" + fecha + ", fotografía=" + fotografia + ", actividad="
				+ actividad + ", seguro=" + seguro + ", grado="
				+ grado + ", certificado=" + certificado + ", carta="
				+ carta + "]";
	}
}
	