package fr.wildcodeschool.serialSeries.controller;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.form.SerieForm;
import fr.wildcodeschool.serialSeries.entity.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import fr.wildcodeschool.serialSeries.entity.Serie;
import fr.wildcodeschool.serialSeries.repository.SerieRepository;
import fr.wildcodeschool.serialSeries.repository.UserRepository;


/**
 * This class handle all request on /user refered to a User
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{id}/serie/create")
    public String createSerie(@PathVariable int id, Model model) {
        model.addAttribute("createdSerie", new SerieForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("serieList", SerieRepository.getInstance().getSerieByUserId(id));
        return "serieCreator";
    }

    @PostMapping("/{id}/serie/create")
    public String createSerie(@PathVariable int id, @ModelAttribute SerieForm serieForm) {
        SerieRepository.getInstance().createSerie(serieForm.getTitle(), serieForm.getNbSeason(), id);
        return "redirect:/user/" + id;
    }

    //This path handle display the user's list
    @GetMapping("/{id}")
    public String getAll(@PathVariable int id, Model model) {
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("userList", UserRepository.getInstance().getUsers());

        List<Serie> series = SerieRepository.getInstance().getSerieByUserId(id);
        model.addAttribute("serieList", series);

        return "userProfile";
    }
    //This handle the user's creation
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("createdUser", new UserForm());
        return "userCreator";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserForm userForm) {
        UserRepository.getInstance().createUser(userForm.getUserName(), userForm.getPictureUrl());
        return "redirect:/";
    }

    
}
