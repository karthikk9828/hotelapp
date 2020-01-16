package com.rakuten.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.BookingDaoJpaImpl;
import com.rakuten.prj.dao.HotelDaoJpaImpl;
import com.rakuten.prj.dao.UserDaoJpaImpl;
import com.rakuten.prj.entity.Hotel;
import com.rakuten.prj.service.HotelService;

public class ListHotelClient {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(HotelService.class);
		ctx.register(HotelDaoJpaImpl.class);
		ctx.register(UserDaoJpaImpl.class);
		ctx.register(BookingDaoJpaImpl.class);
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		HotelService hs = ctx.getBean("hotelService", HotelService.class);
		
		System.out.println("\n------Listing hotels with Hotel name : W Hotel------\n");
		List<Hotel> hotels_with_name = hs.getHotelUsingName("W Hotel");
		for (Hotel hotel : hotels_with_name) {
			System.out.println(hotel);
		}
		
		System.out.println("\n------Listing hotels with city : Atlanta------\n");
		List<Hotel> hotels_with_city = hs.getHotelUsingCity("Atlanta");
		for (Hotel hotel : hotels_with_city) {
			System.out.println(hotel);
		}
	}

}
