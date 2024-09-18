package cursoSpringBoot.controller;

import cursoSpringBoot.domain.Category;
import cursoSpringBoot.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @PostMapping("/db/categories")
    public Category create(
            @RequestBody Category category
    ){
        return categoryRepository.save(category);
    }

    @GetMapping("/db/categories")
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
