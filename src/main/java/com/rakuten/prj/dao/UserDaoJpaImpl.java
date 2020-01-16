package com.rakuten.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rakuten.prj.entity.User;

@Repository
public class UserDaoJpaImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public User getUser(String email) {
		return em.find(User.class, email);
	}

}
