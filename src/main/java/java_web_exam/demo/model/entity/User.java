package java_web_exam.demo.model.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static java_web_exam.demo.constants.GlobalConstants.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Length(min = 3,max = 20, message = USERNAME_LENGTH_VALIDATION)
    @Column(unique = true, length = 20)
    private String username;

    @Length(min = 3,max = 20, message = PASSWORD_LENGTH_VALIDATION)
    private String password;

    @Email(message = VALID_EMAIL)
    @NotBlank(message = NULL_FOR_EMAIL)
    private String email;
}
