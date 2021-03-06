package edu.pdx.cs410J.sankhes2;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.TestCase.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class AddFlightActivityTest
{
    @Test
    public void addFlightOnClickSaveTest()
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

        addFlightActivity.findViewById(R.id.save).performClick();
        assertEquals("Flight added successfully", ShadowToast.getTextOfLatestToast());

    }
}
