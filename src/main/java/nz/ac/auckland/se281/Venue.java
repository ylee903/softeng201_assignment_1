package nz.ac.auckland.se281;

public class Venue {
  private String venueName;
  private String venueCode;
  private int capacity;
  private double hireFee;

  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = Integer.parseInt(capacityInput);
    this.hireFee = Double.parseDouble(hireFeeInput);
  }

  public String getVenueName() {
    return venueName;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public int getCapacity() {
    return capacity;
  }

  public double getHireFee() {
    return hireFee;
  }
}
