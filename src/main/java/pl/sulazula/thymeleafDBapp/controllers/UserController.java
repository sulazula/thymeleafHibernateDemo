package pl.sulazula.thymeleafDBapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sulazula.thymeleafDBapp.model.User;
import pl.sulazula.thymeleafDBapp.repos.UserRepository;
import pl.sulazula.thymeleafDBapp.service.UserService;

import java.util.Optional;
import java.util.function.Supplier;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }
    @PostMapping()
    public String addUser(User user) {
        userService.addUser(user);

        return "redirect:/users";
    }
    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());

        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) throws Throwable {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "redirect:/users";
    }

}
