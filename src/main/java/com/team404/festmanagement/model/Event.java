package com.team404.festmanagement.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Event {
    @Id
    private String eventName;
    private String eventVenue;
    //DayTime
    private int ticketID;
    private double ticketPrice;
    private int noOfSeats;
}


