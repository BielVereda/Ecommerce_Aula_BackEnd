package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository repository,
                        UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<OrderDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findById(UUID id) {
        OrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return toDTO(entity);
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

    public OrderDTO update(UUID id, OrderDTO dto) {
        OrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        entity.setStatus(dto.status());

        if (dto.clientId() != null) {
            UserEntity user = userRepository.findById(dto.clientId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            entity.setClient(user);
        }

        return toDTO(repository.save(entity));
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        repository.deleteById(id);
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