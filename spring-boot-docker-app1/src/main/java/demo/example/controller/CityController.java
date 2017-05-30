package demo.example.controller;

import demo.example.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by prayoon-pc on 5/25/2017.
 */
@Slf4j
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository repository;

    @RequestMapping
    public ModelAndView getCities() {
        log.debug("debug invoke getCities");
        log.info("info invoke getCities");
        return new ModelAndView("cities", "cities", repository.findAll());
    }
}
