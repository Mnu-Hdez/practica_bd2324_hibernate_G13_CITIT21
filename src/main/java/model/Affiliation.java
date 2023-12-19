package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// @TODO Realiza todas las anotaciones necesarias en esta clase para que
// que sus instancias sean guardadas en la base de datos utilizando
// Hibernate. Respecta las restricciones de modelado impuestas en el
// enunciado de la práctica. No es necesario modificar el código de esta
// clase, únicamente debes hacer las anotaciones que consideres
// necesarias.

//revisar
@Entity
@Table(name = "affiliation")
public class Affiliation {

    @Id
    @Column(name = "affiliation_id",unique = true)
    private Long affiliation_id;
    @Column(name = "affiliation_name", nullable = false)
    private String affiliation_name;
    @Column(name = "city", nullable = true)
    private String city;
    @Column(name = "country_name", nullable = true)
    private String country_name;
    @ManyToMany(mappedBy = "affiliations", cascade = CascadeType.ALL)//affiliation revisa a los autores
    private Set<Author> authors;

    public Affiliation() {

    }

    public Affiliation(String affiliation_name, String city, String country_name) {
        this.affiliation_name = affiliation_name;
        this.city = city;
        this.country_name = country_name;
        this.authors = new HashSet<>();
    }

    public Long getAffiliation_id() {
        return affiliation_id;
    }

    public String getAffiliation_name() {
        return affiliation_name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry_name() {
        return country_name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
