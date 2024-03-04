package com.local24.crud.example.service;

import com.local24.crud.example.entity.Train;
import com.local24.crud.example.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository repository;

    public Train saveTrain(Train train) {
        return repository.save(train);
    }

    public List<Train> saveTrains(List<Train> trains) {
        return repository.saveAll(trains);
    }

    public List<Train> getTrains() {
        return repository.findAll();
    }

    public Train getTrainById(int number) {
        return repository.findById(number).orElse(null);
    }

    public Train getTrainByName(String name) {
        return repository.findByName(name);
    }

    public String deleteTrain(int number) {
        repository.deleteById(number);
        return "Train removed !! " + number;
    }

    public Train updateTrain(Train train) {
        Train existingTrain = repository.findById(train.getNumber()).orElse(null);
        existingTrain.setName(train.getName());
        existingTrain.setStations(train.getStations());
        return repository.save(existingTrain);
    }

    public List<Train> findRelevantTrains(String src, String dst){
        List<Train> result=new ArrayList<>();
        List<Train> allTrains=repository.findAll();
        for(Train train: allTrains){
            List<String> stationsList = Arrays.asList(train.getStations().split(","));
            int sourceIndex = stationsList.indexOf(src);
            int destinationIndex = stationsList.indexOf(dst);
            if(sourceIndex<destinationIndex)
                result.add(train);
        }
        return result;
    }

}
