package com.BusReservation.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "bus_number", nullable = false, unique = true)
    private Integer busNumber;

    public Bus(){

    }

    public Bus(String name,Integer busNumber,Long id){
        this.name=name;
        this.busNumber=busNumber;
        this.id=id;

    }
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBusNumber() {
        return busNumber;
    }
}

