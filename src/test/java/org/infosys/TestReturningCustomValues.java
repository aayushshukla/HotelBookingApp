package org.infosys;


import models.Hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.HotelRepositoryImpl;
import services.BookingService;
import services.PaymentService;
import services.RoomService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class TestReturningCustomValues
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
      this.hotelImplementOrg = new HotelRepositoryImpl();

    }

    @Test
  void testTotalHotelsAvailable()
    {
      // return custom value from mock
      when(this.hotelRepositoryImplMock.totalNoOfHotelAvailable()).thenReturn(3);
      int expected=3;
    int actual =hotelImplementOrg.totalNoOfHotelAvailable();
    Assertions.assertEquals(expected,actual);
    }

  @Test
  void testingRoomService()
  {
    RoomService roomService = new RoomService();
    when(roomServiceMock.checkAvailableRooms(new Hotel(5,"abc",0))).thenReturn(true);
    boolean expected=true;
    boolean actual = roomService.checkAvailableRooms(new Hotel(4,"abc",1));
    Assertions.assertEquals(expected,actual);
  }




}
