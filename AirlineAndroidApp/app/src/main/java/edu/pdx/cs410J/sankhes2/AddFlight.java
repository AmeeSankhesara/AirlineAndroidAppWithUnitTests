package edu.pdx.cs410J.sankhes2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AddFlight {

    private final AddFlightActivity mFlightActivity;

    public AddFlight(AddFlightActivity mFlightActivity) {
        this.mFlightActivity = mFlightActivity;
    }

    public Flight addFlight(String flightNumber , String source , String destination , String departureTime, String arrivalTime ) {
        Flight flight = new Flight(flightNumber);
        flight.setSource(source);
        flight.setDestination(destination);
        String[] departStr = departureTime.split("\\s+");
        String[] arrivalStr = arrivalTime.split("\\s+");
        if(departStr.length!=3 || arrivalStr.length!=3)
            throw new UnsupportedOperationException("Date should be in MM/dd/yyyy hh:mm am/pm format");
        flight.setDepartureTime(departStr[0],departStr[1],departStr[2]);
        flight.setArrivalTime(arrivalStr[0],arrivalStr[1],arrivalStr[2]);
        return flight;
    }

    public Airline addAirline(Flight flight, String airlineName) {
        Airline airline = new Airline(airlineName);
        airline.addFlight(flight);
        return airline;
    }

    public void validateArrivalTime(Flight flight) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        Date depart = formatter.parse(flight.getDepartureString());
        Date Arrival =  formatter.parse(flight.getArrivalString());
        long duration =Arrival.getTime()-depart.getTime();
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        if(diffInMinutes<=0) {
            throw  new UnsupportedOperationException("Arrival time must be greater than departure time");
        }
    }

}
