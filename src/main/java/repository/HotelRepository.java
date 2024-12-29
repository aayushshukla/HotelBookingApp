package repository;

import models.Hotel;

public interface HotelRepository {
    Hotel findHotelById(long id);
    boolean updateHotel(Hotel hotel);
}

