package edu.pdx.cs410J.sankhes2;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.mockito.Mock;

import java.text.ParseException;

public class SearchPrintUtilTest {

    @Mock
    SearchPrintActivity mSearchPrintActivity;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testWithSourceAndDestination() throws ParseException {

        SearchPrintUtil prettyPrintUtil = new SearchPrintUtil(mSearchPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrintString(flights, "abc", "xyz");
        assert(content.contains("abc"));
        assert(content.contains("xyz"));
    }
    @Test
    public void testWithSource() throws ParseException {

        SearchPrintUtil prettyPrintUtil = new SearchPrintUtil(mSearchPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrintString(flights, "", "xyz");
        assert(content.contains("xyz"));
    }

    @Test
    public void testWithDestination() throws ParseException {

        SearchPrintUtil prettyPrintUtil = new SearchPrintUtil(mSearchPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrintString(flights, "abc", "");
        assert(content.contains("abc"));
    }

    @Test
    public void testWithoutSourceAndDestination() throws ParseException {

        SearchPrintUtil prettyPrintUtil = new SearchPrintUtil(mSearchPrintActivity);
        String flight = "emirates,100,abc,07/01/2020 12:20 pm,xyz,07/01/2020 12:50 pm";
        String flights[] = flight.split(",");
        String content = prettyPrintUtil.generatePrintString(flights, "", "");
        assert(content.contains("abc"));
    }
}