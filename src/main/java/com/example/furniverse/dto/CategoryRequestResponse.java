package com.example.furniverse.dto;

import jakarta.validation.constraints.*;


public record CategoryRequestResponse(
        @NotNull(message = "categoryName should not be null")
        @NotEmpty(message = "categoryName should not be empty")
        @NotBlank(message = "categoryName should not be blank")
        @Email(message = "you should be input email")
        @Size(min = 4,message = "minimum size 4")
        String categoryName,

        String description
) {
}
