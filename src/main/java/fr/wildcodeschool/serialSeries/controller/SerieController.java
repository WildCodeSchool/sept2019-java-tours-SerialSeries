package fr.wildcodeschool.serialSeries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.wildcodeschool.serialSeries.entity.form.SerieForm;
import fr.wildcodeschool.serialSeries.repository.SerieRepository;
import fr.wildcodeschool.serialSeries.repository.UserRepository;

@Controller
@RequestMapping("/serie")
public class SerieController {
	  @GetMapping("/create")
	    public String createSerie(Model model) {
	        model.addAttribute("createdSerie", new SerieForm());
	        model.addAttribute("users", UserRepository.getInstance().getUsers());
	        return "serieCreator";
	    }
	    
	    @PostMapping("/create")
	    public String createUser(@ModelAttribute SerieForm serieForm ) {
	        SerieRepository.getInstance().createSerie(serieForm.getTitle(), serieForm.getNbSeason(), serieForm.getUserId());
	        return "redirect:/";
	    }

}
