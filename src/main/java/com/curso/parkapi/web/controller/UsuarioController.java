package com.curso.parkapi.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.parkapi.entities.Usuario;
import com.curso.parkapi.repositories.UsuarioRepository;
import com.curso.parkapi.service.UsuarioService;
import com.curso.parkapi.web.dto.UsuarioCreateDto;
import com.curso.parkapi.web.dto.UsuarioResponseDto;
import com.curso.parkapi.web.dto.mapper.UsuarioMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto) {
		Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		Usuario user = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> users = usuarioService.buscarTodos();
		
		return ResponseEntity.ok(users);
	}
}
