package com.taekwondo.model;

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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonProperty("id_usuario")
	@Column(name = "usuario_id")
	private Integer idUsuario;
	
	@Size(min=2, message="El nombre de la persona debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="Los apellidos de la persona deben tener al menos 2 letras")
	private String apellidos;
	
	@JsonProperty("fecha_nacimiento")
	@Past
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	private String fotografia;
	
	@JsonProperty("actividad_marcial")
	@Column(name = "actividad_marcial")
	private String actividadMarcial;
	
	@JsonProperty("seguro_medico")
	@Column(name = "seguro_medico")
	private String seguroMedico;
	
	@JsonProperty("grado_actividad_marcial")
	@Column(name = "grado_actividad_marcial")
	private String gradoActividadMarcial;
	
	@JsonProperty("certificado_medico")
	@Column(name = "certificado_medico")
	private String certificadoMedico;
	
	@JsonProperty("carta_responsiva")
	@Column(name = "carta_responsiva")
	private String cartaResponsiva;
	
	@ManyToMany(mappedBy = "alumnosParticipantes")
	private Set<Examen> examenesParticipados;
	
	public Alumno() {
		
	}

	public Alumno(Integer id, Integer idUsuario,
			String nombre,
			String apellidos,
			Date fechaNacimiento, String fotografia, String actividadMarcial, String seguroMedico,
			String gradoActividadMarcial, String certificadoMedico, String cartaResponsiva) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public Set<Examen> getExamenesParticipados() {
		return examenesParticipados;
	}

	public void setExamenesParticipados(Set<Examen> examenesParticipados) {
		this.examenesParticipados = examenesParticipados;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + ", fotografía=" + fotografia + ", actividadMarcial="
				+ actividadMarcial + ", seguroMedico=" + seguroMedico + ", gradoActividadMarcial="
				+ gradoActividadMarcial + ", certificadoMedico=" + certificadoMedico + ", cartaResponsiva="
				+ cartaResponsiva + "]";
	}
}
	