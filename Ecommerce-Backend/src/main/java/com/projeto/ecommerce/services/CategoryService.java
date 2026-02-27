package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.CategoryDTO;
import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(UUID id) {
        CategoryEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return toDTO(entity);
    }

    public CategoryDTO create(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.name());

        return toDTO(repository.save(entity));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private CategoryDTO toDTO(CategoryEntity entity) {
        return new CategoryDTO(
                entity.getId(),
                entity.getName()
        );
    }
}