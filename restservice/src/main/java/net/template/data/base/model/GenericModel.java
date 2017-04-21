package net.template.data.base.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * An abstract base model class for entities
 *
 * @author Prayoon.su <prayoonsuntronktit@gmail.com>
 */
@MappedSuperclass
@Getter
@Setter
public class GenericModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private Date updatedDate;

    @PrePersist
    public void prePersist() {
        createdDate = updatedDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Date();
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + updatedDate.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericModel baseModel = (GenericModel) o;

        if (id != baseModel.id) return false;
        if (!createdDate.equals(baseModel.createdDate)) return false;
        return updatedDate.equals(baseModel.updatedDate);
    }
}