package personal.projects.GymPlan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.GymPlan.entities.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}