package com.goundicorp.travelbooking;

import com.goundicorp.travelbooking.domain.BusTicket;
import com.goundicorp.travelbooking.domain.PlainTicket;
import com.goundicorp.travelbooking.domain.TrainTicket;
import com.goundicorp.travelbooking.domain.TravelClass;
import com.goundicorp.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RegisterTravelTicket {

    public static void main(String[] args) throws InvalidTravelDurationException {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        System.out.println(" Enter 1 for Bus ticket, 2 for Trainticket or 3 plane ticket");
        option = scanner.nextInt();


        while (!(option >= 1 && option <=3)){
            System.out.println(" Enter 1 for Bus ticket, 2 for Trainticket or 3 plane ticket");
            option = scanner.nextInt();

        }
        System.out.println("Enter the booking ref");
        Long ref = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the origin");
        String origin = scanner.nextLine();

        System.out.println("Enter the destination");
        String destination = scanner.nextLine();

        System.out.println("Enter the price");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Enter the departure time");
        String dTime = scanner.nextLine();
        LocalDateTime departureTime = LocalDateTime.parse(dTime);

        System.out.println("Enter the arrival time");
        String aTime = scanner.nextLine();
        LocalDateTime arrivaltime = LocalDateTime.parse(aTime);


        switch (option){
            case 1:
                BusTicket busTicket = new BusTicket(ref,origin,destination,price,departureTime,arrivaltime,null);
                System.out.println(busTicket);
                break;
            case 2:
                System.out.println("Enter the Travel class");
                String tClass = scanner.nextLine();
                TravelClass travelClass = TravelClass.valueOf(tClass.toUpperCase());
                System.out.println("Enter the carriage number");
                int carriageNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the seat number");
                int seatNumber = scanner.nextInt();
                TrainTicket trainTicket = new TrainTicket(ref, origin,destination,price,departureTime,arrivaltime,travelClass,carriageNumber,seatNumber);
                break;
            case 3:
                System.out.println("Enter the Travel class");
                String tClass2 = scanner.nextLine();
                TravelClass travelClass2 = TravelClass.valueOf(tClass2.toUpperCase());

                System.out.println("Enter the number of Stopovers");
                int stopovers = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the seat number");
                int seatNumber2 = scanner.nextInt();

                PlainTicket plainTicket = new PlainTicket(ref, origin,destination,price,departureTime,arrivaltime,travelClass2,seatNumber2,stopovers);
                break;

        }





    }
}
