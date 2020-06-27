package java_web_exam.demo.repository;

import java_web_exam.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> getByUsernameAndPassword(String username, String password);

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);
}
