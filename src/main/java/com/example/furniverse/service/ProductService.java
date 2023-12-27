package com.example.furniverse.service;

import com.example.furniverse.dto.ProductDTO;
import com.example.furniverse.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    ProductDTO getById(int id);
    void saveProduct(ProductDTO productDTO);
    void deleteProduct(int id);
}
