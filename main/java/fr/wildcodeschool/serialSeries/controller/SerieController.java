package fr.wildcodeschool.serialSeries.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.entity.form.SerieForm;
import fr.wildcodeschool.serialSeries.repository.SerieRepository;
import fr.wildcodeschool.serialSeries.repository.UserRepository;

@Controller
public class SerieController {
	private SerieRepository serieRepository = new SerieRepository();
	private UserRepository userRepository = new UserRepository();
    
    @GetMapping("/")
    public String getAll(Model model) {
    	model.addAttribute("serie", new SerieForm());
    	model.addAttribute("user", new User());
        model.addAttribute("series", serieRepository.getSeriesByUserId(-1));
        model.addAttribute("users", userRepository.getUsers());
        return "index";
    }
    @PostMapping("/serie")
    public String createSerie(@ModelAttribute SerieForm serie, Model model) {
    	serieRepository.createSerie(serie.getTitle(), serie.getNbSeason(), serie.getUserId());
    	model.addAttribute("serie", new SerieForm());
    	model.addAttribute("user", new User());
        model.addAttribute("series", serieRepository.getSeriesByUserId(serie.getUserId()));
        model.addAttribute("users", userRepository.getUsers());
        return "redirect:/serie?id="+ serie.getUserId();
    }
    @GetMapping("/serie")
    public String getSerie(@RequestParam int id, Model model) {
    	model.addAttribute("serie", new SerieForm());
    	model.addAttribute("user", new User());
        model.addAttribute("series", serieRepository.getSeriesByUserId(id));
        model.addAttribute("users", userRepository.getUsers());
        return "index";
    }
    @PostMapping("/user")
    public String createUser(@ModelAttribute User user) {
    	userRepository.createUser(user.getUserName(),user.getPictures());  

        return "redirect:/";
    }
    
  

    
}
