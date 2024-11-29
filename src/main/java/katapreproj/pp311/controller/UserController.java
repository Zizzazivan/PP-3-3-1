package katapreproj.pp311.controller;

import katapreproj.pp311.model.User;
import katapreproj.pp311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private static final String REDIRECT_USERS = "redirect:/users";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("users/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create-form";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return REDIRECT_USERS;
    }

    @GetMapping("/users/update")
    public String updateForm(@RequestParam("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-form";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return REDIRECT_USERS;
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return REDIRECT_USERS;
    }




}
