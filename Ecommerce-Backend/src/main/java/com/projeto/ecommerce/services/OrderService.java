package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Getter
@Setter
@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository repository,
                        UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public OrderDTO create(OrderDTO dto) {

        UserEntity user = userRepository.findById(dto.clientId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        OrderEntity entity = new OrderEntity();
        entity.setMoment(LocalDate.now());
        entity.setStatus(dto.status());
        entity.setClient(user);

        return toDTO(repository.save(entity));
    }

    private OrderDTO toDTO(OrderEntity entity) {
        return new OrderDTO(
                entity.getId(),
                entity.getMoment(),
                entity.getStatus(),
                entity.getClient().getId()
        );
    }
}