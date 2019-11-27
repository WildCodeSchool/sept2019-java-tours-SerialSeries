package fr.wildcodeschool.serialSeries.controller;

import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	
	// Display Home page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentUser", new User());
        model.addAttribute("userList", UserRepository.getInstance().getUsers());
    return "index";
}
}
