package fr.wildcodeschool.serialSeries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SerialSeriesController {

@GetMapping("/")
public String Home() {
	return null;
}

}
