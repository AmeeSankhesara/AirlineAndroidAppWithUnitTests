package edu.pdx.cs410J.sankhes2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link Flight} class.
 */
public class FlightTest
{
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getFlightNumber() {
        Flight flight = new Flight("115");
        assertThat(flight.getNumber(),equalTo(115));
    }

    @Test
    public void getAirlineName()
    {
        Airline airline = new Airline("Emirates");
        assertThat(airline.getName(),equalTo("Emirates"));
    }

    @Test
    public void airlineName()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Please enter airline name");
        Airline airline = new Airline("");
    }

    @Test
    public void getFlights()
    {
        Airline airline = new Airline("Emirates");
        Flight flight = new Flight("105");
        airline.flights.add(flight);
        Collection ListOfflight = airline.getFlights();
        assertThat(ListOfflight.size(),equalTo(1));
    }

    @Test
    public void addFlights()
    {
        Airline airline = new Airline("Jet Blue");
        Flight flight = new Flight("101");
        airline.addFlight(flight);
        Collection ListOfflight = airline.getFlights();
        assertThat(ListOfflight.size(),equalTo(1));
    }

    @Test
    public void setSource()
    {
        Flight flight = new Flight("110");
        flight.setSource("PDX");
    }

    @Test
    public void setDestination()
    {
        Flight flight = new Flight("110");
        flight.setDestination("SEA");
    }

    @Test
    public void setArrivalTimes()
    {
        Flight flight = new Flight("111");
        flight.setArrivalTime("3/15/2017", "10:39","am");
    }

    @Test
    public void setDepatureTimes()
    {
        Flight flight = new Flight("111");
        flight.setDepartureTime("3/14/2017", "10:39","pm");
    }

    @Test
    public void  getArrivalString() {
        Flight flight = new Flight("111");
        flight.setArrivalTime("3/15/2017", "10:39", "am");
        assertThat(flight.getArrivalString(), equalTo("3/15/2017 10:39 am"));
    }

    @Test
    public void  getDepartureString() {
        Flight flight = new Flight("111");
        flight.setDepartureTime("3/15/2017", "10:39", "am");
        assertThat(flight.getDepartureString(), equalTo("3/15/2017 10:39 am"));
    }

    @Test
    public void TestFlightNum()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Please enter integer flight number only");
        Flight flight = new Flight("ab134");
    }

    @Test
    public void TestSouceCode()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Please enter only three letter code of departure airport");
        Flight flight = new Flight("123");
        flight.setSource("SEAA");
    }

    @Test
    public void TestDestinationCode()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Please enter only three letter code of arrival airport");
        Flight flight = new Flight("123");
        flight.setDestination("SEAA");
    }

    @Test
    public void TestDatetimeValidation()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Date should be in MM/dd/yyyy hh:mm am/pm format");
        Flight flight = new Flight("124");
        flight.DatetimeValidation("2020-12-xx","01:00","am");
    }

    @Test
    public void TestGetSouceCode()
    {
        Flight flight = new Flight("123");
        flight.setSource("SEA");
        assertThat(flight.getSource(),equalTo("SEA"));
    }

    @Test
    public void TestGetSouceCodeNotSet()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Source is not set");
        Flight flight = new Flight("123");
        flight.getSource();
    }

    @Test
    public void  TestDepartureStringNotSet() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Departure time is not set");
        Flight flight = new Flight("111");
        flight.getDepartureString();
    }

    @Test
    public void TestGetDestinationCode()
    {
        Flight flight = new Flight("123");
        flight.setDestination("SEA");
        assertThat(flight.getDestination(),equalTo("SEA"));
    }

    @Test
    public void TestDestinationNotSet()
    {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Destination is not set");
        Flight flight = new Flight("111");
        flight.getDestination();
    }

    @Test
    public void  TestArrivalStringNotSet() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Arrival time is not set");
        Flight flight = new Flight("111");
        flight.getArrivalString();
    }
}
