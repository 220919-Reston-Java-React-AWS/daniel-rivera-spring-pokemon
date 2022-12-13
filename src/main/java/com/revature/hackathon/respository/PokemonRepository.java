package com.revature.hackathon.respository;

import com.revature.hackathon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Interger>{
    
    @Transactional
    Optional<Pokemon> findById(Pokemon search);
}
