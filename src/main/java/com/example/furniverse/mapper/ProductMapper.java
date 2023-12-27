package com.example.furniverse.mapper;

import com.example.furniverse.dto.ProductDTO;
import com.example.furniverse.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);
    Product toProductEntity(ProductDTO productDTO );
}
