package com.UD6_API_proba_ciclistas.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UD6_API_proba_ciclistas.app.modelo.cyclist;
import com.UD6_API_proba_ciclistas.app.repository.cyclistRepository;

@RestController
@RequestMapping("/api/cyclists")
public class CyclistController {
	
	@Autowired
	private cyclistRepository ciRepo;
	
	@GetMapping("")
	public List<cyclist> ciclistas() {
		return ciRepo.findAll();
		
	}
}
