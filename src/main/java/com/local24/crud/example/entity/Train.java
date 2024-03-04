package com.local24.crud.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.local24.crud.example.utils.StationsDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRAIN_TBL")
public class Train {

    @Id
    private int number;
    private String name;
    @JsonDeserialize(using = StationsDeserializer.class)
    @Column(length = 1000) // Adjust the length based on your requirement
    private String stations;
}
