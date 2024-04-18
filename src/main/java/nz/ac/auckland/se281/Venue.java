package nz.ac.auckland.se281;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  public LocalDate getNextAvailableDate(LocalDate systemDate) {
    LocalDate start = systemDate != null ? systemDate : LocalDate.now();

    // Collect all the dates that have bookings into a sorted list
    List<LocalDate> bookedDates =
        bookings.stream().map(Booking::getDate).sorted().collect(Collectors.toList());

    // Iterate starting from 'start' date and check each day
    LocalDate checkDate = start;
    while (true) {
      // Check if the 'checkDate' is not in the list of booked dates
      boolean isBooked = bookedDates.contains(checkDate);
      if (!isBooked) {
        return checkDate; // Found the next available date
      }
      // Move to the next day
      checkDate = checkDate.plusDays(1);
    }
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

  public boolean isBookedOnDate(LocalDate date) {
    return bookings.stream().anyMatch(b -> b.getDate().equals(date));
  }

  public List<Booking> getBookings() {
    return this.bookings;
  }
}
