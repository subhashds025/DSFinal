package com.BusReservation.Repository;

import com.BusReservation.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    @Query("""
    SELECT b FROM Bus b 
    JOIN StopOrder so1 ON b.id = so1.bus.id 
    JOIN Stop s1 ON so1.stop.id = s1.id 
    JOIN StopOrder so2 ON b.id = so2.bus.id 
    JOIN Stop s2 ON so2.stop.id = s2.id 
    WHERE s1.stopName = :fromStop 
    AND s2.stopName = :toStop
    OR so1.departureDate=:departureDate
""")
    List<Bus> findBusByStopName(@Param("fromStop")String fromStop, @Param("toStop")String toStop, @Param("departureDate")LocalDate departureDate);


    @Query("select b from Bus b JOIN StopOrder so on b.id=so.bus.id WHERE so.departureDate=:date AND so.departureTime=:time")
    List<Bus> findBusByDateAndTime(@Param("date")LocalDate date, @Param("time")LocalTime time);
}