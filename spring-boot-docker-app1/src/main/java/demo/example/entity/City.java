package demo.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by prayoon-pc on 5/25/2017.
 */
@Entity
@Table(name = "city")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private String population;
}
