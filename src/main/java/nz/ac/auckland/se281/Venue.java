package nz.ac.auckland.se281;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Venue {
  private String venueName;
  private String venueCode;
  private int capacity;
  private int hireFee;
  private List<Booking> bookings;
  private LocalDate nextAvailableDate; // New field

  public Venue(String venueName, String venueCode, int capacity, int hireFee) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = capacity;
    this.hireFee = hireFee;
    this.bookings = new ArrayList<>();
    this.nextAvailableDate = LocalDate.now(); // Initialize with the current date
  }

  public void addBooking(Booking booking) {
    bookings.add(booking);
    updateNextAvailableDate();
  }

  private void updateNextAvailableDate() {
    if (bookings.isEmpty()) {
      this.nextAvailableDate = LocalDate.now(); // Available today if no bookings
    } else {
      bookings.sort(Comparator.comparing(Booking::getDate));

      LocalDate currentDate = LocalDate.now();
      LocalDate dateToCheck =
          currentDate.isAfter(bookings.get(0).getDate()) ? currentDate : bookings.get(0).getDate();

      for (Booking booking : bookings) {
        if (!booking.getDate().equals(dateToCheck)) {
          this.nextAvailableDate = dateToCheck; // Found a gap in bookings
          return;
        }
        dateToCheck = dateToCheck.plusDays(1); // Move to the next day
      }

      // If no gaps, next available date is the day after the last booking
      this.nextAvailableDate = bookings.get(bookings.size() - 1).getDate().plusDays(1);
    }
  }

  public LocalDate getNextAvailableDate() {
    return nextAvailableDate;
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

  public boolean isBookedOnDate(LocalDate date) {
    return bookings.stream().anyMatch(b -> b.getDate().equals(date));
  }
}
