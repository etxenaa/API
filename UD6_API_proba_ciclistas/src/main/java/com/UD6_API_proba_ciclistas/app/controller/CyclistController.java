package com.UD6_API_proba_ciclistas.app.controller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UD6_API_proba_ciclistas.app.modelo.cyclist;
import com.UD6_API_proba_ciclistas.app.repository.cyclistRepository;

@RestController
@RequestMapping("/api/cyclists")
public class CyclistController {

	@Autowired
	private cyclistRepository ciRepo;

	@GetMapping({ "/", "" })
	public List<cyclist> ciclistas() {
		return ciRepo.findAll();

	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editCyclist(@PathVariable Long id, @RequestBody cyclist ciclistaBerria) {
		Optional<cyclist> ciclistaOptional = ciRepo.findById(id);
		if (id == null) {
			return new ResponseEntity<>("Eguneraketa ezin da burutu, id bat jarri behar duzu", HttpStatus.NOT_FOUND);
		}
		if (ciclistaOptional.isEmpty()) {
			return new ResponseEntity<>("Emandako id-arekin ez da cyclistik aurkitu", HttpStatus.NOT_FOUND);
		}

		cyclist ciclista = ciclistaOptional.get();

		ciclista.setFirstName(ciclistaBerria.getFirstName());
		ciclista.setLastName(ciclistaBerria.getLastName());
		ciclista.setBirthDate(ciclistaBerria.getBirthDate());
		ciclista.setNationality(ciclistaBerria.getNationality());

		if (ciclistaBerria.getTeam() != null) {
			ciclista.setTeam(ciclistaBerria.getTeam());
		}

		ciRepo.save(ciclista);

		return new ResponseEntity<>("Eguneraketa burutu da", HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<String> newCyclist(@RequestBody cyclist ciclistaBerria) {

		ciRepo.save(ciclistaBerria);
		return new ResponseEntity<String>("Ciclista ondo sortu da", HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCyclist(@PathVariable Long id) {
		Optional<cyclist> ciclistaOptional = ciRepo.findById(id);

		if (ciclistaOptional.isEmpty()) {
			return new ResponseEntity<>("Emandako id-arekin ez da cyclistik aurkitu", HttpStatus.NOT_FOUND);
		}

		ciRepo.delete(ciclistaOptional.get());
		return new ResponseEntity<>("Ezabatu da ciclista", HttpStatus.OK);
	}

}
