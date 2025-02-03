package com.UD6_API_POKEMON.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UD6_API_POKEMON.app.modelo.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
