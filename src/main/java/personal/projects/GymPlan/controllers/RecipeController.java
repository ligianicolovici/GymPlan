package personal.projects.GymPlan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import personal.projects.GymPlan.dtos.RecipeDto;
import personal.projects.GymPlan.entities.User;
import personal.projects.GymPlan.servicies.RecipeService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    @PostMapping(value = "/create")
    public RecipeDto renderHomePage(@RequestBody RecipeDto recipeDto) {
        return recipeService.createRecipe(recipeDto);
    }

    @DeleteMapping (value = "/delete")
    public String renderHomePage(@ModelAttribute(name = "user") User user, Model model) {
        return "home";
    }
}
