package com.mitt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Movie {

   final ArrayList<String> movieName=new ArrayList<>();
   final ArrayList<String> showTime=new ArrayList<>();
    Scanner s=new Scanner(System.in);
    public Movie() {
        movieName.add("Made in China");
        movieName.add("Bala");
        movieName.add("War");
        movieName.add("Ujda Chaman");
        showTime.add("3:00 PM");
        showTime.add("6:00 PM");
    }
    private void displayMovie()
    {
        for(int i=0;i<movieName.size();i++)
        {
            System.out.println(i+1+". "+movieName.get(i));
        }
    }
    private void displaySHowTime()
    {
        for(int i=0;i<showTime.size();i++)
        {
            System.out.println(i+1+". "+showTime.get(i));
        }
    }
  private ArrayList<String> updateSeat(String fileName)
  {
      Seat1 seat=new Seat1(fileName);
      seat.read();
      seat.display();
      int noOfSeats=0;
       ArrayList<String> seatChoice=new ArrayList<>();
      System.out.print("Enter the no. of seats you want to book: ");
int x=0;
do {
    try{
        noOfSeats = s.nextInt();
        x=1;
    }
    catch (Exception e)
    {
        System.out.print("You should enter an integer\nEnter again: ");
        s.nextLine();
    }

}while (x==0);

                  s.nextLine();
                  if (noOfSeats < 1) {
                      System.out.println("You should select atleast one seat");
                      while (noOfSeats < 1) {
                          noOfSeats = s.nextInt();
                          s.nextLine();
                      }

              }


      for(int i=0;i<noOfSeats;i++)
      {
          System.out.println("Enter your seat from the available seats (which are not X)");
          String seatBooked=s.nextLine();

          if(seatChoice.contains(seatBooked)) {
              while (seatChoice.contains(seatBooked)) {
                  System.out.println("Seat already booked");
                  System.out.println("Enter different seat");
                  seatBooked = s.nextLine();
                  seatChoice.add(seatBooked);
              }
          }
          else
          {
              seatChoice.add(seatBooked);
          }

          char r=seatChoice.get(i).charAt(0);
          int row;
          if((int)r>=97)
          {
              row=((int)r)-97;
          }
          else
          {
              row=((int)r)-65;
          }
          int seatNo = Integer.parseInt(seatChoice.get(i).replaceAll("[^0-9]", ""));
          seatNo--;
          if(seat.seat[row][seatNo]==1)
          {
              System.out.print("\nThe seat is already booked\nPlease enter again\n");
              updateSeat(fileName);
          }
          else
          {
              seat.seat[row][seatNo]=1;
          }

      }

        seat.write();
      System.out.println("Your seat is booked successfully");
      System.out.println("Total amount is "+300*noOfSeats);
      return seatChoice;
  }
  private void exit()
  {
      System.out.println("Hope you had a nice experience");
      return;
  }

  private void bookTicket(Ticket ticket,String name, String contactNo, String movieName, String showTIme, ArrayList<String> tickets, String bookingID)
  {
      try {
          File file=new File("Tickets.txt");
          file.createNewFile();
          FileOutputStream f=new FileOutputStream(file,true);
          ObjectOutputStream o=new ObjectOutputStream(f);
          o.writeObject(ticket);
          o.close();
          f.close();
      }
    catch (Exception e)
    {
        System.out.println(e.toString());
    }
  }

  private void makeTicket(String name, String contactNo, String movieName, String showTIme, ArrayList<String> tickets, String bookingID)
  {
      Ticket ticket=new Ticket(name,contactNo,movieName,showTIme,tickets,bookingID);
      bookTicket(ticket,name,contactNo,movieName,showTIme,tickets,bookingID);
  }


  private void booking()
  {
      System.out.print("Enter your full name: ");
      s.nextLine();
      String name=s.nextLine();
      System.out.print("Enter your contact number: ");
      String contactNo=s.nextLine();

      displayMovie();
      System.out.print("Enter your choice: ");
      int x=0;
      int movieChoice=0;
      do {
          try{
               movieChoice = s.nextInt();
              x=1;
          }
          catch (Exception e)
          {
              System.out.print("You should enter an integer\nEnter again: ");
              s.nextLine();
          }

      }while (x==0);
      while(movieChoice<1||movieChoice>4)
      {
          System.out.print("Invalid Input\nPlease Enter again: ");
          movieChoice=s.nextInt();
      }
      if(movieChoice>=1&&movieChoice<=4)
      {
          System.out.println("The showtimes are");
          displaySHowTime();
      }
      System.out.print("Enter your choice: ");
      int showTimeChoice=0;
       x=0;
      do {
          try{
              showTimeChoice = s.nextInt();
              x=1;
          }
          catch (Exception e)
          {
              System.out.print("You should enter an integer\nEnter again: ");
              s.nextLine();
          }

      }while (x==0);
      while(showTimeChoice<1||showTimeChoice>2)
      {
          System.out.print("Invalid Input\nPlease Enter again: ");
          showTimeChoice=s.nextInt();
      }
      ArrayList<String> seatNumber=new ArrayList<>();
      String movieName="",showTime="";
      if(movieChoice==1)
      {
          movieName="Made in China";
          if(showTimeChoice==1){
              seatNumber=updateSeat("Seat1.txt");
              showTime="3:00 PM";
          }
          else if(showTimeChoice==2)
          {
              seatNumber=updateSeat("Seat2.txt");
              showTime="6:00 PM";
          }
      }
      else if(movieChoice==2)
      {
          movieName="Bala";
          if(showTimeChoice==1){
              seatNumber=updateSeat("Seat3.txt");
              showTime="3:00 PM";
          }
          else if(showTimeChoice==2)
          {
              seatNumber=updateSeat("Seat4.txt");
              showTime="6:00 PM";
          }
      }
      else if(movieChoice==3)
      {
          movieName="War";
          if(showTimeChoice==1){
              seatNumber=updateSeat("Seat5.txt");
              showTime="3:00 PM";
          }
          else if(showTimeChoice==2)
          {
              seatNumber=updateSeat("Seat6.txt");
              showTime="6:00 PM";

          }
      }
      else if(movieChoice==4)
      {
          movieName="Ujda Chaman";
          if(showTimeChoice==1){
              seatNumber=updateSeat("Seat7.txt");
              showTime="3:00 PM";
          }
          else if(showTimeChoice==2)
          {
              seatNumber=updateSeat("Seat8.txt");
              showTime="6:00 PM";
          }
      }
      String bookingID="";
      try {
          bookingID="RT"+seatNumber.get(0)+name.charAt(0)+name.charAt(1)+name.charAt(name.length()-1)+name.charAt(name.length()-2)+contactNo.charAt(contactNo.length()-4)+contactNo.charAt(contactNo.length()-3)+contactNo.charAt(contactNo.length()-2)+contactNo.charAt(contactNo.length()-1);
      }
      catch (Exception e)
      {
          bookingID="RT"+seatNumber.get(0);
      }

      System.out.println("Your Booking ID is "+bookingID);
      System.out.println("Please note this ID to view or cancel your booking");

      makeTicket(name,contactNo,movieName,showTime,seatNumber,bookingID);
      bookingChoice();
  }

  private void bookingChoice()
  {
      System.out.print("\n1. Book another ticket\n2. Go back\n3. Exit \nEnter: ");
      int goBack=0;
      int x=0;
      do {
          try{
              goBack = s.nextInt();
              x=1;
          }
          catch (Exception e)
          {
              System.out.print("You should enter an integer\nEnter again: ");
              s.nextLine();
          }

      }while (x==0);
      if(goBack<1||goBack>3)
      {
          System.out.println("Enter 1 or 2\nEnter again: ");
          goBack=s.nextInt();
          while(goBack!=1||goBack!=2||goBack!=3)
          {
              System.out.println("Enter between 1 and 3\nEnter again: ");
              goBack=s.nextInt();
          }
      }
      if(goBack==1)
      {
          booking();
      }
      else if (goBack==2)
          display();
      else if (goBack==3)
          exit();
  }
  private void viewBooking()
  {
      s.nextLine();
      System.out.println("Enter your booking id");
      String checkID=s.nextLine();
      int c=0;
      try
      {
          FileInputStream fi = new FileInputStream(new File("Tickets.txt"));

          if(fi.available()<0)
              System.out.println("No Bookings");
          while(fi.available()>0)
          {
              ObjectInputStream oi = new ObjectInputStream(fi);
              Ticket t=(Ticket)oi.readObject();
              if(!t.bookingID.equals(".")&&t.bookingID.equals(checkID))
              {
                  c++;
                  System.out.println("Name: "+t.name);
                  System.out.println("Contact Number: "+t.contactNo);
                  System.out.println("Movie Name: "+t.movieName);
                  System.out.println("Show Time: "+t.showTime);
                  System.out.println("Tickets: ");
                  for(int j=0;j<t.tickets.size();j++)
                  {
                      System.out.print(t.tickets.get(j)+" ");
                  }
              }

          }
          if(c==0) {
              System.out.println("Booking id not found");
          }

          fi.close();
      }
      catch (Exception e)
      {
          System.out.println(e.toString());
      }
viewBookingChoice();
  }

  private void viewBookingChoice()
  {
      System.out.print("\n1. Enter another Booking ID\n2. Go back\n3. Exit \nEnter: ");
      int goBack=0;
      int x=0;
      do {
          try{
              goBack = s.nextInt();
              x=1;
          }
          catch (Exception e)
          {
              System.out.print("You should enter an integer\nEnter again: ");
              s.nextLine();
          }

      }while (x==0);
      if(goBack<1||goBack>3)
      {
          System.out.println("Enter 1 or 2\nEnter again: ");
          goBack=s.nextInt();
          while(goBack!=1||goBack!=2||goBack!=3)
          {
              System.out.println("Enter between 1 and 3\nEnter again: ");
              goBack=s.nextInt();
          }
      }
      if(goBack==1)
      {
          viewBooking();
      }
      else if (goBack==2)
          display();
      else if (goBack==3)
          exit();

  }
  private void cancelBooking()
  {
      String checkID;
      int c;
      s.nextLine();
      System.out.println("Enter your booking id");
      checkID=s.nextLine();

      try
      {
          FileInputStream fi = new FileInputStream(new File("Tickets.txt"));
          if(fi.available()<0)
              System.out.println("No Bookings");
          c=0;
          while(fi.available()>0)
          {
              ObjectInputStream oi = new ObjectInputStream(fi);
              Ticket t=(Ticket)oi.readObject();
              if(t.bookingID.equals(checkID))
              {
                  c++;
                  System.out.println("Name: "+t.name);
                  System.out.println("Contact Number: "+t.contactNo);
                  System.out.println("Movie Name: "+t.movieName);
                  System.out.println("Show Time: "+t.showTime);
                  System.out.print("Tickets: ");
                  for(int j=0;j<t.tickets.size();j++)
                  {
                      System.out.print(t.tickets.get(j)+" , ");
                  }
                  System.out.println("Are you sure you want to cancel the booking");
                  String ans=s.nextLine();
                  if(ans.equals("yes"))
                  {
                      t.bookingID=".";
                      t.name=".";
                      t.contactNo=".";
                      FileOutputStream f=new FileOutputStream(new File("Tickets.txt"),true);
                      ObjectOutputStream o=new ObjectOutputStream(f);
                      o.writeObject(t);
                      o.close();
                      for(int i=0;i<t.tickets.size();i++)
                      {
                          String s=t.tickets.get(i);
                          char r=s.charAt(0);
                          int row;
                          if((int)r>=97)
                          {
                              row=((int)r)-97;
                          }
                          else
                          {
                              row=((int)r)-65;
                          }
                          int seatNo = Integer.parseInt(s.replaceAll("[^0-9]", ""));
                          seatNo--;
                          if(t.movieName.equals("Made in China"))
                          {
                              if(t.showTime.equals("3:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat1.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                              else if(t.showTime.equals("6:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat2.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                          }

                          else if(t.movieName.equals("Bala"))
                          {
                              if(t.showTime.equals("3:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat3.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                              else if(t.showTime.equals("6:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat4.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                          }

                          else if(t.movieName.equals("War"))
                          {
                              if(t.showTime.equals("3:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat5.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                              else if(t.showTime.equals("6:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat6.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                          }

                          else if(t.movieName.equals("Ujda Chaman"))
                          {
                              if(t.showTime.equals("3:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat7.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                              else if(t.showTime.equals("6:00 PM"))
                              {
                                  Seat1 seat=new Seat1("Seat8.txt");
                                  seat.read();
                                  seat.seat[row][seatNo]=0;
                                  seat.write();
                              }
                          }

                      }
                      System.out.println("Booking cancelled successfully");
                  }
              }


          }
          if(c==0)
          {
              System.out.println("Booking ID not found");
          }

          fi.close();
      }
      catch (Exception e)
      {
          System.out.println(e.toString());
      }
cancelBookingChoice();
  }

  private void cancelBookingChoice()
  {
      System.out.print("\n1. Cancel another booking\n2. Go back\n3. Exit \nEnter: ");
     int goBack=0;
      int x=0;
      do {
          try{
              goBack = s.nextInt();
              x=1;
          }
          catch (Exception e)
          {
              System.out.print("You should enter an integer\nEnter again: ");
              s.nextLine();
          }

      }while (x==0);
      if(goBack<1||goBack>3)
      {
          System.out.println("Enter between 1 and 3\nEnter again: ");
          goBack=s.nextInt();
          while(goBack!=1||goBack!=2||goBack!=3)
          {
              System.out.println("Enter between 1 and 3\nEnter again: ");
              goBack=s.nextInt();
          }
      }
      if(goBack==1)
      {
          cancelBooking();
      }
      else if (goBack==2)
          display();
      else if (goBack==3)
          exit();
  }
    public void display()
    {

        System.out.println("Welcome to The Royal Cinema");
        System.out.println("----------------------------");
        System.out.println("1. Book Tickets");
        System.out.println("2. View bookings");
        System.out.println("3. Cancel Bookings");
        System.out.println("4. Exit");
        System.out.print("Enter: ");
        int choice=0;

        boolean a=false;
        do {
            int x=0;
            do {
                try{
                    choice = s.nextInt();
                    x=1;
                }
                catch (Exception e)
                {
                    System.out.print("You should enter an integer\nEnter again: ");
                    s.nextLine();
                }

            }while (x==0);

            switch (choice)
            {
                case 1:
                    booking();
                    break;
                case 2:
                    viewBooking();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.print("Please watch out for the choice entered\nEnter again: ");
                    a=true;
            }
        }while(a);
    }
}
