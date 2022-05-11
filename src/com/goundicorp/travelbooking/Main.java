package com.goundicorp.travelbooking;

import com.goundicorp.travelbooking.domain.BusTicket;
import com.goundicorp.travelbooking.domain.TrainTicket;
import com.goundicorp.travelbooking.domain.TravelClass;
import com.goundicorp.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();
        TrainTicket trainTicket2 = null;
        try {
            trainTicket2 = new TrainTicket(123L,"Dusiburg","Düsseldorf",new BigDecimal("59.00"),
                    LocalDateTime.of(2022,3,7,16,03),
                    LocalDateTime.of(2022,3,7,19,03),
                    TravelClass.FIRST, 3, 42);
            trainTicket2.upgrade();
            trainTicket2.cancel();
        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }



        String[] providers = {"Bus company 1","Bus company 2"};

        BusTicket busTicket = null;
        try {
            busTicket = new BusTicket(123L,"Dusiburg","Düsseldorf",new BigDecimal("59.00"),
                    LocalDateTime.of(2022,3,7,16,03),
                    LocalDateTime.of(2022,3,6,19,03),providers);
            busTicket.cancel();
        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }



    }

}
