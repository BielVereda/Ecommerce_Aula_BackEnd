package com.projeto.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class PaymentEntity {

    @Id
    private UUID id;
    private LocalDate moment;

    @OneToOne
    @MapsId
    private OrderEntity order;
}