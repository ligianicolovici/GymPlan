package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import personal.projects.GymPlan.entities.Recipe;
@Component
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}