package personal.projects.GymPlan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.projects.GymPlan.utils.Shop;

import java.io.Serializable;

/**
 * A DTO for the {@link personal.projects.GymPlan.entities.Ingredient} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto implements Serializable {
    private Shop shopFrom;
    private Double quantity;

}

