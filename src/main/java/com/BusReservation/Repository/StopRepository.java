package com.BusReservation.Repository;

import com.BusReservation.Entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StopRepository extends JpaRepository<Stop, Long> {

    @Query("select s.id from Stop s where s.stopName=:stopName")
    Long findStopIdByStopName(@Param("stopName")String stopName);
}