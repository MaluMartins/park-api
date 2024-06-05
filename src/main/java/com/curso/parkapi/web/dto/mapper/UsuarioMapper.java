package com.curso.parkapi.web.dto.mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.curso.parkapi.entities.Usuario;
import com.curso.parkapi.web.dto.UsuarioCreateDto;
import com.curso.parkapi.web.dto.UsuarioResponseDto;

public class UsuarioMapper {
	private static ModelMapper mapper = new ModelMapper();
	
	public static Usuario toUsuario(UsuarioCreateDto createDto) {
		return new ModelMapper().map(createDto, Usuario.class);
	}
	
	public static UsuarioResponseDto toDto(Usuario usuario) {
		String role = usuario.getRole().name().substring("ROLE_".length());
		PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
			@Override
			protected void configure() {
				map().setRole(role);
			}
		};
		//mapper.addMappings(props);
		return mapper.map(usuario, UsuarioResponseDto.class);
	}
	
	public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios) {
		return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
	}
}
