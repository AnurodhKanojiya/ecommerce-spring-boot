package com.SBecommerce.eCommerce.service;

import com.SBecommerce.eCommerce.Repository.CategoryRepository;
import com.SBecommerce.eCommerce.exception.APIException;
import com.SBecommerce.eCommerce.exception.ResourceNotFoundException;
import com.SBecommerce.eCommerce.model.Category;
import com.SBecommerce.eCommerce.payload.CategoryDTO;
import com.SBecommerce.eCommerce.payload.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
//import java.util.ReverseOrderListView;

@Service
public class CategoryServiceImplementation implements CategoryService{

//    List<Category> categories = new ArrayList<>();
    @Autowired
  private  CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    
//    private long nextId=1L;
    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories= categoryRepository.findAll();
        if(categories.isEmpty())
            throw new APIException("No Category Exist");
        List<CategoryDTO> categoryDTOS= categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategories(CategoryDTO categoryDTO) {

        Category category= modelMapper.map(categoryDTO, Category.class);

        Category categoryFromDB = categoryRepository.findByCategoryName(category.getCategoryName());
        if(categoryFromDB != null){
            throw new APIException("Category With "+ category.getCategoryName() +" Already Exist");
        }
        Category savedCategory =categoryRepository.save(category);
        return modelMapper.map(savedCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(long categoryId) {
         Category category= categoryRepository.findById(categoryId)
                  .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found") );
        categoryRepository.deleteById(categoryId);
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO , Long categoryId) {


        Category updatedcategory = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found"));

//        Category category=modelMapper.map(categoryDTO,Category.class);

        updatedcategory.setCategoryName(categoryDTO.getCategoryName());
        return modelMapper.map( categoryRepository.save(updatedcategory),CategoryDTO.class);

    }
}
