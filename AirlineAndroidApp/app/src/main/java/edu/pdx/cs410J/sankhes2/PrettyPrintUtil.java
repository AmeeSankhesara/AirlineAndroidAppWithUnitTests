package edu.pdx.cs410J.sankhes2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PrettyPrintUtil {

    private final PrettyPrintActivity mPrettyPrintActivity;

    public PrettyPrintUtil(PrettyPrintActivity mPrettyPrintActivity) {
        this.mPrettyPrintActivity = mPrettyPrintActivity;
    }

    public String generatePrettyStringUtiliy(String [] str,  String source, String destination) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        Date departure = formatter.parse(str[3]);
        Date Arrival =  formatter.parse(str[5]);
        long duration =Arrival.getTime()-departure.getTime();
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        String content="";
        String departStr[] = (str[3].split("\\s+"));
        String arrivalStr[] = str[5].split("\\s+");
        Flight flight = new Flight(str[1].trim());
        flight.setSource(str[2].trim());
        flight.setDepartureTime(departStr[0],departStr[1],departStr[2]);
        flight.setDestination(str[4].trim());
        flight.setArrivalTime(arrivalStr[0],arrivalStr[1],arrivalStr[2]);
        if(source.length()==0 && destination.length()==0)
        {
            content = "\n"+"Airline Name = "+str[0] + "\n"
                    + "Flight Number = "+flight.getNumber() + "\n"
                    + "Flight Source Airport Code = "+ flight.getSource()+ "\n"
                    + "Flight Departure date and time = "+flight.getDepartureString() + "\n"
                    + "Flight Destination Airport Code = "+flight.getDestination() + "\n"
                    + "Flight Arrival date and time = "+flight.getArrivalString()+"\n"
                    + "Flight duration in minutes = "+diffInMinutes+"\n";
        }
        else if(source.length()!=0 && destination.length()!=0)
        {
            if(str[2].toLowerCase().equals(source.toLowerCase()) && str[4].toLowerCase().equals(destination.toLowerCase()))
            {
                content = "\n"+"Airline Name = "+str[0] + "\n"
                        + "Flight Number = "+str[1] + "\n"
                        + "Flight Source Airport Code = "+str[2] + "\n"
                        + "Flight Departure date and time = "+str[3] + "\n"
                        + "Flight Destination Airport Code = "+str[4] + "\n"
                        + "Flight Arrival date and time = "+str[5]+"\n"
                        + "Flight duration in minutes = "+diffInMinutes+"\n";
            }
        }
        else if(source.length()==0 && destination.length()!=0)
        {
            if(str[4].toLowerCase().equals(destination.toLowerCase()))
            {
                content = "\n"+"Airline Name = "+str[0] + "\n"
                        + "Flight Number = "+str[1] + "\n"
                        + "Flight Source Airport Code = "+str[2] + "\n"
                        + "Flight Departure date and time = "+str[3] + "\n"
                        + "Flight Destination Airport Code = "+str[4] + "\n"
                        + "Flight Arrival date and time = "+str[5]+"\n"
                        + "Flight duration in minutes = "+diffInMinutes+"\n";
            }
        }
        else if (source.length()!=0 && destination.length()==0)
        {
            if(str[2].toLowerCase().equals(source.toLowerCase()))
            {
                content = "\n"+"Airline Name = "+str[0] + "\n"
                        + "Flight Number = "+str[1] + "\n"
                        + "Flight Source Airport Code = "+str[2] + "\n"
                        + "Flight Departure date and time = "+str[3] + "\n"
                        + "Flight Destination Airport Code = "+str[4] + "\n"
                        + "Flight Arrival date and time = "+str[5]+"\n"
                        + "Flight duration in minutes = "+diffInMinutes+"\n";
            }
        }

        return content;
    }

}
