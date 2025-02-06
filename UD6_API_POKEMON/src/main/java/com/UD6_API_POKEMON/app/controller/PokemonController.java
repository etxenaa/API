package com.UD6_API_POKEMON.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UD6_API_POKEMON.app.modelo.Pokemon;
import com.UD6_API_POKEMON.app.repository.PokemonRepository;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

	@Autowired
	PokemonRepository poRepo;

	@GetMapping({"", "/"})
	public ResponseEntity<?> pokemon() {
		List<Pokemon> pokemonList = poRepo.findAll();
		if(poRepo.findAll().isEmpty()) {
			return new ResponseEntity<String>("Ez da pokemonik existitzen", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(pokemonList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPokemonById(@PathVariable Long id) {
		Optional<Pokemon> poke = poRepo.findById(id);
		if (poke.isEmpty()) {
			return new ResponseEntity<String>("Ez da Id hori duen pokemonik existitzen", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(poke);
	}

	@PostMapping("/new")
	public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
		poRepo.save(pokemon);
		return new ResponseEntity<>("Pokemona ongi sortu da", HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePokemon(@PathVariable Long id) {
		poRepo.deleteById(id);
		return new ResponseEntity<>("Pokemona ezabatu da", HttpStatus.OK);
	}
}
