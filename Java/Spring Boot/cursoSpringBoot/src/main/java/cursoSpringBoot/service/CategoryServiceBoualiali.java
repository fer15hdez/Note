package cursoSpringBoot.service;

import cursoSpringBoot.domain.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceBoualiali {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceBoualiali(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }
}
