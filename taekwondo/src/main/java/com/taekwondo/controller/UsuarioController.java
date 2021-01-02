package com.taekwondo.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;
import com.taekwondo.model.Usuario;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.EventoService;
import com.taekwondo.service.ExamenService;
import com.taekwondo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uSrv;

	@Autowired
	private AlumnoService aSrv;
	
	@Autowired
	private ExamenService eSrv;
	
	@Autowired
	private EventoService eVSrv;
	
	@GetMapping("")
	public ResponseEntity<Object> getUsuarios(){
		return new ResponseEntity<Object>(this.uSrv.getUsuarios(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}/alumno")
	public ResponseEntity<Object> getAlumnoUsuario(@PathVariable int id) {
		return new ResponseEntity<Object>(this.aSrv.getAlumnoDtoUsuario(id), 
				HttpStatus.OK);
	}
	
	@GetMapping("/logged_in")
	public ResponseEntity<Object> getUsuarioLogueado() {
		Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
			}
		return new ResponseEntity<Object>(this.uSrv.obtenerPorNombre(username),
				HttpStatus.OK);
	}
	
	@GetMapping("/logged_in/alumno")
	public ResponseEntity<Object> getAlumnoLogueado() {
		int idUsuario =  ((Usuario) this.getUsuarioLogueado().getBody())
				.getId();
		return new ResponseEntity<Object>(this.aSrv.getAlumnoDtoUsuario(idUsuario),
				HttpStatus.OK);
	}
	
	@GetMapping("/logged_in/alumno/examenes")
	public ResponseEntity<Object> getExamenesAlumnoLogueado() {
		int idAlumno = ((AlumnoDTO) this.getAlumnoLogueado().getBody()).getId();
		return new ResponseEntity<Object>(eSrv.getExamenesAlumno(idAlumno),
				HttpStatus.OK);
	}
	
	@GetMapping("/logged_in/alumno/eventos")
	public ResponseEntity<Object> getEventosAlumnoLogueado() {
		int idAlumno = ((AlumnoDTO) this.getAlumnoLogueado().getBody()).getId();
		return new ResponseEntity<Object>(eVSrv.getEventosAlumno(idAlumno),
				HttpStatus.OK);
	}
	
	@PostMapping("/{id_usuario}/alumno")
	public ResponseEntity<Object> createAlumno(@Valid @RequestBody 
			Alumno alumno, @PathVariable("id_usuario") int idUsuario) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.aSrv.createAlumno(alumno, idUsuario);
		response.put("status", "success");
		response.put("message", "Alumno creado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_usuario}/{id_rol}")
	public ResponseEntity<Object> updateUsuario(
			@Valid @RequestBody Usuario usuario,
			@PathVariable("id_usuario") int idUsuario,
			@PathVariable("id_rol") int idRol) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.uSrv.updateUsuario(usuario, idUsuario, idRol);
		response.put("status", "success");
		response.put("message", "Usuario actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(int id) {
		this.uSrv.deleteUsuario(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Usuario eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping("/pornombre/{nombre}")
	public ResponseEntity<Object> obtenerPorNombre(@PathVariable("nombre")String nombre) {
		return new ResponseEntity<Object>(this.uSrv.obtenerPorNombre(nombre), HttpStatus.OK);
		
	}
}
