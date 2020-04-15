package gov.cancer.ccr.oit.labmatrix.spring.web;

import gov.cancer.ccr.oit.labmatrix.spring.dto.CategoryDTO;
import gov.cancer.ccr.oit.labmatrix.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController
{
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/list")
    public List<CategoryDTO> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id)
    {
        return categoryService.findCategoryById(id);
    }

    @GetMapping(path = "/create")
    public CategoryDTO createCategory()
    {
        return categoryService.createCategory();
    }
}
