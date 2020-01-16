package com.rakuten.prj.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.BookingDaoJpaImpl;
import com.rakuten.prj.dao.HotelDaoJpaImpl;
import com.rakuten.prj.dao.UserDaoJpaImpl;
import com.rakuten.prj.entity.Booking;
import com.rakuten.prj.entity.Hotel;
import com.rakuten.prj.entity.User;
import com.rakuten.prj.service.HotelService;

import javassist.expr.NewArray;

public class BookHotelClient {

public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(HotelService.class);
		ctx.register(HotelDaoJpaImpl.class);
		ctx.register(UserDaoJpaImpl.class);
		ctx.register(BookingDaoJpaImpl.class);
		ctx.register(AppConfig.class);
		ctx.refresh();

		HotelService hs = ctx.getBean("hotelService", HotelService.class);
		
		Hotel hotel = hs.getHotel(2);
		
		User user = hs.getUser("john22@gmail.com");
		
		/**
		 * create checkInDate of SimpleDateFormat format
		 */
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		@SuppressWarnings("deprecation")
		String checkInDate = simpleDateFormat.format(new Date(2020, 1, 18, 10, 30));
		//String checkInDate = simpleDateFormat.format(new Date());
		
		/**
		 * create checkOutDate of SimpleDateFormat format
		 */
		@SuppressWarnings("deprecation")
		String checkOutDate = simpleDateFormat.format(new Date(2020, 1, 19, 6, 00));
		
		Booking booking = new Booking(0, hotel, user, checkInDate, checkOutDate);
		
		hs.bookHotel(booking);
		System.out.println("Hotel booked !!\n CheckIn: " + checkInDate + "\n " + checkOutDate);
	}
}
