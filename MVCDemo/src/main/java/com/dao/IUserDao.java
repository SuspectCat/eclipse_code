package com.dao;

import com.entity.User;

public interface IUserDao {
	User findUserByUserName(String userName, String password);
}
