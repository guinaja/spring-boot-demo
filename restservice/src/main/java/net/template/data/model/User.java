package net.template.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.template.data.base.model.GenericModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Prayoon.su <prayoonsuntronktit@gmail.com>
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends GenericModel {

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String token;

    private String name;

    public User() {

    }


    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
