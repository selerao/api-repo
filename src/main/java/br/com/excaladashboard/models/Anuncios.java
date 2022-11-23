package br.com.excaladashboard.models;

import javax.persistence.*;
import java.util.List;

public class Anuncios {
    @Entity
    @Table(name = "anuncios")
    public class ConjuntoAnuncios {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncios")
        private List<Anuncios> anunciosList;

    }
