package java_web_exam.demo.model.binding;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@ScriptAssert(lang = "javascript",
        script = "_this.confirmPassword !== null &&_this.password === _this.confirmPassword",
        reportOn = "confirmPassword",
        message = "Passwords don't match lol, they must do :)")
public class UserRegisterBindingModel {
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String username;

    @Email(message = "java spring email annotation, plz enter valid email")
    @NotBlank(message = "enter valid email")
    private String email;

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String password;

    private String confirmPassword;
}
