package com.rakuten.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.Hotel;

@Repository
public class HotelDaoJpaImpl implements HotelDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Hotel> getHotelUsingName(String name) {
		String jpql = "from Hotel where hotelName is " + "'" + name + "'";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> getHotelUsingCity(String city) {
		String jpql = "from Hotel where city is " + "'" + city + "'";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		return query.getResultList();
	}

	@Override
	public Hotel getHotel(int hotelId) {
		return em.find(Hotel.class, hotelId);
	}

}
