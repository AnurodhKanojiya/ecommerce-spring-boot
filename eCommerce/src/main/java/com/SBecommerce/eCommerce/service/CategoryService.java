package com.SBecommerce.eCommerce.service;

import com.SBecommerce.eCommerce.model.Category;
import com.SBecommerce.eCommerce.payload.CategoryDTO;
import com.SBecommerce.eCommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();

    CategoryDTO createCategories(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO,Long categoryId);
}
