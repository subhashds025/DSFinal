package com.BusReservation.Controller;

import com.BusReservation.Repository.SeatAllocationRepository;
import com.BusReservation.Repository.StopOrderRepository;
import com.BusReservation.Repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public List<?> getStopOrder(
            @RequestParam Long busId,
            @RequestParam Long stopId,
            @RequestParam String startStationName,
            @RequestParam String lastStationName){
        Integer startStationOrderId=stoporderrepository.findStopOderByBusAnaStop(busId, stopId);

        Long lastStopId= stoprepository.findStopIdByStopName(lastStationName);

        Long startStopId= stoprepository.findStopIdByStopName(startStationName);

        Integer lastStationOrderId=stoporderrepository.findStopOderByBusAnaStop(busId, lastStopId);

        Integer firstStationOrderId=stoporderrepository.findStopOderByBusAnaStop(busId, startStopId);


       // List<List<String>> seatsBooked=new ArrayList<>();
       // if(firstStationOrderId!=startStationOrderId){
         //   for(int i=startStationOrderId;i>0;i--){
          //       seatallocationrepository.findSeatNameBySubStatingIdAndEndingIdAnaBusId(i,lastStationOrderId, busId);
          //  }
       // }

        List<List<String>> seatsBooked = new ArrayList<>();
        if (firstStationOrderId != startStationOrderId) {
            // Initialize a StringBuilder to accumulate the seat names
            StringBuilder seatNames = new StringBuilder();

            // Loop from startStationOrderId to firstStationOrderId
            for (int i = startStationOrderId; i > 0; i--) {
                // Get the seat names for the current station range
                List<String> seatNameList = seatallocationrepository.findSeatNameBySubStatingIdAndEndingIdAnaBusId(i, lastStationOrderId, busId);

                // If there are seat names, add them to the StringBuilder
                if (seatNameList != null && !seatNameList.isEmpty()) {
                    for (String seat : seatNameList) {
                        // Append each seat name, with a separator if needed (e.g., ", ")
                        if (seatNames.length() > 0) {
                            seatNames.append(", ");
                        }
                        seatNames.append(seat);
                    }
                }
            }

            // Add the final concatenated seat names string to the list (if any seats were added)
            if (seatNames.length() > 0) {
                List<String> seats = new ArrayList<>();
                seats.add(seatNames.toString());
                seatsBooked.add(seats);
            }
            return seatsBooked;
        }


       return  seatallocationrepository.findSeatNameByStatingIdAndEndingIdAnaBusId(startStationOrderId,lastStationOrderId, busId);
    }
}
