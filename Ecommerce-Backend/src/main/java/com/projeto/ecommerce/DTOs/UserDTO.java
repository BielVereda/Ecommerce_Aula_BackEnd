package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.RoleEnum;

import java.util.UUID;

public record UserDTO(
        UUID id,
        String name,
        String email,
        String phone,
        RoleEnum roles
) {
}