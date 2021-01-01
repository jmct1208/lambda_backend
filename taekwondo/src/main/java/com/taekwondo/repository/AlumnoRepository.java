package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;
import com.taekwondo.model.Usuario;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre," +
			"a.apellidos, a.fechaNacimiento, a.fotografia, "  +
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " + 
			"a.certificadoMedico, a.cartaResponsiva) FROM Alumno a")
	List<AlumnoDTO> findAllDto();
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " +
			"a.apellidos, a.fechaNacimiento, a.fotografia, " + 
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " +
			"a.certificadoMedico, a.cartaResponsiva)" + 
			"FROM Alumno a WHERE a.id=?1")
	AlumnoDTO findById(int id);
	
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " +
			"a.apellidos, a.fechaNacimiento, a.fotografia, " + 
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " +
			"a.certificadoMedico, a.cartaResponsiva)" + 
			"FROM Alumno a JOIN a.usuario u WHERE u.id=?1")
	AlumnoDTO findByUsuario(int id);
		
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " + 
			"a.apellidos, a.fechaNacimiento, a.fotografia, " + 
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " + 
			"a.certificadoMedico, a.cartaResponsiva) " + 
			"From Alumno a INNER JOIN a.examenesParticipados e WHERE e.id=?1")
	List<AlumnoDTO> findByExamenId(int id);
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " + 
			"a.apellidos, a.fechaNacimiento, a.fotografia, " + 
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " + 
			"a.certificadoMedico, a.cartaResponsiva) " +
			"FROM Alumno a WHERE a.id NOT IN (" +
			"SELECT a1.id FROM Alumno a1 INNER JOIN " +
			"a1.examenesParticipados e WHERE e.id=?1)")
	List<AlumnoDTO> findByExamenNotId(int id);
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " + 
			"a.apellidos, a.fechaNacimiento, a.fotografia, " +
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " + 
			"a.certificadoMedico, a.cartaResponsiva) " +
			"From Alumno a INNER JOIN a.eventosParticipados e WHERE e.id=?1")
	List<AlumnoDTO> findByEventoId(int id);

	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " + 
			"a.apellidos, a.fechaNacimiento, a.fotografia, " + 
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " + 
			"a.certificadoMedico, a.cartaResponsiva) " +
			"FROM Alumno a WHERE a.id NOT IN (" +
			"SELECT a1.id FROM Alumno a1 INNER JOIN " +
			"a1.eventosParticipados e WHERE e.id=?1)")
	List<AlumnoDTO> findByEventoNotId(int id);
	
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.tipoUsuario t_u "
			+ "WHERE u.id NOT IN "
			+ "(SELECT e.id FROM Alumno e INNER JOIN e.usuario)"
			+ "AND t_u.nombre = 'ALUMNO'")
	List<Usuario> alumnosSinUsuario();
	//select u.id FROM Usuario u
	//"select new com.taekwondo.model.AlumnoDTO(a.id, a.nombre,a.apellidos, a.fechaNacimiento, a.fotografia,a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial,a.certificadoMedico, a.cartaResponsiva) FROM Alumno a INNER JOIN a.usuario e"

	/*@Query(value="SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, " + 
			"a.apellidos, a.fechaNacimiento, a.fotografia, " + 
			"a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, " + 
			"a.certificadoMedico, a.cartaResponsiva) " +
			"FROM Alumno a JOIN ((SELECT a1.usuario FROM Alumno a1) NOT IN (" +
			"SELECT a1.usuario FROM Alumno a1 INNER JOIN " +
			"Usuario e WHERE a1.usuario=e.nombre))"
			,nativeQuery = true)**/

	
	//SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre,a.apellidos, a.fechaNacimiento, a.fotografia,	a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial) FROM ALUMNO a  JOIN ((SELECT p.usuario FROM ALUMNO p) NOT IN (SELECT a1.usuario FROM ALUMNO a1 INNER JOIN USUARIO e WHERE a1.usuario=e.nombre)) a2
	////"SELECT a1.usuario FROM ALUMNO a1 INNER JOIN USUARIO e WHERE a1.usuario=e.nombre)) " +
	//"a2
	//	@Query(value="select new com.taekwondo.model.AlumnoDTO(a.id, a.nombre,a.apellidos, a.fechaNacimiento, a.fotografia,	a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial)  from alumno as a natural join ((select usuario from alumno) except (select usuario from alumno inner join usuario on alumno.usuario=usuario.nombre_usuario)) as e"

	//select * from alumno as a natural join ((select usuario from alumno) except (select usuario from alumno inner join usuario on alumno.usuario=usuario.nombre_usuario)) as e
}
