package java_web_exam.demo.repository;

import java_web_exam.demo.model.entity.Category;
import java_web_exam.demo.model.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category getByName(CategoryEnum name);
}
