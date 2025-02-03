package com.UD6_API_POKEMON.app.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Entrenatzailea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String izena;
	private int adina;

	@ManyToMany(mappedBy = "entrenatzaileak")
	private Set<Pokemon> pokemonak = new HashSet<>();
}
