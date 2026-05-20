package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.UserDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.PhotoService;
import com.projeto.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final PhotoService photoService;

    // === Endpoints padrão ===
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

    // === Novo endpoint com upload de foto ===
    @PostMapping("/upload")
    public ResponseEntity<UserDTO> createWithPhoto(@RequestParam String name,
                                                   @RequestParam String email,
                                                   @RequestParam String phone,
                                                   @RequestParam String password,
                                                   @RequestParam MultipartFile photo) throws IOException {
        // salva a foto em disco
        String pathPhoto = photoService.savePhoto(photo);

        // monta a entidade
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setEmail(email);
        entity.setPhone(phone);
        entity.setPassword(password);
        entity.setPhoto(pathPhoto);

        // persiste e retorna DTO
        return ResponseEntity.ok(service.create(entity));
    }
}