package nz.ac.auckland.se281;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venue {
  private String venueName;
  private String venueCode;
  private int capacity;
  private int hireFee;
  private List<Booking> bookings;

  public Venue(String venueName, String venueCode, int capacity, int hireFee) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = capacity;
    this.hireFee = hireFee;
    this.bookings = new ArrayList<>();
  }

  // Getters
  public String getVenueName() {
    return venueName;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getHireFee() {
    return hireFee;
  }

  public boolean isAvailableOn(LocalDate date) {
    return bookings.stream().noneMatch(b -> b.getDate().equals(date));
  }

  public void addBooking(Booking booking) {
    bookings.add(booking);
  }
}
