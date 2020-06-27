package java_web_exam.demo.model.binding;

import java_web_exam.demo.model.entity.CategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductAddBindingModel {

    @Length(min = 3,max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    private String description;

    @FutureOrPresent(message = "The date cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull(message = "date is required")
    private LocalDateTime neededBefore;
    @DecimalMin(value = "0.0001", message = "price must be higher, plz")
    @NotNull(message = "price is required")
    private BigDecimal price;

    @NotBlank(message = "category is ... A MUST!")
    private String category;
}
