package com.projeto.ecommerce.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public record PaymentDTO(
        UUID id,
        LocalDate moment,
        UUID orderId
) {
}