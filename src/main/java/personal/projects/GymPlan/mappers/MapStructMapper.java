package personal.projects.GymPlan.mappers;

import personal.projects.GymPlan.dtos.IngredientDto;
import personal.projects.GymPlan.dtos.RecipeDto;
import personal.projects.GymPlan.dtos.ShoppingListDto;
import personal.projects.GymPlan.dtos.UserDto;
import personal.projects.GymPlan.entities.Ingredient;
import personal.projects.GymPlan.entities.Recipe;
import personal.projects.GymPlan.entities.ShoppingList;
import personal.projects.GymPlan.entities.User;


public interface MapStructMapper {
    IngredientDto ingredientToIngredientDto(Ingredient ingredient);
    Ingredient ingredientDtoToIngredient(IngredientDto ingredientDto);
    RecipeDto recipeToRecipeDto(Recipe recipe);
    Recipe recipeDtoToRecipe(RecipeDto recipeDto);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    ShoppingListDto shoppingListToShoppingListDto(ShoppingList shoppingList);
    ShoppingList shoppingListDtoToShoppingList(ShoppingListDto shoppingListDto);
}
