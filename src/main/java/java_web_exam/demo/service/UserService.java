package java_web_exam.demo.service;


import java_web_exam.demo.model.service.UserServiceModel;

import javax.persistence.EntityNotFoundException;

public interface UserService {
    UserServiceModel loginUser(UserServiceModel serviceModel) throws EntityNotFoundException;

    UserServiceModel registerUser(UserServiceModel userServiceModel) throws IllegalArgumentException;
}
