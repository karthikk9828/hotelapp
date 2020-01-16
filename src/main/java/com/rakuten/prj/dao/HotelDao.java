package com.rakuten.prj.dao;

import java.util.List;

import com.rakuten.prj.entity.Hotel;

public interface HotelDao {

	Hotel getHotel(int hotelId);
	List<Hotel> getHotelUsingName(String name);
	List<Hotel> getHotelUsingCity(String city);
}
