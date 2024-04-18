package nz.ac.auckland.se281;

import java.time.LocalDate;

// Booking.java
public class Booking {
  private String venueCode;
  private LocalDate date;
  private String customerEmail;
  private int attendees;

  public Booking(String venueCode, LocalDate date, String customerEmail, int attendees) {
    this.venueCode = venueCode;
    this.date = date;
    this.customerEmail = customerEmail;
    this.attendees = attendees;
  }

  // Getters...
  public String getVenueCode() {
    return venueCode;
  }
}
