package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.ProductDTO;
import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.repositories.CategoryRepository;
import com.projeto.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository,
                          CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(UUID id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return toDTO(entity);
    }

    public ProductDTO create(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();

        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setImgURL(dto.imgURL());

        Set<CategoryEntity> categories = dto.categoriesIds()
                .stream()
                .map(catId -> categoryRepository.findById(catId)
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada")))
                .collect(Collectors.toSet());

        entity.setCategories(categories);

        return toDTO(repository.save(entity));
    }

    public ProductDTO update(UUID id, ProductDTO dto) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setImgURL(dto.imgURL());

        entity.getCategories().clear();

        Set<CategoryEntity> categories = dto.categoriesIds()
                .stream()
                .map(catId -> categoryRepository.findById(catId)
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada")))
                .collect(Collectors.toSet());

        entity.setCategories(categories);

        return toDTO(repository.save(entity));
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        repository.deleteById(id);
    }

    private ProductDTO toDTO(ProductEntity entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgURL(),
                entity.getCategories()
                        .stream()
                        .map(CategoryEntity::getId)
                        .collect(Collectors.toSet())
        );
    }
}