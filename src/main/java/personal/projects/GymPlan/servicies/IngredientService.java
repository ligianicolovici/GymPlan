package personal.projects.GymPlan.servicies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.projects.GymPlan.dtos.IngredientDto;
import personal.projects.GymPlan.entities.Ingredient;
import personal.projects.GymPlan.mappers.MapStructMapperImpl;
import personal.projects.GymPlan.repositories.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final MapStructMapperImpl mapStructMapperImpl;

    public List<IngredientDto> persistIngredients(List<IngredientDto> ingredientDtoList){
        List<IngredientDto> allCurrentIngredients = ingredientRepository.findAll().stream().map(ingredient -> mapStructMapperImpl.ingredientToIngredientDto(ingredient)).collect(Collectors.toList());
        List<IngredientDto> persistedIngredients = new ArrayList<>();
        for(IngredientDto ingredientDto:ingredientDtoList){
            if(!allCurrentIngredients.contains(ingredientDto)){
                persistedIngredients.add(mapStructMapperImpl.ingredientToIngredientDto(ingredientRepository.save(mapStructMapperImpl.ingredientDtoToIngredient(ingredientDto))));
            }
        }
        return persistedIngredients;
    }
}
