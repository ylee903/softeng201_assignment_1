package nz.ac.auckland.se281;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venue {
  private String venueNameProperty;
  private String venueCodeProperty;
  private int capacityProperty;
  private int hireFeeProperty;
  private List<Booking> bookings;

  /**
   * Constructs a new Venue with the given name, code, capacity, and hire fee.
   *
   * @param venueName the name of the venue
   * @param venueCode the code of the venue
   * @param capacityInput the capacity of the venue as a string
   * @param hireFeeInput the hire fee of the venue as a string
   */
  public Venue(String venueName, String venueCode, int capacityInput, int hireFeeInput) {
    this.venueNameProperty = venueName;
    this.venueCodeProperty = venueCode;
    this.capacityProperty = capacityInput;
    this.hireFeeProperty = hireFeeInput;
    this.bookings = new ArrayList<>();
  }

  public String getVenueName() {
    return venueNameProperty;
  }

  public String getVenueCode() {
    return venueCodeProperty;
  }

  public int getCapacity() {
    return capacityProperty;
  }

  public int getHireFee() {
    return hireFeeProperty;
  }

  public boolean isBookedOnDate(LocalDate date) {
    for (Booking booking : bookings) {
      if (booking.getDate().equals(date)) {
        return true;
      }
    }
    return false;
  }

  public void bookOnDate(LocalDate date, String customerEmail, int attendees) {
    bookings.add(new Booking(venueCodeProperty, date, customerEmail, attendees));
  }
}
