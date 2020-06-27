package java_web_exam.demo.service;

import java_web_exam.demo.model.entity.Category;

public interface CategoryService {
    long size();

    void seedCategories(Category... categories);

    Category getCategoryByName(String category);
}
