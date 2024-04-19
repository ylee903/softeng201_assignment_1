package nz.ac.auckland.se281;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import nz.ac.auckland.se281.Types.CateringType;

public class Booking {
  private String bookingReference;
  private LocalDate date;
  private String customerEmail;
  private int attendees;
  private Venue venue; // Change from venueCode to Venue object to store more information
  private Set<CateringType> cateringType = new HashSet<>();

  // private FloralType floralType;

  public Booking(
      String bookingReference, Venue venue, LocalDate date, String customerEmail, int attendees) {
    this.bookingReference = bookingReference;
    this.venue = venue;
    this.date = date;
    this.customerEmail = customerEmail;
    this.attendees = attendees;
  }

  public void addCateringType(CateringType cateringType) {
    this.cateringType.add(cateringType);
  }

  // Getters
  public String getBookingReference() {
    return bookingReference;
  }

  public Venue getVenue() {
    return venue;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public int getAttendees() {
    return attendees;
  }

  public Set<CateringType> getCateringType() {
    return this.cateringType;
  }
}
