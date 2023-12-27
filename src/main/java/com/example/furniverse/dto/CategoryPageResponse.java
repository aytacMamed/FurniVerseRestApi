package com.example.furniverse.dto;

import com.example.furniverse.entity.Category;

import java.util.List;

public record CategoryPageResponse(
        List<Category> categories,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
