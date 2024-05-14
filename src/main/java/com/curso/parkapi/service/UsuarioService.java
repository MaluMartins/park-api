package com.curso.parkapi.service;

import org.springframework.stereotype.Service;

import com.curso.parkapi.entities.Usuario;
import com.curso.parkapi.repositories.UsuarioRepository;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
					() -> new RuntimeException("Usuário não encontrado")
				);
	}

	@Transactional
	public Usuario editarSenha(Long id, String password) {
		Usuario user = buscarPorId(id);
		user.setPassword(password);
		return user;
	}

	@Transactional
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
}
