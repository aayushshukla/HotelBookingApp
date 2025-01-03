package org.infosys;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import repository.HotelRepository;
import repository.HotelRepositoryImpl;
import services.BookingService;
import services.PaymentService;
import services.RoomService;

/**
 * Unit test for simple App.
 */
public class AppTest
{
  private PaymentService paymentServiceMock;
  private RoomService roomServiceMock;
  private HotelRepositoryImpl hotelRepositoryImplMock;
  private BookingService bookingService;
  private  HotelRepositoryImpl hotelImplementOrg;

  @BeforeEach
    void init()
    {// creating mock object
        // mock object have basic of object without its logical implementation
      this.hotelRepositoryImplMock= mock(HotelRepositoryImpl.class);
      this.roomServiceMock=mock(RoomService.class);
      this.paymentServiceMock=mock(PaymentService.class);
      this.bookingService = new BookingService(hotelRepositoryImplMock,
               roomServiceMock,
               paymentServiceMock);

    }

    @Test
    void testingHotelBooking()
    {
     String actual =   bookingService.bookHotel(1,"Aayush");
     System.out.println(actual);
     String expecting ="Hotel not found";
     Assertions.assertEquals(expecting,actual);
    }

    @Test
    void testTotalNumberOfHotel()
    {
      hotelImplementOrg= new HotelRepositoryImpl();
        // mock object will return something to us
      int noofhotel=     hotelRepositoryImplMock.totalNoOfHotelAvailable();
      System.out.println(hotelImplementOrg.totalNoOfHotelAvailable());
        System.out.println(noofhotel);


    }


}
