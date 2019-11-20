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

    @GetMapping("/")
    public String getAll() {

        return "index";
    }

}
