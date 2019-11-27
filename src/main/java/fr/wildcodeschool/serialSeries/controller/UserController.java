package fr.wildcodeschool.serialSeries.controller;

import fr.wildcodeschool.serialSeries.entity.form.EpisodeForm;
import fr.wildcodeschool.serialSeries.entity.form.SeasonForm;
import fr.wildcodeschool.serialSeries.entity.form.SerieForm;
import fr.wildcodeschool.serialSeries.entity.form.UserForm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.wildcodeschool.serialSeries.entity.Episode;
import fr.wildcodeschool.serialSeries.entity.Season;
import fr.wildcodeschool.serialSeries.entity.Serie;
import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.repository.EpisodeRepository;
import fr.wildcodeschool.serialSeries.repository.SeasonRepository;
import fr.wildcodeschool.serialSeries.repository.SerieRepository;
import fr.wildcodeschool.serialSeries.repository.UserRepository;

/**
 * This class handle all request on /user refered to a User
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	
  	@GetMapping("/{id}/season/{seasonId}/episode/create")
    public String createEpisode(@PathVariable int id, @PathVariable int seasonId, Model model) {
        model.addAttribute("createdEpisode", new EpisodeForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("currentSeason", SeasonRepository.getInstance().getSeasonBySeasonId(seasonId));
        return "episodeCreator";
    }
  	
    @PostMapping("/{id}/season/{seasonId}/episode/create")
    public String createEpisode(@PathVariable int id, @PathVariable int seasonId, @ModelAttribute EpisodeForm episodeForm) {
    	
        EpisodeRepository.getInstance().createEpisode(episodeForm.getTitle(), id, episodeForm.getNumber(), false, seasonId, SeasonRepository.getInstance().getSeasonBySeasonId(seasonId).getSerieId());
        return "redirect:/user/{id}";
    }
    
    
	
  	@GetMapping("/{id}/season/create")
    public String createSeason(@PathVariable int id, Model model) {
        model.addAttribute("createdSeason", new SeasonForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("serieList", SerieRepository.getInstance().getSerieByUserId(id));
        return "seasonCreator";
    }
  	
    @PostMapping("/{id}/season/create")
    public String createUser(@ModelAttribute SeasonForm seasonForm) {
        SeasonRepository.getInstance().createSeason(seasonForm.getNumber(), seasonForm.getSerieId());;
        return "redirect:/user/{id}";
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
        return "redirect:/user/{id}";
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
        
        List<Episode> episodes = new ArrayList<>();
        seasons.forEach(seasonX-> episodes.addAll(EpisodeRepository.getInstance().getEpisodeBySeasonId(seasonX.getId())));
        model.addAttribute("episodeList",episodes);
        
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
