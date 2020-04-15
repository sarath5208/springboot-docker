package gov.cancer.ccr.oit.labmatrix.spring.service;

import gov.cancer.ccr.oit.labmatrix.spring.dto.CategoryDTO;

import java.util.List;

public interface CategoryService
{
    List<CategoryDTO> getAllCategories();

    CategoryDTO findCategoryById(Long id);

    CategoryDTO createCategory();
}
