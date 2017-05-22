package be.g00glen00b.controller;

import be.g00glen00b.repository.SuperheroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/superhero")
public class SuperheroController {
    @Autowired
    private SuperheroRepository repository;

    @RequestMapping
    public ModelAndView getSuperheroes() {
        log.debug("debug invoke getSuperheroes");
        log.info("info invoke getSuperheroes");
        return new ModelAndView("superheroes", "superheroes", repository.findAll());
    }
}
