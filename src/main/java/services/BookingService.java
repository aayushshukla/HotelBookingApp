package services;

import models.Hotel;
import repository.HotelRepository;

public class BookingService {
    private HotelRepository hotelRepository;

    public BookingService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public String bookHotel(long hotelId, String customerName) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        if (hotel == null) {
            return "Hotel not found";
        }

        if (hotel.getAvailableRooms() <= 0) {
            return "No available rooms";
        }

        // Simulate booking
        hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
        hotelRepository.updateHotel(hotel);

        // Return booking confirmation
        return "Booking confirmed for " + customerName;
    }

    public String cancelBooking(long hotelId, String customerName) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        if (hotel == null) {
            return "Hotel not found";
        }

        // Simulate canceling the booking and restoring the available room
        hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
        hotelRepository.updateHotel(hotel);

        return "Booking canceled for " + customerName;
    }
}
