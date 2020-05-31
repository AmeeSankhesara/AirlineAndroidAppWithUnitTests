# AirlineAndroidAppWithUnitTests
 
This is airline mobile application and it contains below functionality.

Add Flight button contains below functionality:
  - You can add flight and airline by clicking on button add flights. 
  -	Below is input field constraints.
  -	Airline Name - Should not be empty
  -	Flight Number - Should be digits only
  -	Source - It should be 3 character only
  -	Destination - It should be 3 character only
  -	Departure - It should be in MM/dd/yyyy hh:mm am/pm
  -	Arrival - It should be in MM/dd/yyyy hh:mm am/pm
  
Search flight button contains below functionality:
  -	Input field Airline Name - Should not be empty
  -	Input field Source - It should be 3 character only(Optional field)
  -	Input field Destination - It should be 3 character only(Optional field)
  -	By clicking on pretty print button you can get flights in pretty format.     
  -	By clicking on search flights button you can get flights in raw format.
  -	By providing only airline name you can get all flights of specific airline. 
  -	By providing source and destination you can get all flights of specific airline from given source to destination.
  -	By providing only airline name and source you can get all flights of given airline which depart from given source.
  -	By providing only airline name and destination you can get all flights of given airline which arrive at given destination.
  
Help menu contains below functionality:
  - By clicking on help menu you can read functionality of application.
 
# Number Of lines source code

![Lines of code](https://github.com/AmeeSankhesara/AirlineAndroidAppWithUnitTests/blob/master/LinesOfCode.png)
# Testing library used

  - Roboelectric
  - Junit
  
# Unit Test Code Coverage 

Unit test location - AirlineAndroidApp/app/src/test/

![Code coverage](https://github.com/AmeeSankhesara/AirlineAndroidAppWithUnitTests/blob/master/Coverage.png)


Note : I have written some integration testing as well in android test which can be find in this folder AirlineAndroidApp⁩/app⁩/src⁩/⁨androidTest⁩/
