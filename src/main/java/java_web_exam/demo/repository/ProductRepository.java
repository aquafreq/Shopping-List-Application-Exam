package java_web_exam.demo.repository;

import java_web_exam.demo.model.entity.Category;
import java_web_exam.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
        Collection<Product> getAllByCategory(Category category);
}
