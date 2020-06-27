package java_web_exam.demo.model.entity;


import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
@AllArgsConstructor
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    @NonNull
    private CategoryEnum name;

    private String description;

    public Category(String name, String description) {
        setName(CategoryEnum.valueOf(name));
        setDescription(description);
    }
}
