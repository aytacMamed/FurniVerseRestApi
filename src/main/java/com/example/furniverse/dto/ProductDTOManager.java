package com.example.furniverse.dto;

import com.example.furniverse.entity.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDTOManager implements Function<Product,ProductDTO> {

    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(product.getProductName(), product.getPrice());

    }
}
