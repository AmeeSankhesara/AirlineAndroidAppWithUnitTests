package edu.pdx.cs410J.sankhes2;

import android.content.Intent;
import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class MainActivityTest
{
    @Test
    public void testOnHelpButtonClick()
    {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        mainActivity.findViewById(R.id.help).performClick();
        Intent expectedIntent = new Intent(mainActivity,ReadMeActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(),actual.getComponent());
    }

    @Test
    public void testOnSearchButtonClick()
    {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        mainActivity.findViewById(R.id.search).performClick();
        Intent expectedIntent = new Intent(mainActivity,SearchFlightActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(),actual.getComponent());
    }

    @Test
    public void testOnAddFlightButtonClick()
    {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        mainActivity.findViewById(R.id.add).performClick();
        Intent expectedIntent = new Intent(mainActivity,AddFlightActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(),actual.getComponent());
    }
}
