package java_web_exam.demo.model.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductViewModel {
    private String name;
    private String id;
    private BigDecimal price;
}
