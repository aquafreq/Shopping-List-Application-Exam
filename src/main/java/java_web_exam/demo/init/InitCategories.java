package java_web_exam.demo.init;


import java_web_exam.demo.model.entity.Category;
import java_web_exam.demo.service.CategoryService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java_web_exam.demo.model.entity.CategoryEnum.*;

@Component
public class InitCategories implements ApplicationRunner {
    private final CategoryService categoryService;

    public InitCategories(CategoryService categoryRepository) {
        this.categoryService = categoryRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (categoryService.size() == 0) {
            Category[] categories = {
                    new Category("Food", "Hello, this is a Food category, nice to meet you"),
                    new Category("Drink", "Hello, this is a Drink category, nice to meet you"),
                    new Category("Household", "Hello, this is a Household category, nice to meet you"),
                    new Category("Other", "Hello, this is a Other category, nice to meet you"),
            };

            categoryService.seedCategories(categories);
        }
    }
}
