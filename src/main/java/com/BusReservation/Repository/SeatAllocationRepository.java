package com.BusReservation.Repository;

import com.BusReservation.Entity.SeatAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatAllocationRepository extends JpaRepository<SeatAllocation, Long> {

    @Query("select sa.seatName from SeatAllocation sa where sa.startingStation>=:startingStation and sa.endingStation<=:endingStation and sa.bus.id=:busId")
    List<String> findSeatNameByStatingIdAndEndingIdAnaBusId(@Param("startingStation")int startingStation, @Param("endingStation")int endingStation, @Param("busId")Long busId);

    @Query("select sa.seatName from SeatAllocation sa where sa.startingStation=:startingStation and sa.endingStation=:endingStation and sa.bus.id=:busId")
    List<String> findSeatNameBySubStatingIdAndEndingIdAnaBusId(@Param("startingStation")int startingStation, @Param("endingStation")int endingStation, @Param("busId")Long busId);

}