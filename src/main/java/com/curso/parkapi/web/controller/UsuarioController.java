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
import com.curso.parkapi.web.dto.UsuarioSenhaDto;
import com.curso.parkapi.web.dto.mapper.UsuarioMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Tag(name = "Usuarios", description = "Contém todas as operações relativas aos recursos para cadastro, edição e leitura de um usuário")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto) {
		Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
		Usuario user = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok(UsuarioMapper.toDto(user));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
		Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDto>> getAll() {
		List<Usuario> users = usuarioService.buscarTodos();
		
		return ResponseEntity.ok(UsuarioMapper.toListDto(users));
	}
}
