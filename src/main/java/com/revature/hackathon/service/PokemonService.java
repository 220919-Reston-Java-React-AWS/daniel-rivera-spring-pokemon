package com.revature.hackathon.service;

import com.revature.hackathon.model.*;
import com.revature.hackathon.respository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import java.util.Optional;

@Service
public class PokemonService {
    
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public Optional<Pokemon> getAPokemonById(Pokemon search){
        return this.pokemonRepository.findById(search);
    }

    //return list of pokemon
    public List<Pokemon> getAllPokemon(){
        return this.pokemonRepository.findAll();
    }


    //add a pokemon
    public Pokemon addPokemon(Pokemon registerPokemon){
        return this.pokemonRepository.save(registerPokemon);
    }

    //delete a pokemon
    public void deletePokemonData(Pokemon deletePokemon){
        this.pokemonRepository.delete(deletePokemon);
    }

    //update pokemon level
    public Pokemon patchLevelData(Pokemon update){
        return this.pokemonRepository.saveAndFlush(update);
    }
}
