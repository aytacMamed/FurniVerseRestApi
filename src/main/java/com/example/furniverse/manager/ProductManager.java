package com.example.furniverse.manager;

import com.example.furniverse.dto.ProductDTO;
import com.example.furniverse.dto.ProductDTOManager;
import com.example.furniverse.entity.Product;
import com.example.furniverse.exception.CategoryNotFoundException;
import com.example.furniverse.exception.ProductNotFoundException;
import com.example.furniverse.mapper.ProductMapper;
import com.example.furniverse.repository.ProductRepository;
import com.example.furniverse.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private final ProductDTOManager productDTOManager;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDTO).toList();
    }

    @Override
    public ProductDTO getById(int id) {
        return productRepository.findById(id).stream().map(productMapper::toProductDTO).
                findFirst().orElseThrow(()->new ProductNotFoundException("Product is not found"));
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.toProductEntity(productDTO));
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
