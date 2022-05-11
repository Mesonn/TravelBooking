package com.goundicorp.travelbooking.exceptions;

public class InvalidTravelDurationException extends Exception{

    public InvalidTravelDurationException(){
        super();
    }
    public InvalidTravelDurationException(String message){
        super(message);
    }

}
