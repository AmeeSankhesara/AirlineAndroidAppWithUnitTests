package edu.pdx.cs410J.sankhes2;

import android.os.Build;
import android.webkit.WebView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class ReadMeActivityTest
{
    @Test
    public void readMeTest()
    {
        ReadMeActivity readMeActivity = Robolectric.setupActivity(ReadMeActivity.class);
        WebView webView = readMeActivity.findViewById(R.id.readMe);
        assertNotNull(webView);
    }
}
