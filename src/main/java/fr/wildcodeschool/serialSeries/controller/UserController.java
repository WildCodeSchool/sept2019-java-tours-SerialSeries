package fr.wildcodeschool.serialSeries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.repository.UserRepository;

@Controller
public class UserController {

    private UserRepository repository = new UserRepository();
    
    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", repository.getUsers());
        return "users_get_all";
    }
    
    @PostMapping("/users")
    public String create(@ModelAttribute User user) {
    	repository.createUser(user.getUserName(),user.getPictures());
    	return "redirect:/users";
    }
    
    

    
}
