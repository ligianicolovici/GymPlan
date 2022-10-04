package personal.projects.GymPlan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import personal.projects.GymPlan.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
@Data
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {
    private String username;
    private String password;
    private String email;
    private List<RecipeDto> recipes;

    public UserDto() {
        this.recipes = new ArrayList<RecipeDto>();
    }
}

