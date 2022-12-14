package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/users")
    public String index(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }


    @GetMapping("/new")
    public String createUserForm(User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String createUser(User user) {

        userService.saveUser(user);
        return "redirect:/users";

    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {

        userService.deleteUser(id);
        return "redirect:/users";

    }


    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        User user=userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }
}
