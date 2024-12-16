package com.BusReservation.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "stop_name", nullable = false)
    private String stopName;

    public Stop(){

    }

    public Stop(String stopName){
        this.stopName=stopName;
    }

    public String getStopName(){
        return stopName;
    }
}