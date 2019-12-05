package fr.wildcodeschool.serialSeries.controller;

import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.repository.SerieRepository;
import fr.wildcodeschool.serialSeries.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class handle all request on / refered to the main root
 */

@Controller
public class AppController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentUser", new User());

        model.addAttribute("userList", UserRepository.getInstance().getUsers());
        return "index";
    }
}
