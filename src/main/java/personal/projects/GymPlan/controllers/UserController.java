package personal.projects.GymPlan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import personal.projects.GymPlan.dtos.UserDto;
import personal.projects.GymPlan.servicies.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
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

    @PostMapping(value=CREATE_ACCOUNT, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody final UserDto userDto) {
        System.out.println("User :" + userDto);
        return userService.register(userDto);
    }

    @GetMapping(value="/connect")
    @ResponseStatus(HttpStatus.CONTINUE)
    public String connect(){
        return "works";
    }

}
