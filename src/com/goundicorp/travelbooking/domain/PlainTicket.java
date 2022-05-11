package com.goundicorp.travelbooking.domain;

import com.goundicorp.travelbooking.exceptions.InvalidTravelDurationException;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PlainTicket extends TravelTicket{
    private TravelClass travelClass;
    private Integer seatNumber;
    private Integer stopOvers;


    public PlainTicket(){
        super();
    }

    public PlainTicket(long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime, TravelClass travelClass, Integer seatNumber, Integer stopOvers) throws InvalidTravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.travelClass = travelClass;
        this.seatNumber = seatNumber;
        this.stopOvers = stopOvers;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(Integer stopOvers) {
        this.stopOvers = stopOvers;
    }

    public void upgrade(){

        super.setPrice(getPrice().multiply(new BigDecimal("2")));
        System.out.println("you have been upgraded");
    }

    public void addStopOver(){
        stopOvers++;
        System.out.println("You have"+ stopOvers +"Stopovers");

    }

    @Override
    public String toString() {
        return "PlainTicket{" +
                "travelClass=" + travelClass +
                ", seatNumber=" + seatNumber +
                ", stopOvers=" + stopOvers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlainTicket that = (PlainTicket) o;
        return Objects.equals(travelClass, that.travelClass) && Objects.equals(seatNumber, that.seatNumber) && Objects.equals(stopOvers, that.stopOvers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), travelClass, seatNumber, stopOvers);
    }
}
