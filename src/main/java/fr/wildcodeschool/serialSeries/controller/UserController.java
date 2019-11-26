package fr.wildcodeschool.serialSeries.controller;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.Season;
import fr.wildcodeschool.serialSeries.entity.form.SeasonForm;
import fr.wildcodeschool.serialSeries.entity.form.SerieForm;
import fr.wildcodeschool.serialSeries.entity.form.UserForm;
import fr.wildcodeschool.serialSeries.repository.SeasonRepository;
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

    @GetMapping("/{id}/season/{serieId}/create")
    public String createSeason(@PathVariable int id, @PathVariable int serieId, Model model) {
        model.addAttribute("createdSeason", new SeasonForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("serieId", serieId);
        return "seasonCreator";
    }

    @PostMapping("/{id}/season/{serieId}/create")
    public String createUser(@PathVariable int id,@PathVariable int serieId, @ModelAttribute SeasonForm seasonForm) {
        SeasonRepository.getInstance().createSeason(seasonForm.getNumber(), serieId);;
        return "redirect:/user/"+id;
    }

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


        List<Season> seasons = new ArrayList<>();
        series.forEach(serieX-> seasons.addAll(SeasonRepository.getInstance().getSeasonBySerieId(serieX.getId())));
        model.addAttribute("seasonList", seasons);

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
