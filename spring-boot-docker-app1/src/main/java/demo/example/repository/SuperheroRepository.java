package demo.example.repository;

import demo.example.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}
