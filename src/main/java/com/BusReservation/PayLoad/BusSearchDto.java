package com.BusReservation.PayLoad;


import java.time.LocalDate;

public class BusSearchDto {
    private String fromStop;
    private String toStop;
    private LocalDate departureDate;

    public BusSearchDto(String fromStop,String toStop,LocalDate departureDate){
        this.fromStop=fromStop;
        this.toStop=toStop;
        this.departureDate=departureDate;
    }

    public String getFromStop(){
        return fromStop;
    }

    public String getToStop(){
        return toStop;
    }

    public LocalDate getDepartureDate(){
        return departureDate;
    }
}
