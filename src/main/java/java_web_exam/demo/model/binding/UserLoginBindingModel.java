package java_web_exam.demo.model.binding;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static java_web_exam.demo.constants.GlobalConstants.*;
@Data
@NoArgsConstructor
public class UserLoginBindingModel {


    @Length(min = 3, max = 20, message = USERNAME_LENGTH_VALIDATION)
    @NotBlank(message = BLANK_VALUES_FOR_FIELD)
    private String username;
    @Length(min = 3, max = 20, message = PASSWORD_LENGTH_VALIDATION)
    @NotBlank(message = BLANK_VALUES_FOR_FIELD)
    private String password;
}
