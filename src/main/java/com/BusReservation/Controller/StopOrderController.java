package com.BusReservation.Controller;

import com.BusReservation.Repository.SeatAllocationRepository;
import com.BusReservation.Repository.StopOrderRepository;
import com.BusReservation.Repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stoporder")
public class StopOrderController {

    @Autowired
    private StopOrderRepository stoporderrepository;

    @Autowired
    private SeatAllocationRepository seatallocationrepository;

    @Autowired
    private StopRepository stoprepository;
    @GetMapping
    public List<String> getStopOrder(
            @RequestParam Long busId,
            @RequestParam Long stopId,
            @RequestParam String lastStationName){
        Integer startStationOrderId=stoporderrepository.findStopOderByBusAnaStop(busId, stopId);

        Long lastStopId= stoprepository.findStopIdByStopName(lastStationName);

        Integer lastStationOrderId=stoporderrepository.findStopOderByBusAnaStop(busId, lastStopId);

       return  seatallocationrepository.findSeatNameByStatingIdAndEndingIdAnaBusId(startStationOrderId,lastStationOrderId, busId);
    }
}
