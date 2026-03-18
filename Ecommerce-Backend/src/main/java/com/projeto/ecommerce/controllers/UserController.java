package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.UserDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserEntity entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable UUID id, @RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}