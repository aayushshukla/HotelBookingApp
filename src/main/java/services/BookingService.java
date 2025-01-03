package services;

import appexceptions.BookingException;
import models.Hotel;
import repository.HotelRepository;

import java.util.List;

public class BookingService {
    private HotelRepository hotelRepository;
    private RoomService roomService;
    private  PaymentService paymentService;

    public BookingService(HotelRepository hotelRepository,RoomService roomService,
                          PaymentService paymentService) {
        this.hotelRepository = hotelRepository;
        this.roomService=roomService;
        this.paymentService=paymentService;
    }

    public String bookHotel(long hotelId, String customerName) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        if (hotel == null) {
            return "Hotel not found";
        }

        if (hotel.getAvailableRooms() <= 0) {
            //return "No available rooms";
            throw  new BookingException();
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

        if(!roomService.checkAvailableRooms(hotel))
        {
            return "no rooms available";
           // throw  new BookingException();
        }

        // Simulate canceling the booking and restoring the available room
        hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
        hotelRepository.updateHotel(hotel);

        return "Booking canceled for " + customerName;
    }
    public  int getAvailablePlaceCount()
    {
        int availableHotels = hotelRepository.totalNoOfHotelAvailable();
        return availableHotels;
    }

    public List<String> getAllHotelNames()
    {
         List<String> hotelNameList = hotelRepository.gethotelNames();
         return hotelNameList;
    }
    public  int getPayment()
    {
       return   paymentService.payment();
    }


}
