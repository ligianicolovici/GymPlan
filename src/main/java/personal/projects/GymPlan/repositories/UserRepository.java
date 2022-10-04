package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import personal.projects.GymPlan.entities.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}