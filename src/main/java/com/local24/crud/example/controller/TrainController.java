package com.local24.crud.example.controller;

import com.local24.crud.example.entity.Train;
import com.local24.crud.example.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private TrainService service;

    @PostMapping("/addTrain")
    public Train addTrain(@RequestBody Train train) {
        return service.saveTrain(train);
    }

    @PostMapping("/addTrains")
    public List<Train> addTrains(@RequestBody List<Train> trains) {
        return service.saveTrains(trains);
    }

    @GetMapping("/Trains")
    public List<Train> findAllTrains() {
        return service.getTrains();
    }

    @GetMapping("/trainById/{number}")
    public Train findTrainById(@PathVariable int number) {
        return service.getTrainById(number);
    }

    @GetMapping("/trainByName/{name}")
    public Train findTrainByName(@PathVariable String name) {
        return service.getTrainByName(name);
    }

    @PutMapping("/update")
    public Train updateTrain(@RequestBody Train train) {
        return service.updateTrain(train);
    }

    @DeleteMapping("/delete/{number}")
    public String deleteTrain(@PathVariable int number) {
        return service.deleteTrain(number);
    }
    @GetMapping("/searchTrains")
    public List<Train> findTrains(@RequestParam String Source,@RequestParam String Destination) {
        return service.findRelevantTrains(Source,Destination);
    }
}
