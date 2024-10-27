package pl.sulazula.thymeleafDBapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sulazula.thymeleafDBapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
