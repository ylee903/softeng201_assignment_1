package nz.ac.auckland.se281;

public class temp {}







if (venuesActualListOfVenues.isEmpty()) {
  MessageCli.NO_VENUES.printMessage();

} else if (venuesActualListOfVenues.size() == 1) {
  System.out.println("There is one venue in the system:");
} else if (venuesActualListOfVenues.size() < 10) {

  System.out.println(
      "There are "
          + numbersInWords[venuesActualListOfVenues.size()]
          + " venues in the system:");
} else {
  System.out.println("There are " + venuesActualListOfVenues.size() + " venues in the system:");
}