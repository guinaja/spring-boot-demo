package demo.example.repository;

import demo.example.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by prayoon-pc on 5/25/2017.
 */
public interface CityRepository extends JpaRepository<City, Long> {


}
