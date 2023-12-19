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
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "author_id",unique = true)
    private Long author_id;
    @Column(name = "author_name", nullable = false) //cascade??
    private String author_name;
    @Column(name = "importance", nullable = true)
    private Double importance;
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)//revisar
    @JoinTable(name = "author_article")//revisar
    private Set<Article> articles;
    //que es mappedBy?
    @ManyToMany(cascade = CascadeType.ALL)//revisar lo del parentesis
    @JoinTable(name = "author_affiliation")//revisar
    private Set<Affiliation> affiliations;

    public Author() {

    }

    public Author(String author_name, double importance) {
        this.author_name = author_name;
        this.importance = importance;
        this.articles = new HashSet<>();
        this.affiliations = new HashSet<>();
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public Double getImportance() {
        return importance;
    }

    public Set<Affiliation> getAffiliations () {
        return this.affiliations;
    }

    public Set<Article> getArticles () {
        return this.articles;
    }
}
