package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.GymPlan.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}