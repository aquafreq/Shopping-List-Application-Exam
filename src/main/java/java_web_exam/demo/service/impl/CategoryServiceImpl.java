package java_web_exam.demo.service.impl;

import java_web_exam.demo.model.entity.Category;
import java_web_exam.demo.model.entity.CategoryEnum;
import java_web_exam.demo.repository.CategoryRepository;
import java_web_exam.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public long size() {
        return categoryRepository.count();
    }

    @Override
    public void seedCategories(Category... categories) {
        Arrays.stream(categories).forEach(categoryRepository::save);
    }

    @Override
    public Category getCategoryByName(String category) {
        return categoryRepository.getByName(CategoryEnum.valueOf(category));
    }
}
