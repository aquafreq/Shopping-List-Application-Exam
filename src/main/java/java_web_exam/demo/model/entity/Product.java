package java_web_exam.demo.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java_web_exam.demo.constants.GlobalConstants.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product extends BaseEntity{
    @Column(unique = true, length = 20)
    @Length(min = 3,max = 20, message = USERNAME_LENGTH_VALIDATION)
    private String name;

    @Length(min = 5, message = DESCRIPTION_LENGTH)
    private String description;

    @DecimalMin(value = "0", message = POSITIVE_PRICE_NUMBER)
    private BigDecimal price;
    @FutureOrPresent(message = DATE_CANNOT_BE_IN_THEPAST)
    private LocalDateTime neededBefore;

    @NotNull(message = CATEGOR_NOT_NULL)
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Category category;
}
