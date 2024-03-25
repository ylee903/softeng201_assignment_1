package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private List<Venue> venuesActualListOfVenues;

  public VenueHireSystem()
  {
    this.venuesActualListOfVenues = new ArrayList<>();
  }

  public void printVenues()
  {
    if (venuesActualListOfVenues.isEmpty())
    {
      System.out.println(MessageCli.NO_VENUES.getMessage()); 
      /* Print using "System.out.println()", which is similar to "print()" in some other languages. MessageCli is likely the name of an enumeration or class.
      NO_VENUES is likely a constant (an enum value or static final variable) defined in the MessageCli enumeration or class.
      getMessage() is a method that retrieves the message associated with the NO_VENUES constant. This method is likely defined in the MessageCli enumeration or class.
      */
    }

    if (venuesActualListOfVenues.size() == 1)
    {
      System.out.println("There is one venue in the system:");
    }
    else if (venuesActualListOfVenues.size() > 1){
      System.out.println("There are " + venuesActualListOfVenues.size() + " venues in the system:");
    }

    else
    {
      // code to print out the venues
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInputAsString, String hireFeeInputAsString)
  {

    try
    {
      Double.parseDouble(hireFeeInputAsString);
    }
    catch (NumberFormatException e)
    {
      System.out.println("Venue not created: hire fee must be a number.");
      return;
    }


    if (venueName == null || venueName.trim().isEmpty()) {
      System.out.println(MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.getMessage());
      return;
    }


    int capacity;
    capacity = Integer.parseInt(capacityInputAsString);
    if (capacity < 1) {
      System.out.println("Venue not created: capacity must be a positive number.");
      return;
    }

    Venue newVenueInstance /*this is the "variable name" or more correctly, the name of the object or instance*/ 
     = 
     new Venue (venueName, venueCode, capacityInputAsString, hireFeeInputAsString); 
    /* on the right hand sign of the equation, are creating an instance of the object with the properties/fields/ attributes from the "Venue.java" class file, the object has the respective fields filled in from 
   * the matching parameter names passed in the method "createVenue(String venueName, String venueCode, String capacityInputAsString, String hireFeeInputAsString)"
    * 
    * on the left hand side, we assign a variable name to this instance or object, so that whilst inide of this method, we can actually assign add it to "venuesActualListOfVenues",
    * we could create an instace without the instance being assigned a variable (more accurately instance/object name (pleaes tell me which one is even more correct)),
    * but this would be totally pointless, since we would not be able to assignh it to venuesActualListOfVenues (which is created by the Venue.java class file,     * and is a list of all the venues created in the system.
    */
   venuesActualListOfVenues.add(newVenueInstance);
   System.out.printf(MessageCli.VENUE_SUCCESSFULLY_CREATED.getMessage(), venueName, venueCode);

  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}

/*
 *
 *
 * Sure, let's walk through the process of creating a venue in your system.

Command Input: The command CREATE_VENUE "testing hall" TH 5 100 is entered. This command is a directive to the system to create a new venue with the specified parameters.

Command Parsing: The system parses the command and extracts the parameters. In this case, "testing hall" is the name of the venue, "TH" is the venue code, "5" is the capacity of the venue, and "100" is the hire fee for the venue.

Method Invocation: The system then calls the createVenue method in the VenueHireSystem class, passing in the extracted parameters. The line of code that does this would look something like this: venueHireSystem.createVenue("testing hall", "TH", "5", "100");

Venue Creation: Inside the createVenue method, a new Venue object is created with the given parameters. This is done with the line Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);. The Venue constructor converts the capacity and hire fee from String to int and double respectively, and assigns all these values to the new Venue object.

Venue Addition: The new Venue object is then added to the venues list in the VenueHireSystem class. This is done with the line venues.add(newVenue);. This means that the venue is now stored in the system and can be accessed later.

Command Completion: At this point, the CREATE_VENUE command is complete. The new venue "testing hall" has been created and stored in the system.

Each of these steps is necessary to ensure that the venue is correctly created and stored in the system. The command parsing is necessary to extract the parameters from the command, the Venue object is necessary to store the venue data, and the venues list is necessary to keep track of all the venues in the system.
 *
 *
 */
