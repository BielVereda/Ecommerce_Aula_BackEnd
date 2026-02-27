package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.StatusDoPedido;

import java.time.LocalDate;
import java.util.UUID;

public record OrderDTO(
        UUID id,
        LocalDate moment,
        StatusDoPedido status,
        UUID clientId
) {
}