package com.rakuten.prj.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import com.rakuten.prj.entity.Booking;

public interface BookingDao {

	void addBooking(Booking booking);
	List<Booking> getBookingsBtwDates(SimpleDateFormat startDate, SimpleDateFormat endDate);
}
