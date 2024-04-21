package com.curso.parkapi.service;

import org.springframework.stereotype.Service;

import com.curso.parkapi.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
}
