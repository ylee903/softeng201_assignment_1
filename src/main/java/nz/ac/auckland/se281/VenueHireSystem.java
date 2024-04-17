package nz.ac.auckland.se281;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // This is a private instance variable that holds a list of Venue objects.
  // 'private' means this variable can only be accessed within this class.
  // 'List<Venue>' indicates that this is a list that will only contain objects of type Venue.
  // 'venuesActualListOfVenues' is the name of the variable, and it's used to store the actual list
  // of venues in the system.
  private List<Venue> venuesActualListOfVenues;
  private LocalDate SystemDate;

  public VenueHireSystem() {
    this.venuesActualListOfVenues = new ArrayList<>();
  }

  // the previousl logic using for statement below is now irrelevent.
  /* Print using "System.out.println()", which is similar to "print()" in some other languages.
  MessageCli is likely the name of an enumeration or class.
  NO_VENUES is likely a constant (an enum value or static final variable)
  defined in the MessageCli enumeration or class.
  getMessage() is a method that retrieves the message associated with the NO_VENUES constant.
  This method is likely defined in the MessageCli enumeration or class.
  */

  public void printVenues() {

    // An array that prints the number of venues, using printMessage from the MessageCli class and
    // the numbersInWords array.
    // we need to use NUMBER_VENUES("There %s %s venue%s in the system:") in printMessage.
    // We need to swtich between singular (is) and plural (are) for first %s
    // For second %s we need to use word numbers for less than 10 venues, and then we must use
    // numberals for 10 or more venues
    // For third %s we need to use the word "s" for plural venues
    String[] numbersInWords = {
      "IExistToDoNothing", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    int venueCount = venuesActualListOfVenues.size();
    if (venueCount == 0) {
      MessageCli.NO_VENUES.printMessage();
    } else {
      String verb = (venueCount == 1) ? "is" : "are";
      String number = (venueCount < 10) ? numbersInWords[venueCount] : String.valueOf(venueCount);
      String plural = (venueCount == 1) ? "" : "s";
      /* The above code is a more concise way of writing the following code:
      String verb;
      if (venueCount == 1) {
        verb = "is";
      } else {
        verb = "are";
      }

      String number;
      if (venueCount < 10) {
        number = numbersInWords[venueCount];
      } else {
        number = String.valueOf(venueCount);
      }

      String plural;
      if (venueCount == 1) {
        plural = "";
      } else {
        plural = "s";
      }
      */

      MessageCli.NUMBER_VENUES.printMessage(verb, number, plural);
    }

    // This prints the details of each venue in the list, the date available will be added later
    for (Venue venueLoop : venuesActualListOfVenues) {
      MessageCli.VENUE_ENTRY.printMessage(
          venueLoop.getVenueName(),
          venueLoop.getVenueCode(),
          String.valueOf(venueLoop.getCapacity()),
          String.valueOf(venueLoop.getHireFee()));
    }
  }

  public void createVenue(
      String venueName,
      String venueCode,
      String capacityInputAsString,
      String hireFeeInputAsString) {
    int capacityInputAsInterger;
    int hireFeeAsInterger;

    // Try capacity and hire fee as integers, if they are not integers, catch the exception and use
    // printMessage for error message
    try {
      capacityInputAsInterger = Integer.parseInt(capacityInputAsString);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " an");
      return;
    }
    try {
      hireFeeAsInterger = Integer.parseInt(hireFeeInputAsString);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    // Check if capacity and hire fee are positive values
    if (capacityInputAsInterger <= 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      return;
    }
    if (hireFeeAsInterger <= 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
      return;
    }

    // Check if the venue code already exists
    // can't call static method on instace (non static)
    for (Venue venue : venuesActualListOfVenues) {
      if (venue.getVenueCode().equals(venueCode)) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venue.getVenueName());
        return;
      }
    }

    // Check if the venue name is empty

    if (venueName == null || /*or operator */ venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    Venue
        newVenueInstance /*this is the "variable name" or more correctly, the name of the object or instance*/ =
            new Venue(venueName, venueCode, capacityInputAsInterger, hireFeeAsInterger);
    venuesActualListOfVenues.add(newVenueInstance);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  public void setSystemDate(String dateInput) {
    // DateTimeFormatter: This is the name of the class provided by the java.time.format package.
    // This class is responsible for formatting and parsing dates and times in Java.

    // formatter: This is the name of the variable or object (instance) being declared. In Java, you
    // declare variables with a specific type (in this case, DateTimeFormatter) followed by the
    // variable name (formatter). This variable will refer to an instance of the DateTimeFormatter
    // class.

    // DateTimeFormatter.ofPattern("dd/MM/yyyy"): This is a static method call on the
    // DateTimeFormatter class. The method ofPattern() is a factory method used to create instances
    // of DateTimeFormatter. It takes a string argument representing the pattern used for formatting
    // and parsing dates.

    DateTimeFormatter formmatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    systemDate = LocalDate.parse(dateInput, formatter);
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {}

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
