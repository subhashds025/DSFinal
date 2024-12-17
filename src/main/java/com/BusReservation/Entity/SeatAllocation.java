package com.BusReservation.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seat_allocation")
public class SeatAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "starting_station", nullable = false)
    private Integer startingStation;

    @Column(name = "ending_station", nullable = false)
    private Integer endingStation;

    @Column(name = "seat_name", nullable = false)
    private String seatName;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

}