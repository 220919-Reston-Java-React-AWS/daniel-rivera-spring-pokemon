package com.revature.hackathon.controller;

import com.revature.hackathon.model.*;
import com.revature.hackathon.service.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainer")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    //return list of all pokemon
    @GetMapping("/{id}/all-pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon(@PathVariable int id) {
        // if you look at Posts models, the author_id column in the database is represented using a User model
        Trainer search = new Trainer();
        search.setId(id);

        return ResponseEntity.ok(this.trainerService.getAllPokemon(search));
    }

    //add pokemon to trainer's list
    @PostMapping("/{id}/add")
    public ResponseEntity<Trainer> getAllPokemon(@RequestBody Pokemon newPokemon, @PathVariable int id) {
        // if you look at Posts models, the author_id column in the database is represented using a User model
        Trainer trainer = new Trainer();
        trainer.setId(id);
        
        //get trainers pokemon list
        List<Pokemon> trainerPokemon = this.trainerService.getAllPokemon(trainer);
        //add pokemon to list
        trainerPokemon.add(newPokemon);
        
        //set the update
        trainer.pokemons = trainerPokemon;

        //patch data
        return ResponseEntity.ok(this.trainerService.patchTrainerPokemon(trainer));
    }
}
