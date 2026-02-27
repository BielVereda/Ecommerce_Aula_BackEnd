package com.projeto.ecommerce.DTOs;

import java.util.UUID;

public record CategoryDTO(
        UUID id,
        String name
) {
}