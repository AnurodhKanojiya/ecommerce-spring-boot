package com.SBecommerce.eCommerce.controller;

import com.SBecommerce.eCommerce.model.Category;
import com.SBecommerce.eCommerce.payload.CategoryDTO;
import com.SBecommerce.eCommerce.payload.CategoryResponse;
import com.SBecommerce.eCommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity <CategoryResponse> getAllCategories(){
        return new ResponseEntity<>( categoryService.getAllCategories(),HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity< CategoryDTO> createCategories(@Valid @RequestBody CategoryDTO categoryDTO){
      CategoryDTO savedCategory=  categoryService.createCategories(categoryDTO);
        return  new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }

        @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId){

            CategoryDTO deleteCategory = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(deleteCategory , HttpStatus.OK);

    }

    @PutMapping("/api/admin/categories/{categoryId}")
    public  ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,
                                                  @PathVariable Long categoryId){
            CategoryDTO savedCaregory = categoryService.updateCategory(categoryDTO,categoryId);
            return new ResponseEntity<>(savedCaregory, HttpStatus.OK);
    }
}
