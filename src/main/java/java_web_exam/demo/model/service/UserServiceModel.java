package java_web_exam.demo.model.service;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserServiceModel {
    private String id;
    private String username;
    private String email;
    private String password;
}
