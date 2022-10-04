package personal.projects.GymPlan.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import personal.projects.GymPlan.dtos.IngredientDto;
import personal.projects.GymPlan.dtos.RecipeDto;
import personal.projects.GymPlan.dtos.ShoppingListDto;
import personal.projects.GymPlan.dtos.UserDto;
import personal.projects.GymPlan.entities.Ingredient;
import personal.projects.GymPlan.entities.Recipe;
import personal.projects.GymPlan.entities.ShoppingList;
import personal.projects.GymPlan.entities.User;

import javax.annotation.Generated;
import java.util.stream.Collectors;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2022-09-27T13:15:42+0300",
        comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
@RequiredArgsConstructor
public class MapStructMapperImpl implements MapStructMapper{

    @Override
    public IngredientDto ingredientToIngredientDto(Ingredient ingredient) {
        return new IngredientDto().builder()
                .shopFrom(ingredient.getShopFrom())
                .quantity(ingredient.getQuantity())
                .build();
    }

    @Override
    public Ingredient ingredientDtoToIngredient(IngredientDto ingredientDto) {
        return new Ingredient().builder()
                .shopFrom(ingredientDto.getShopFrom())
                .quantity(ingredientDto.getQuantity())
                .build();
    }

    @Override
    public RecipeDto recipeToRecipeDto(Recipe recipe) {

        return new RecipeDto().builder()
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients().stream().map(ingredient -> ingredientToIngredientDto(ingredient)).collect(Collectors.toList()))
                .users(recipe.getUsers().stream().map(user->userToUserDto(user)).collect(Collectors.toList()))
                .specialNote(recipe.getSpecialNote())
                .build();
    }

    @Override
    public Recipe recipeDtoToRecipe(RecipeDto recipeDto) {

        return  new Recipe().builder()
                .description(recipeDto.getDescription())
                .ingredients(recipeDto.getIngredients().stream().map(ingredientDto -> ingredientDtoToIngredient(ingredientDto)).collect(Collectors.toList()))
                .users(recipeDto.getUsers().stream().map(userDto->userDtoToUser(userDto)).collect(Collectors.toList()))
                .specialNote(recipeDto.getSpecialNote())
                .build();
    }

    @Override
    public UserDto userToUserDto(User user) {

        return new UserDto().builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .recipes(user.getRecipes().stream().map(recipe -> recipeToRecipeDto(recipe)).collect(Collectors.toList()))
                .build();
    }

    @Override
    public User userDtoToUser(UserDto userDto) {

        return new User().builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .recipes(userDto.getRecipes().stream().map(recipeDto -> recipeDtoToRecipe(recipeDto)).collect(Collectors.toList()))
                .build();
    }

    @Override
    public ShoppingListDto shoppingListToShoppingListDto(ShoppingList shoppingList) {

        return new ShoppingListDto().builder()
                .createdAt(shoppingList.getCreatedAt())
                .user(userToUserDto(shoppingList.getUser()))
                .ingredients(shoppingList.getIngredients().stream().map(ingredient -> ingredientToIngredientDto(ingredient)).collect(Collectors.toList()))
                .shops(shoppingList.getShops())
                .build();
    }

    @Override
    public ShoppingList shoppingListDtoToShoppingList(ShoppingListDto shoppingListDto) {

        return new ShoppingList().builder()
                .createdAt(shoppingListDto.getCreatedAt())
                .user(userDtoToUser(shoppingListDto.getUser()))
                .ingredients(shoppingListDto.getIngredients().stream().map(ingredient -> ingredientDtoToIngredient(ingredient)).collect(Collectors.toList()))
                .shops(shoppingListDto.getShops())
                .build();
    }
}
