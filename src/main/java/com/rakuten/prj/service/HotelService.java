package com.rakuten.prj.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.prj.dao.BookingDao;
import com.rakuten.prj.dao.HotelDao;
import com.rakuten.prj.dao.UserDao;
import com.rakuten.prj.entity.Booking;
import com.rakuten.prj.entity.Hotel;
import com.rakuten.prj.entity.User;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public Hotel getHotel(int hotelId) {
		return hotelDao.getHotel(hotelId);
	}
	
	public User getUser(String email) {
		return userDao.getUser(email);
	}
	
	public List<Hotel> getHotelUsingName(String name) {
		return hotelDao.getHotelUsingName(name);
	}
	
	public List<Hotel> getHotelUsingCity(String city) {
		return hotelDao.getHotelUsingCity(city);
	}
	
	public void bookHotel(Booking booking) {
		bookingDao.addBooking(booking);
	}
	
	public List<Booking> getBookingsBtwDates(SimpleDateFormat startDate, SimpleDateFormat endDate) {
		return bookingDao.getBookingsBtwDates(startDate, endDate);
	}
}
