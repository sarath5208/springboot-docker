package gov.cancer.ccr.oit.labmatrix.spring.service;

import gov.cancer.ccr.oit.labmatrix.spring.dto.CategoryDTO;
import gov.cancer.ccr.oit.labmatrix.spring.model.Category;
import gov.cancer.ccr.oit.labmatrix.spring.repo.CategoryRepository;
import gov.cancer.ccr.oit.labmatrix.spring.util.RandomUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper)
    {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CategoryDTO> getAllCategories()
    {
        Type listType = new TypeToken<List<CategoryDTO>>() {}.getType();
        return modelMapper.map(categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "id")), listType);
    }

    @Override
    public CategoryDTO findCategoryById(Long id)
    {
        Optional<Category> categoryOptional=categoryRepository.findById(id);
        return categoryOptional.map(category -> modelMapper.map(category, CategoryDTO.class)).orElse(null);
    }

    @Override
    public CategoryDTO createCategory()
    {
        Category category = new Category();
        category.setId(RandomUtil.getSecureRandomPositiveLongValue());
        category.setCreatedOn(LocalDateTime.now());
        category.setName("Books");
        return modelMapper.map(categoryRepository.saveAndFlush(category), CategoryDTO.class);
    }
}
