package edu.pdx.cs410J.sankhes2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class PrettyPrintActivity extends AppCompatActivity {
    String airline;
    String source;
    String destination;
    TextView prettyText;
    PrettyPrintUtil prettyPrintUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretty_print);
        prettyText=findViewById(R.id.pretty);
        prettyPrintUtil = new PrettyPrintUtil(this);
        prettyprint();
    }

    public void prettyprint()
    {
            Intent intent = getIntent();
            airline=intent.getStringExtra("SearchName");
            source=intent.getStringExtra("SearchSrc");
            destination=intent.getStringExtra("SearchDest");
            String filename = airline+".txt";
            try
            {
                FileInputStream fileInputStream = openFileInput(filename);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                String lines;
                while ((lines=bufferedReader.readLine())!=null)
                {
                    String str[] = lines.split(",");
                    stringBuffer.append(prettyPrintUtil.generatePrettyStringUtiliy(str, source, destination));
                }
                if (stringBuffer.toString().length()==0)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Flights not exists for given inputs.Please go back to search flight to search again.",Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                prettyText.setText(stringBuffer.toString());
                prettyText.setMovementMethod(new ScrollingMovementMethod());
            }
            catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), "Data for given airline not found", Toast.LENGTH_LONG);
                toast.show();
            }
    }

}
