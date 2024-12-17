package com.BusReservation.Repository;

import com.BusReservation.Entity.StopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StopOrderRepository extends JpaRepository<StopOrder, Long> {

    @Query("select so.stopOrder from StopOrder so where so.bus.id=:busId and so.stop.id=:stopId")
    Integer findStopOderByBusAnaStop(@Param("busId")Long busId, @Param("stopId")Long stopId);

}