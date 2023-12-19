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
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "DOI",unique = true)
    private String doi;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "publication_date", nullable = true)
    private Integer publication_date;
    @Column(name = "url", nullable = true)
    private String url;
    @Column(name = "num_citations", nullable = true)
    private Integer num_citations;
    @ManyToOne(cascade = CascadeType.ALL) //por terminar
    private Journal journal;
    @ManyToMany(cascade = CascadeType.ALL)//por revisar
    private Set<Author> authors;

    public Article() {

    }

    public Article(String doi, String title, Integer publication_date, String url, Integer num_citations, Journal journal) {
        this.doi = doi;
        this.title = title;
        this.publication_date = publication_date;
        this.url = url;
        this.num_citations = num_citations;
        this.journal = journal;
        this.authors = new HashSet<>();
    }

    public String getDoi() {
        return doi;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPublication_date() {
        return publication_date;
    }

    public String getUrl() {
        return url;
    }

    public Integer getNum_citations() {
        return num_citations;
    }

    public Journal getJournal() {
        return journal;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
