package edu.pdx.cs410J.sankhes2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddFlightActivity extends Activity
{
    EditText input_airlineName;
    EditText input_flightNumber;
    EditText input_source;
    EditText input_destination;
    EditText input_departureTime;
    EditText input_arrivalTime;
    Button save;
    AddFlight addFlight;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        input_airlineName = findViewById(R.id.name);
        input_flightNumber = findViewById(R.id.num);
        input_source = findViewById(R.id.source);
        input_destination = findViewById(R.id.destination);
        input_departureTime = findViewById(R.id.departure);
        input_arrivalTime = findViewById(R.id.arrival);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writefile();
            }
        });
        addFlight = new AddFlight(this);
    }

    public void writefile()
    {
        try
        {
            Flight flight = this.addFlight.addFlight(input_flightNumber.getText().toString(),
                    input_source.getText().toString(),
                    input_destination.getText().toString(),
                    input_departureTime.getText().toString(),
                    input_arrivalTime.getText().toString());
            Airline airline = this.addFlight.addAirline(flight, input_airlineName.getText().toString());
            this.addFlight.validateArrivalTime(flight);
            writeToFile(airline, flight);
            showToast("Flight added successfully");
            clearTexts();
        }
        catch (Exception e)
        {
            showToast(e.getMessage());
        }
    }

    public void writeToFile(Airline airline, Flight flight) throws IOException {
        String content = airline.getName() + "," + flight.getNumber() + "," + flight.getSource() + "," + flight.getDepartureString()+ "," + flight.getDestination() + "," + flight.getArrivalString()+"\n";
        String filename = airline.getName()+".txt";

        FileOutputStream fileOut = this.getApplicationContext().openFileOutput(filename,this.getApplicationContext().MODE_APPEND);
        fileOut.write(content.getBytes());
        fileOut.close();
    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void clearTexts() {
        this.input_airlineName.setText("");
        this.input_flightNumber.setText("");
        this.input_source.setText("");
        this.input_destination.setText("");
        this.input_departureTime.setText("");
        this.input_arrivalTime.setText("");
    }

}
