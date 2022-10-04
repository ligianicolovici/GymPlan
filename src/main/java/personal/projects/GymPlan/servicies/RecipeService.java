package personal.projects.GymPlan.servicies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.projects.GymPlan.dtos.IngredientDto;
import personal.projects.GymPlan.dtos.RecipeDto;
import personal.projects.GymPlan.entities.Ingredient;
import personal.projects.GymPlan.entities.Recipe;
import personal.projects.GymPlan.mappers.MapStructMapperImpl;
import personal.projects.GymPlan.repositories.RecipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    private final MapStructMapperImpl mapStructMapperImpl;

    public RecipeDto createRecipe(RecipeDto recipeDto){
        Recipe recipe = mapStructMapperImpl.recipeDtoToRecipe(recipeDto);
        List<IngredientDto> ingredientDtoList = recipeDto.getIngredients();
        if(ingredientService.persistIngredients(ingredientDtoList).size()!= ingredientDtoList.size()){
            //TO DO: display message
        }
        return mapStructMapperImpl.recipeToRecipeDto(recipeRepository.save(recipe));
    }

}
