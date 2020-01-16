package com.rakuten.prj.dao;

import com.rakuten.prj.entity.User;

public interface UserDao {

	User getUser(String email);
	void addUser(User user);
}
