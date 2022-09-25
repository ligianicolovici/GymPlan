package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.GymPlan.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}