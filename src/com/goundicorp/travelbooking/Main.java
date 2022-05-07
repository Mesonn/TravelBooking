package com.goundicorp.travelbooking;

import com.goundicorp.travelbooking.domain.BusTicket;
import com.goundicorp.travelbooking.domain.TrainTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();
        TrainTicket trainTicket2 = new TrainTicket(123L,"Dusiburg","Düsseldorf",new BigDecimal("59.00"),
                LocalDateTime.of(2022,3,7,16,03),
                LocalDateTime.of(2022,3,7,19,03),
                1, 3, 42);

        trainTicket2.upgrade();

        String[] providers = {"Bus company 1","Bus company 2"};

        BusTicket busTicket = new BusTicket(123L,"Dusiburg","Düsseldorf",new BigDecimal("59.00"),
                LocalDateTime.of(2022,3,30,16,03),
                LocalDateTime.of(2022,3,7,19,03),providers);

        trainTicket2.cancel();
        busTicket.cancel();
    }

}
