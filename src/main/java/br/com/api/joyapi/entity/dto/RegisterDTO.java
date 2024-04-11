package br.com.api.joyapi.entity.dto;

import br.com.api.joyapi.entity.enums.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
