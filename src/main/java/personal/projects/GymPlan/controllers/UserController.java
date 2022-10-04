package personal.projects.GymPlan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import personal.projects.GymPlan.dtos.UserDto;
import personal.projects.GymPlan.entities.User;
import personal.projects.GymPlan.servicies.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    public static final String CREATE_ACCOUNT = "/register";
    public static final String LOGIN = "/login/{username}/{password}";

//    @GetMapping(value=LOGIN, produces = "application/json")
//    public UserDto login(@PathVariable String username, @PathVariable String password) {
//        System.out.println("Username :" + username);
//        return userService.login(username,password);
//    }

    @GetMapping(value = "/login")
    public String login(@ModelAttribute(name = "user") UserDto user) {
        return "login";
    }

    @PostMapping(value = "/login")
    public String renderHomePage(@ModelAttribute(name = "user") User user, Model model) {
        return "home";
    }

    @GetMapping(value = "/logout")
    public String logout(@ModelAttribute(name = "user") UserDto user) {
        return "login";
    }

    @GetMapping(value = "/home")
    public String returnToHomePage(Model model) {

        User user = new User();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            user.setUsername(((User) principal).getUsername());
        }

        model.addAttribute("user", user);
        return "home";
    }

    @PostMapping(value=CREATE_ACCOUNT, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody final UserDto userDto) {
        System.out.println("User :" + userDto);
        return userService.register(userDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.CONTINUE)
    public String connect(){
        return "works";
    }

}
