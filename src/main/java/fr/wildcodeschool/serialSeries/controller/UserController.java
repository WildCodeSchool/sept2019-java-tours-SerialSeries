package fr.wildcodeschool.serialSeries.controller;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.Episode;
import fr.wildcodeschool.serialSeries.entity.Season;
import fr.wildcodeschool.serialSeries.entity.form.EpisodeForm;
import fr.wildcodeschool.serialSeries.entity.form.SeasonForm;
import javax.validation.Valid;
import fr.wildcodeschool.serialSeries.entity.form.SerieForm;
import fr.wildcodeschool.serialSeries.entity.form.UserForm;
import fr.wildcodeschool.serialSeries.repository.EpisodeRepository;
import fr.wildcodeschool.serialSeries.repository.SeasonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	//Display creation Episode Form
    @GetMapping("/{id}/season/{seasonId}/episode/create")
    public String createEpisode(@PathVariable int id, @PathVariable int seasonId, Model model) {
        model.addAttribute("createdEpisode", new EpisodeForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("currentSeason", SeasonRepository.getInstance().getSeasonBySeasonId(seasonId));
        return "episodeCreator";
    }
    
    //Process season Episode Form
    @PostMapping("/{id}/season/{seasonId}/episode/create")
    public String createEpisode(@PathVariable int id, @PathVariable int seasonId, @ModelAttribute("createdEpisode") @Valid EpisodeForm episodeForm,  BindingResult bindingResult, Model model) {
        EpisodeRepository.getInstance().createEpisode(episodeForm.getTitle(), id, episodeForm.getNumber(), false, seasonId, SeasonRepository.getInstance().getSeasonBySeasonId(seasonId).getSerieId());
        if(bindingResult.hasErrors()) {
            model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
            model.addAttribute("currentSeason", SeasonRepository.getInstance().getSeasonBySeasonId(seasonId));
            return"episodeCreator";
        }
        return "redirect:/user/" + id;
    }
    
	//Display creation season Form
    @GetMapping("/{id}/season/{serieId}/create")
    public String createSeason(@PathVariable int id, @PathVariable int serieId, Model model) {
        model.addAttribute("createdSeason", new SeasonForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("serieId", serieId);
        return "seasonCreator";
    }
    
    //Process season creation Form
    @PostMapping("/{id}/season/{serieId}/create")
    public String createUser(@PathVariable int id,@PathVariable int serieId, @ModelAttribute("createdSeason") @Valid SeasonForm seasonForm, BindingResult bindingResult, Model model) {
        SeasonRepository.getInstance().createSeason(seasonForm.getNumber(), serieId);;
        if(bindingResult.hasErrors()) {
            model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
            model.addAttribute("serieId", serieId);
            return"seasonCreator";
        }
        return "redirect:/user/"+id;
    }
	
	//Display creation série Form
    @GetMapping("/{id}/serie/create")
    public String createSerie(@PathVariable int id, Model model) {
        model.addAttribute("createdSerie", new SerieForm());
        model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
        model.addAttribute("serieList", SerieRepository.getInstance().getSerieByUserId(id));
        return "serieCreator";
    }
    
    //Process série creation Form
    @PostMapping("/{id}/serie/create")
    public String createSerie(@PathVariable int id, @ModelAttribute("createdSerie") @Valid SerieForm createdSerie,BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("currentUser", UserRepository.getInstance().getUsersById(id));
            model.addAttribute("serieList", SerieRepository.getInstance().getSerieByUserId(id));
        	return"serieCreator";
        }
	SerieRepository.getInstance().createSerie(createdSerie.getTitle(), createdSerie.getNbSeason(), id);
        return "redirect:/user/" + id;
    }

    //This path handle display the profile page
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
    
    //Display create User Form
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("createdUser", new UserForm());
        return "userCreator";
    }
    
    //Process User creation Form
    @PostMapping("/create")
    public String createUser(@ModelAttribute UserForm userForm) {
        UserRepository.getInstance().createUser(userForm.getUserName(), userForm.getPictureUrl());
        return "redirect:/";
    }

    
}
