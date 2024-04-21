package com.curso.parkapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.parkapi.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
