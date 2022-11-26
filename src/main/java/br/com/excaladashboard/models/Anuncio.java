package br.com.excaladashboard.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "anuncios")
public class Anuncio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name", length = 256)
        private String name;

        @ManyToOne
        @JoinColumn(name="campanha_id", nullable=false)
        private Campanha campanha;

    }
