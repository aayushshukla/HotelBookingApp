package appexceptions;

import services.BookingService;

public class BookingException extends RuntimeException {

    public BookingException()
    {
        System.out.println("No rooms found ");
    }
}
