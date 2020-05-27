package edu.pdx.cs410J.sankhes2;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.getText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
public class MainActivityTest
{
    private Button mSearchbtn;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity  = null;
    Instrumentation.ActivityMonitor readMeActivityMonitor = getInstrumentation().addMonitor(ReadMeActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor addFlightActivityMonitor = getInstrumentation().addMonitor(AddFlightActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor searchActivityMonitor = getInstrumentation().addMonitor(SearchFlightActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testOnCreate()
    {
        View view = mainActivity.findViewById(R.id.welcome);
        assertNotNull(view);
    }

    @Test
    public void testLaunchReadMe()
    {
        View help = mainActivity.findViewById(R.id.help);
        assertNotNull(help);
        onView(withId(R.id.help)).perform(click());
        Activity readMeActivity = getInstrumentation().waitForMonitorWithTimeout(readMeActivityMonitor, 5000);
        assertNotNull(readMeActivity);
        onWebView(withId(R.id.readMe)).forceJavascriptEnabled()
                .withElement(findElement(Locator.ID, "headline"))
               .check(webMatches(getText(), containsString("This is airline mobile application and it contains below functionality.")));
        readMeActivity.finish();
    }

    @Test
    public void testLaunchAddFlight()
    {
        View add = mainActivity.findViewById(R.id.add);
        assertNotNull(add);
        onView(withId(R.id.add)).perform(click());
        Activity addFlightActivity = getInstrumentation().waitForMonitorWithTimeout(addFlightActivityMonitor, 5000);
        assertNotNull(addFlightActivity);

        onView(withId(R.id.name)).perform(typeText("Emirates"));
        onView(withId(R.id.num)).perform(typeText("1"));
        onView(withId(R.id.source)).perform(typeText("SEA"));
        onView(withId(R.id.destination)).perform(typeText("PDX"));
        onView(withId(R.id.departure)).perform(typeText("07/01/2020 12:00 pm"));
        onView(withId(R.id.arrival)).perform(typeText("07/01/2020 01:00 pm"),closeSoftKeyboard());
        onView(withId(R.id.save)).perform(click());

        onView(withText(R.string.message)).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
        addFlightActivity.finish();
    }

    @Test
    public void testLaunchSearch()
    {
        View search = mainActivity.findViewById(R.id.search);
        assertNotNull(search);
        onView(withId(R.id.search)).perform(click());
        Activity searchFlightActivity = getInstrumentation().waitForMonitorWithTimeout(searchActivityMonitor, 5000);
        assertNotNull(searchFlightActivity);
        onView(withId(R.id.SearchName)).perform(typeText("Emirates"));
        onView(withId(R.id.SearchSrc)).perform(typeText("SEA"));
        onView(withId(R.id.SearchDest)).perform(typeText("PDX"));
        onView(withId(R.id.searchButton)).perform(click());

        mSearchbtn= searchFlightActivity.findViewById(R.id.searchButton);

        mSearchbtn.setClickable(true);

//        onView(withText("Airline Emirates does not exists")).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

        searchFlightActivity.finish();
    }

    @After
    public void tearDown() throws Exception
    {
        mainActivity=null;
    }
}