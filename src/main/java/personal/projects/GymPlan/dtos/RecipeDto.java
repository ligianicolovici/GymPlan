package personal.projects.GymPlan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link personal.projects.GymPlan.entities.Recipe} entity
 */
@Data
@Builder
@AllArgsConstructor
public class RecipeDto implements Serializable {
    private List<IngredientDto> ingredients;
    private String description;
    private String specialNote;
    private List<UserDto> users;

    public RecipeDto() {
        this.ingredients = new ArrayList<IngredientDto>();
        this.users = new ArrayList<UserDto>();
    }
}