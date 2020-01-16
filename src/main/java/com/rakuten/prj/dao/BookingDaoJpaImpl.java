package com.rakuten.prj.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Booking;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addBooking(Booking booking) {
		em.persist(booking);
	}

	@Override
	public List<Booking> getBookingsBtwDates(SimpleDateFormat startDate, SimpleDateFormat endDate) {
		String jpql = "from Booking where ";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		return query.getResultList();
	}

}
