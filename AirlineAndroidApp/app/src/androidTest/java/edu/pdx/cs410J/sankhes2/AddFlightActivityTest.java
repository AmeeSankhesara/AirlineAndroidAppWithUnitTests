package edu.pdx.cs410J.sankhes2;

import android.app.Activity;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddFlightActivityTest {

    @Rule
    public ActivityTestRule<AddFlightActivity> addFlightActivityActivityTestRule = new ActivityTestRule<>(AddFlightActivity.class);

    private AddFlightActivity addFlightActivity=null;
    @Before
    public void setUp() throws Exception
    {
        addFlightActivity=addFlightActivityActivityTestRule.getActivity();
    }

    @Test
    public void testOnCreate()
    {
        View view = addFlightActivity.findViewById(R.id.name);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception
    {
        addFlightActivity=null;
    }


}