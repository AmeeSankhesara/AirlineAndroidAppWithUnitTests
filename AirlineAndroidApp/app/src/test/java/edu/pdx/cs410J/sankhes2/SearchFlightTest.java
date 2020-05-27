package edu.pdx.cs410J.sankhes2;

import android.content.Intent;
import android.os.Build;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.TestCase.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class SearchFlightTest
{
    @Test
    public void searchFlightWithEmptyDataTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        activity.findViewById(R.id.searchButton).performClick();
        assertEquals("Please Enter Airline Name", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void searchFlightWithAirlineNotExistsTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                airlineName.setText("Emirates");
            }
        });
        activity.findViewById(R.id.searchButton).performClick();
        assertEquals("Airline Emirates does not exists.", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void searchFlightWithFaultyDepartureAirportTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        final EditText departAirport = activity.findViewById(R.id.SearchSrc);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                airlineName.setText("Emirates");
                departAirport.setText("xyza");
            }
        });
        activity.findViewById(R.id.searchButton).performClick();
        assertEquals("Please enter only three letter code of departure airport", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void searchFlightWithFaultyDestAirportTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        final EditText destAirport = activity.findViewById(R.id.SearchDest);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                airlineName.setText("Emirates");
                destAirport.setText("xyza");
            }
        });
        activity.findViewById(R.id.searchButton).performClick();
        assertEquals("Please enter only three letter code of arrival airport", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void searchFlightWithCorrectDataTest()
    {
        AddFlightActivity addFlightActivity = Robolectric.setupActivity(AddFlightActivity.class);
        addFlightActivity.input_airlineName = addFlightActivity.findViewById(R.id.name);
        addFlightActivity.input_flightNumber = addFlightActivity.findViewById(R.id.num);
        addFlightActivity.input_source = addFlightActivity.findViewById(R.id.source);
        addFlightActivity.input_destination = addFlightActivity.findViewById(R.id.destination);
        addFlightActivity.input_departureTime = addFlightActivity.findViewById(R.id.departure);
        addFlightActivity.input_arrivalTime = addFlightActivity.findViewById(R.id.arrival);
        addFlightActivity.input_airlineName.setText("Emirates");
        addFlightActivity.input_source.setText("SEA");
        addFlightActivity.input_destination.setText("PDX");
        addFlightActivity.input_flightNumber.setText("1");
        addFlightActivity.input_departureTime.setText("07/01/2020 12:20 pm");
        addFlightActivity.input_arrivalTime.setText("07/01/2020 01:20 pm");
        addFlightActivity.writefile();
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        final EditText departAirport = activity.findViewById(R.id.SearchSrc);
        final EditText destAirport = activity.findViewById(R.id.SearchDest);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                airlineName.setText("Emirates");
                departAirport.setText("SEA");
                destAirport.setText("PDX");
            }
        });
        activity.findViewById(R.id.searchButton).performClick();
        Intent expectedIntent = new Intent(activity,SearchPrintActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(),actual.getComponent());
    }

    @Test
    public void PrettyPrintFlightWithEmptyDataTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        activity.findViewById(R.id.prettyPrint).performClick();
        assertEquals("Please Enter Airline Name", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void PrettyPrintFlightWithAirlineNotExistsTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                airlineName.setText("Emirates");
            }
        });
        activity.findViewById(R.id.prettyPrint).performClick();
        assertEquals("Airline Emirates does not exists.", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void PrettyPrintFlightWithFaultyDepartureAirportTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        final EditText departAirport = activity.findViewById(R.id.SearchSrc);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                airlineName.setText("Emirates");
                departAirport.setText("xyza");
            }
        });
        activity.findViewById(R.id.prettyPrint).performClick();
        assertEquals("Please enter only three letter code of departure airport", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void PrettyPrintFlightWithFaultyDestAirportTest() {
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        final EditText destAirport = activity.findViewById(R.id.SearchDest);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                airlineName.setText("Emirates");
                destAirport.setText("xyza");
            }
        });
        activity.findViewById(R.id.prettyPrint).performClick();
        assertEquals("Please enter only three letter code of arrival airport", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void PrettyPrintFlightWithCorrectDataTest()
    {
        AddFlightActivity addFlightActivity = Robolectric.setupActivity(AddFlightActivity.class);
        addFlightActivity.input_airlineName = addFlightActivity.findViewById(R.id.name);
        addFlightActivity.input_flightNumber = addFlightActivity.findViewById(R.id.num);
        addFlightActivity.input_source = addFlightActivity.findViewById(R.id.source);
        addFlightActivity.input_destination = addFlightActivity.findViewById(R.id.destination);
        addFlightActivity.input_departureTime = addFlightActivity.findViewById(R.id.departure);
        addFlightActivity.input_arrivalTime = addFlightActivity.findViewById(R.id.arrival);
        addFlightActivity.input_airlineName.setText("Emirates");
        addFlightActivity.input_source.setText("SEA");
        addFlightActivity.input_destination.setText("PDX");
        addFlightActivity.input_flightNumber.setText("1");
        addFlightActivity.input_departureTime.setText("07/01/2020 12:20 pm");
        addFlightActivity.input_arrivalTime.setText("07/01/2020 01:20 pm");
        addFlightActivity.writefile();
        SearchFlightActivity activity = Robolectric.setupActivity(SearchFlightActivity.class);
        final EditText airlineName = activity.findViewById(R.id.SearchName);
        final EditText departAirport = activity.findViewById(R.id.SearchSrc);
        final EditText destAirport = activity.findViewById(R.id.SearchDest);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                airlineName.setText("Emirates");
                departAirport.setText("SEA");
                destAirport.setText("PDX");
            }
        });
        activity.findViewById(R.id.prettyPrint).performClick();
        Intent expectedIntent = new Intent(activity,PrettyPrintActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(),actual.getComponent());
    }
}
