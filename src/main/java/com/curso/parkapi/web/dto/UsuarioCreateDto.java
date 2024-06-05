package com.curso.parkapi.web.dto;

import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDto {
	
	@NotBlank
	@Email(message = "Formato de e-mail inválido.", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
	private String username;
	
	@NotBlank
	@Size(min = 6, max = 6)
	private String password;
}
