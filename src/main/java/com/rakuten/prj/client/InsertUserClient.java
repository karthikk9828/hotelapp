package com.rakuten.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.config.TxNamespaceHandler;

import com.rakuten.prj.cfg.AppConfig;
import com.rakuten.prj.dao.BookingDaoJpaImpl;
import com.rakuten.prj.dao.HotelDaoJpaImpl;
import com.rakuten.prj.dao.UserDaoJpaImpl;
import com.rakuten.prj.entity.User;
import com.rakuten.prj.service.HotelService;

public class InsertUserClient {

public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(HotelService.class);
		ctx.register(HotelDaoJpaImpl.class);
		ctx.register(BookingDaoJpaImpl.class);
		ctx.register(UserDaoJpaImpl.class);
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		HotelService hs = ctx.getBean("hotelService", HotelService.class);
		
		User[] users = new User[2];
		
		users[0] = new User("john22@gmail.com", "John Wick");
		users[1] = new User("david@gmail.com", "David Black");
		
		for (User user : users) {
			hs.addUser(user);
		}
		System.out.println("Users added !!!");
	}
}
