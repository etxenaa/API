package com.UD6_API_POKEMON.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping
	public List<Pokemon> pokemon() {
		return poRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Pokemon> getPokemonById(@PathVariable Long id) {
		return poRepo.findById(id);
	}

	@PostMapping
	public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
		return poRepo.save(pokemon);
	}

	@DeleteMapping("/{id}")
	public void deletePokemon(@PathVariable Long id) {
		poRepo.deleteById(id);
	}
}
