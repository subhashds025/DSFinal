package com.BusReservation.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "stop_order")
public class StopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @Column(name = "stop_order", nullable = false)
    private Integer stopOrder;

    @Column(name="departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name="departure_time", nullable = false)
    private LocalTime departureTime;
    public StopOrder(){

    }

    public StopOrder(Bus bus,Stop stop,Integer stopOrder,LocalDate departureDate,LocalTime departureTime) {
        this.bus = bus;
        this.stop=stop;
        this.stopOrder=stopOrder;
        this.departureDate=departureDate;
        this.departureTime=departureTime;
    }

    public Bus getBus(){
        return bus;
    }

    public Stop getStop(){
        return stop;
    }

    public Integer getStopOrder(){
        return stopOrder;
    }
    public LocalDate getDepartureDate(){
        return departureDate;
    }

    public LocalTime getDepartureTime(){
        return departureTime;
    }
}