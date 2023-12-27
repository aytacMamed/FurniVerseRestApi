package com.example.furniverse.controller;


import com.example.furniverse.dto.ProductDTO;
import com.example.furniverse.entity.Product;
import com.example.furniverse.manager.ProductManager;
import com.example.furniverse.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productManager;
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/products")
    public List<ProductDTO> getAll() {

        logger.info("getAll request accepted");
        return productManager.getAll();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getById(@PathVariable int id) {
        return productManager.getById(id);
    }

    @PostMapping("/product")
    public void saveCategory(@RequestBody ProductDTO productDTO) {
        productManager.saveProduct(productDTO);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id) {
        productManager.deleteProduct(id);
    }
}
