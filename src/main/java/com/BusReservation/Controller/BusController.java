package com.BusReservation.Controller;

import com.BusReservation.Entity.Bus;
import com.BusReservation.PayLoad.BusSearchDto;
import com.BusReservation.Repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusRepository busrepository;

    @PostMapping("/add")
    public Bus addBus(@RequestBody Bus bus){
       return busrepository.save(bus);
    }


    @GetMapping
    public List<Bus> getBus(@RequestBody BusSearchDto dto){
      return busrepository.findBusByStopName(dto.getFromStop(), dto.getToStop(), dto.getDepartureDate());
    }

    @GetMapping("/dateandtime")
    public List<Bus> getBusByDateAndTime(
            @RequestParam LocalDate date,
            @RequestParam LocalTime time){
       return busrepository.findBusByDateAndTime(date,time);
    }
}
