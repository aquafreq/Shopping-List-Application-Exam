package java_web_exam.demo.service.impl;

import java_web_exam.demo.model.entity.User;
import java_web_exam.demo.model.service.UserServiceModel;
import java_web_exam.demo.repository.UserRepository;
import java_web_exam.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

import static java_web_exam.demo.constants.GlobalConstants.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final String INVALID_USERNAME_OR_PASSWORD = "Invalid username or password";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserServiceModel loginUser(UserServiceModel serviceModel) throws EntityNotFoundException {
        User no_such_user_found = userRepository
                .getByUsernameAndPassword(serviceModel.getUsername(),serviceModel.getPassword())
                .orElseThrow(() -> new EntityNotFoundException(INVALID_USERNAME_OR_PASSWORD));

        return modelMapper.map(no_such_user_found,UserServiceModel.class);
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) throws IllegalArgumentException {
        if (userRepository.getByUsername(userServiceModel.getUsername()).isPresent())
            throw new IllegalArgumentException(USER_USERNAME_EXISTS);

        if (userRepository.getByEmail(userServiceModel.getEmail()).isPresent())
            throw new IllegalArgumentException(USER_EMAIL_EXISTS);

        User map = modelMapper.map(userServiceModel, User.class);

        return modelMapper.map(userRepository.save(map), UserServiceModel.class);
    }
}
