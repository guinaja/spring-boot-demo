package demo.example.timer;

import demo.example.entity.City;
import demo.example.entity.Superhero;
import demo.example.repository.CityRepository;
import demo.example.repository.SuperheroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by prayoon-pc on 5/29/2017.
 */
@Component
@Slf4j
public class LogGenerator {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private SuperheroRepository superHeroRepository;

    private static Long getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return Long.valueOf(r.nextInt((max - min) + 1) + min);
    }


    @Scheduled(fixedRate = 2500)
    public void writeLogError() {
        log.error("Generate Exception for kibana");
    }


    @Scheduled(fixedRate = 5000)
    public void getSuperHero() {
        log.debug("execute get superhero ");
        try {

            log.debug("execute get superhero result : [{}] records",superHeroRepository.findAll().size());
        } catch (Exception ex) {
            log.error("Exception on feed data", ex);
        }
    }
    @Scheduled(fixedRate = 4000)
    public void getCity() {
        try {
            log.debug("execute get city result : [{}] records",cityRepository.findAll().size());
        } catch (Exception ex) {
            log.error("Exception on feed data", ex);
        }
    }
    @Scheduled(fixedRate = 3000)
    public void getCitiesById() {
        try {
            Long id = getRandomNumberInRange(1, 650);
            City city = cityRepository.findOne(id);
            log.debug("execute get city by id [{}] cities name [{}] , population [{}] ", id, city.getName(), city.getPopulation());
        } catch (Exception ex) {
            log.error("Exception on feed city data", ex);
        }
    }

    @Scheduled(fixedRate = 6000)
    public void getSuperHeroById() {
        try {
            Long id = getRandomNumberInRange(1, 10);
            Superhero superhero = superHeroRepository.findOne(id);
            log.debug("execute get superhero by id  [{}] superhero name [{}] ", id, superhero.getName());
        } catch (Exception ex) {
            log.error("Exception on feed superhero data", ex);
        }
    }
}
