package com.taekwondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
       
	Usuario findByid(int id);
	
	//@Query(value = "SELECT u FROM USUARIO u LEFT JOIN FETCH u.tipoUsuario WHERE u.id = :id AND u.nombre=nombre")
	Usuario findByNombre(String nombre);
	
}
