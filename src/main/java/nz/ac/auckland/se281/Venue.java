package nz.ac.auckland.se281;

public class Venue {
  private String venueNameProperty;
  private String venueCodeProperty;
  private int capacityProperty;
  private double hireFeeProperty;



/**
 * Constructs a new Venue with the given name, code, capacity, and hire fee.
 *
 * @param venueName the name of the venue
 * @param venueCode the code of the venue
 * @param capacityInput the capacity of the venue as a string
 * @param hireFeeInput the hire fee of the venue as a string
 */

  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueNameProperty = venueName;
    this.venueCodeProperty = venueCode;
    this.capacityProperty = Integer.parseInt(capacityInput);
    this.hireFeeProperty = Double.parseDouble(hireFeeInput);
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

  public double getHireFee() {
    return hireFeeProperty;
  }
}
