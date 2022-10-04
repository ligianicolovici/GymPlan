package personal.projects.GymPlan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import personal.projects.GymPlan.entities.ShoppingList;
import personal.projects.GymPlan.utils.Shop;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link ShoppingList} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ShoppingListDto implements Serializable {
    private List<IngredientDto> ingredients;
    private List<Shop> shops;
    private UserDto user;
    private LocalDateTime createdAt;

    public ShoppingListDto() {
        this.ingredients = new ArrayList<IngredientDto>();
        this.shops = new ArrayList<Shop>();
    }
}