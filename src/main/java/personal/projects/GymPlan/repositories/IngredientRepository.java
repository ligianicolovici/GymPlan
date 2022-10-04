package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.GymPlan.entities.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Override
    Optional<Ingredient> findById(Long aLong);

}