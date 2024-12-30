package services;

import models.Hotel;

public class RoomService {
    


   public boolean checkAvailableRooms(Hotel hotel)
   {
       return hotel.getAvailableRooms() > 0;
   }

}
