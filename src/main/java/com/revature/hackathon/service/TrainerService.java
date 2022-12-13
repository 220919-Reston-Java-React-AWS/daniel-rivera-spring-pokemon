package com.revature.hackathon.service;

import com.revature.hackathon.model.*;
import com.revature.hackathon.respository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import java.util.Optional;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public Optional<Pokemon> getAPokemonById(Pokemon search){
        return this.pokemonRepository.findById(search);
    }

    //return list of pokemon
    public Trainer getAllPokemon(Trainer search){
        return this.trainerRepository.findById(search);
    }

    //update pokemon level
    public Trainer patchTrainerPokemon(Trainer update){
        return this.trainerRepository.saveAndFlush(update);
    }
}
