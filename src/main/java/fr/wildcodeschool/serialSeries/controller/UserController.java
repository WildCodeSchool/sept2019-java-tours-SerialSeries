package fr.wildcodeschool.serialSeries.controller;

import fr.wildcodeschool.serialSeries.entity.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.repository.UserRepository;

/**
 * This class handle all request on /user refered to a User
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository repository = new UserRepository();
//This path handle display the user's list
    @GetMapping("/{id}")
    public String getAll(@PathVariable int id, Model model) {
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("userList", UserRepository.getInstance().getUsers());
        return "index";
    }
//This handle the user's creation
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("createdUser", new UserForm());
        return "userCreator";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute UserForm userForm) {
        repository.createUser(userForm.getUserName(), userForm.getPictureUrl());
        return "redirect:/";
    }

}
