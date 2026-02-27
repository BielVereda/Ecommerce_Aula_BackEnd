package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.PaymentDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository repository,
                          OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    public PaymentDTO create(PaymentDTO dto) {

        OrderEntity order = orderRepository.findById(dto.orderId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PaymentEntity entity = new PaymentEntity();
        entity.setMoment(LocalDate.now());
        entity.setOrder(order);

        return toDTO(repository.save(entity));
    }

    private PaymentDTO toDTO(PaymentEntity entity) {
        return new PaymentDTO(
                entity.getId(),
                entity.getMoment(),
                entity.getOrder().getId()
        );
    }
}