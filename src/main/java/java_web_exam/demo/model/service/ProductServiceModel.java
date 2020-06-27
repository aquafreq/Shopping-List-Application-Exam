package java_web_exam.demo.model.service;

import java_web_exam.demo.model.entity.Category;
import java_web_exam.demo.model.entity.CategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductServiceModel {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private String category;
}
