package edu.pdx.cs410J.sankhes2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class PrettyPrintUtilTest
{
    @Mock
    PrettyPrintActivity mPrettyPrintActivity;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testWithSourceAndDestination() throws ParseException {

        PrettyPrintUtil prettyPrintUtil = new PrettyPrintUtil(mPrettyPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrettyStringUtiliy(flights, "abc", "xyz");
        assert(content.contains("Flight Source Airport Code = abc"));
        assert(content.contains("Flight Destination Airport Code = xyz"));
    }
    @Test
    public void testWithSource() throws ParseException {

        PrettyPrintUtil prettyPrintUtil = new PrettyPrintUtil(mPrettyPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrettyStringUtiliy(flights, "", "xyz");
        assert(content.contains("Flight Destination Airport Code = xyz"));
    }

    @Test
    public void testWithDestination() throws ParseException {
        PrettyPrintUtil prettyPrintUtil = new PrettyPrintUtil(mPrettyPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrettyStringUtiliy(flights, "abc", "");
        assert(content.contains("Flight Source Airport Code = abc"));
    }

    @Test
    public void testWithoutSourceAndDestination() throws ParseException
    {
        PrettyPrintUtil prettyPrintUtil = new PrettyPrintUtil(mPrettyPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrettyStringUtiliy(flights, "", "");
        assert(content.contains("Airline Name = emirates"));

    }

}