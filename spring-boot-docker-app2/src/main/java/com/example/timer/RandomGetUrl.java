package com.example.timer;

import com.example.entity.City;
import com.example.entity.Superhero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by prayoon-pc on 5/29/2017.
 */
@Component
@Slf4j
public class RandomGetUrl {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
    private final RestTemplate restTemplate;

    public RandomGetUrl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Scheduled(fixedRate = 5000)
    public void getSuperHero() {
        log.debug("execute get superhero ");
        try {
            String restEndPointUrl = "http://127.0.0.1:8081/superhero";
            ResponseEntity<Superhero[]> responseEntity = restTemplate.getForEntity(restEndPointUrl, Superhero[].class);
            Superhero[] superheros = responseEntity.getBody();
            MediaType contentType = responseEntity.getHeaders().getContentType();
            HttpStatus statusCode = responseEntity.getStatusCode();
            log.debug("we have [{}] superhero from content-type [{}] , and status code [{}]", superheros.length, contentType, statusCode);
        } catch (Exception ex) {
            log.error("Exception on feed data", ex);
        }
    }

    @Scheduled(fixedRate = 3000)
    public void getCitiesById() {
        log.debug("execute get cities by id ");
        try {
            String restEndPointUrl = "http://127.0.0.1:8081/cities/{id}";
            int id = getRandomNumberInRange(1, 150);
            ResponseEntity<City> responseEntity = restTemplate.getForEntity(restEndPointUrl, City.class, id);
            City city = responseEntity.getBody();
            MediaType contentType = responseEntity.getHeaders().getContentType();
            HttpStatus statusCode = responseEntity.getStatusCode();
            log.debug("cities by id [{}] superhero from content-type [{}] , and status code [{}]", id, contentType, statusCode);
            log.debug("cities name [{}] , population [{}] ", city.getName(), city.getPopulation());
        } catch (Exception ex) {
            log.error("Exception on feed data", ex);
        }
    }
}
