package com.local24.crud.example.repository;

import com.local24.crud.example.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Integer> {
    Train findByName(String name);
}

