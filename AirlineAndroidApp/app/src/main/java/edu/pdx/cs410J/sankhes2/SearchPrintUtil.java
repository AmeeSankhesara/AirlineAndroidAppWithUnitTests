package edu.pdx.cs410J.sankhes2;

import java.text.ParseException;

public class SearchPrintUtil {

    private final SearchPrintActivity mSearchPrintActivity;

    public SearchPrintUtil(SearchPrintActivity mSearchPrintActivity) {
        this.mSearchPrintActivity = mSearchPrintActivity;
    }

    public String generatePrintString(String [] str,  String source, String destination) throws ParseException {
        String content="";
        String departStr[] = str[3].split("\\s+");
        String arrivalStr[] = str[5].split("\\s+");
        Flight flight = new Flight(str[1]);
        flight.setSource(str[2]);
        flight.setDepartureTime(departStr[0],departStr[1],departStr[2]);
        flight.setDestination(str[4]);
        flight.setArrivalTime(arrivalStr[0],arrivalStr[1],arrivalStr[2]);
        if(source.length()==0 && destination.length()==0)
        {
            content = "\n"+flight.toString()+"\n";
        }
        else if(source.length()!=0 && destination.length()!=0)
        {
            if(str[2].toLowerCase().equals(source.toLowerCase()) && str[4].toLowerCase().equals(destination.toLowerCase()))
            {
                content = "\n"+flight.toString()+"\n";
            }
        }
        else if(source.length()==0 && destination.length()!=0)
        {
            if(str[4].toLowerCase().equals(destination.toLowerCase()))
            {
                content = "\n"+flight.toString()+"\n";
            }
        }
        else if (source.length()!=0 && destination.length()==0)
        {
            if(str[2].toLowerCase().equals(source.toLowerCase()))
            {
                content = "\n"+flight.toString()+"\n";
            }
        }
        return content;
    }
}
