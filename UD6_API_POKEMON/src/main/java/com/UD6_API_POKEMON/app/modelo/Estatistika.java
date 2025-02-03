package com.UD6_API_POKEMON.app.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estatistika {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int atakea;
	private int defentsa;
	private int abiadura;

	@OneToOne(mappedBy = "estatistika")
	private Pokemon pokemon;
}