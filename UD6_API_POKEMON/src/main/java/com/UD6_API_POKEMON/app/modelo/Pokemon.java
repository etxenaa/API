package com.UD6_API_POKEMON.app.modelo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String izena;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estatistika_id", referencedColumnName = "id")
    private Estatistika estatistika;

    @ManyToMany
    @JoinTable(
        name = "entrenatzaile_pokemon",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "entrenatzailea_id")
    )
    private Set<Entrenatzailea> entrenatzaileak = new HashSet<>();
}