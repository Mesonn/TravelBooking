package com.goundicorp.travelbooking.domain;

import com.goundicorp.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class BusTicket extends TravelTicket{
    private String[] permittedProviders;

    public BusTicket(){
        super();
    }

    public BusTicket(long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime, String[] permittedProviders) throws InvalidTravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.permittedProviders = permittedProviders;
    }

    public String[] getPermittedProviders() {
        return permittedProviders;
    }

    public void setPermittedProviders(String[] permittedProviders) {
        this.permittedProviders = permittedProviders;
    }

    @Override
    public void cancel() {
        Duration d = Duration.between(LocalDateTime.now(),getDepartureTime());
        long days = d.toDays();
        if(days > 30){
            super.cancel();
        }
        else{
            System.out.println( "sorry you cant cancel your Ticket");
        }

        }

    @Override
    public String toString() {
        return "BusTicket{" +
                "permittedProviders=" + Arrays.toString(permittedProviders) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusTicket busTicket = (BusTicket) o;
        return Arrays.equals(permittedProviders, busTicket.permittedProviders);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(permittedProviders);
        return result;
    }
}
