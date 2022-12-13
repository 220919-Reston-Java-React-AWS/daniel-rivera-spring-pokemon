package com.revature.hackathon.respository;

import com.revature.hackathon.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;


public interface TrainerRepository extends JpaRepository<Trainer, Interger>{
    
}
