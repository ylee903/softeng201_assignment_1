@Test
public void testMakeBooking_DateNotSet() {
  VenueHireSystem venueHireSystem = new VenueHireSystem();
  String[] options = {"FFH", "27/02/2024", "client001@email.com", "70"};

  venueHireSystem.makeBooking(options);

  // Assert that the appropriate error message is printed
  // when the system date is not set
  // You can use a mocking framework like Mockito to mock the MessageCli class
  // and verify that the printMessage method is called with the correct message
}

@Test
public void testMakeBooking_NoVenuesAvailable() {
  VenueHireSystem venueHireSystem = new VenueHireSystem();
  String[] options = {"FFH", "27/02/2024", "client001@email.com", "70"};

  // Add some code to set the system date

  venueHireSystem.makeBooking(options);

  // Assert that the appropriate error message is printed
  // when there are no venues available
}

@Test
public void testMakeBooking_VenueNotFound() {
  VenueHireSystem venueHireSystem = new VenueHireSystem();
  String[] options = {"FFH", "27/02/2024", "client001@email.com", "70"};

  // Add some code to set the system date
  // Add some code to populate the venuesActualListOfVenues list

  venueHireSystem.makeBooking(options);

  // Assert that the appropriate error message is printed
  // when the venue code does not exist
}

@Test
public void testMakeBooking_ValidBooking() {
  VenueHireSystem venueHireSystem = new VenueHireSystem();
  String[] options = {"FFH", "27/02/2024", "client001@email.com", "70"};

  // Add some code to set the system date
  // Add some code to populate the venuesActualListOfVenues list
  // Add some code to create a venue with the code "FFH"

  venueHireSystem.makeBooking(options);

  // Assert that the booking is successfully made
  // You can use a mocking framework like Mockito to mock the MessageCli class
  // and verify that the printMessage method is not called with any error message
}