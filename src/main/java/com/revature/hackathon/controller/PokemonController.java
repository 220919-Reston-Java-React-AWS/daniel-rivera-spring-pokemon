package com.revature.hackathon.controller;

import com.revature.hackathon.model.*;
import com.revature.hackathon.service.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }
    
    // get a pokemon with id
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getAPokemonById(@PathVariable int id) {
        // if you look at Posts models, the author_id column in the database is represented using a User model
        Pokemon search = new Pokemon();
        search.setId(id);

        return ResponseEntity.ok(this.pokemonService.getAPokemonById(search).get());
    }

    //return list of all pokemon
    @GetMapping("/all-pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        return ResponseEntity.ok(this.pokemonService.getAllPokemon());
    }

    //add a pokemon
    @PostMapping("/add-pokemon")
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon newPokemon)
    {
        Pokemon registerPokemon = new Pokemon(0,
            newPokemon.numId,
            newPokemon.name,
            newPokemon.level,
            newPokemon.image
        );

        pokemonService.addPokemon(registerPokemon);


        // return the user as it was originally
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //delete a pokemon
    @DeleteMapping("/delete-pokemon")
    public ResponseEntity patchLevelData(@RequestBody Pokemon deletePokemon){
        return ResponseEntity.ok(this.pokemonService.deletePokemonData(deletePokemon));
    }

    //update a pokemon level
    @PatchMapping("/update-level")
    public ResponseEntity patchLevelData(@RequestBody Pokemon update){
        return ResponseEntity.ok(this.profileService.patchLevelData(update));
    }
}
