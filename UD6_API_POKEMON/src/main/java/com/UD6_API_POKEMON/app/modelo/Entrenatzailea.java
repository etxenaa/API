package com.UD6_API_POKEMON.app.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Getter
@Setter
public class Entrenatzailea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String izena;
	private int adina;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "entrenatzaileak")
	private Set<Pokemon> pokemonak = new HashSet<>();
	
	@JsonProperty("pokemon_izena")
	public String getPokeIzenak() {
		String itzuli = "";
		for (Pokemon p : pokemonak) {
			if (itzuli != "") 
				itzuli += ",";
			itzuli += p.getIzena();
		}
		return itzuli;
	}
}
