package com.mitt;

import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable {
    String name,contactNo;
    String movieName,showTime;
    ArrayList<String> tickets;
   String bookingID;

    public Ticket(String name, String contactNo, String movieName, String showTime, ArrayList<String> tickets,String bookingID) {
        this.name = name;
        this.contactNo = contactNo;
        this.movieName = movieName;
        this.showTime = showTime;
        this.tickets = tickets;
        this.bookingID = bookingID;
    }
}
