package com.UD6_API_POKEMON.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UD6_API_POKEMON.app.modelo.Entrenatzailea;
import com.UD6_API_POKEMON.app.modelo.Pokemon;
import com.UD6_API_POKEMON.app.repository.EntrenatzaileaRepository;

@RestController
@RequestMapping("/api/entrenatzailea")
public class EntrenatzaileaController {
	@Autowired EntrenatzaileaRepository entreRepo;
	
	@GetMapping
	public List<Entrenatzailea> entrenatzaileak() {
		return entreRepo.findAll();
	}
	

	@GetMapping("/{id}")
	public Optional<Entrenatzailea> getEntrenatzaileaById(@PathVariable Long id) {
		return entreRepo.findById(id);
	}
}
