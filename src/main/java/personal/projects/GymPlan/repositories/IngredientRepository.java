package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.GymPlan.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}