package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.UserDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO create(UserEntity entity) {
        return toDTO(repository.save(entity));
    }

    public UserDTO findById(UUID id) {
        UserEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return toDTO(entity);
    }

    private UserDTO toDTO(UserEntity entity) {
        return new UserDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getRoles()
        );
    }
}