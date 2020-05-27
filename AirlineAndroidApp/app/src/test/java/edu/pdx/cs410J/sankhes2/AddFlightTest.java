package edu.pdx.cs410J.sankhes2;


import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class AddFlightTest
{

    @Mock
    AddFlightActivity mMockAddFlightActivity;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testAddFlight() {
        AddFlight addFlight = new AddFlight(mMockAddFlightActivity);
        Flight flight = addFlight.addFlight("1",
                "abc",
                "xyz",
                "07/01/2020 12:20 pm",
                "07/01/2020 12:20 pm");
        assert(flight.getDestination() == "xyz");
    }

    @Test
    public void testFlightDateTime() {

        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Date should be in MM/dd/yyyy hh:mm am/pm format");
        AddFlight addFlight = new AddFlight(mMockAddFlightActivity);
        Flight flight = addFlight.addFlight("1",
                "abc",
                "xyz",
                "07/01/2020 12:20pm",
                "07/01/2020 12:20 pm");
    }

    @Test
    public void testAddAirline() {

        AddFlight addFlight = new AddFlight(mMockAddFlightActivity);
        Flight flight = addFlight.addFlight("1",
                "abc",
                "xyz",
                "07/01/2020 12:20 pm",
                "07/01/2020 12:20 pm");

        Airline airline = addFlight.addAirline(flight, "hello");
        assert(airline.airlineName == "hello");

    }

    @Test
    public void testValidateArrivalTime() throws  ParseException {

        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Arrival time must be greater than departure time");
        AddFlight addFlight = new AddFlight(mMockAddFlightActivity);
        Flight flight = addFlight.addFlight("1",
                "abc",
                "xyz",
                "07/01/2020 12:20 pm",
                "07/01/2020 12:10 pm");

        addFlight.validateArrivalTime(flight);
    }

    @Test
    public void testValidateArrivalTimeInput() throws  ParseException {

        AddFlight addFlight = new AddFlight(mMockAddFlightActivity);
        Flight flight = addFlight.addFlight("1",
                "abc",
                "xyz",
                "07/01/2020 12:20 pm",
                "07/01/2020 12:40 pm");

        addFlight.validateArrivalTime(flight);
    }


}