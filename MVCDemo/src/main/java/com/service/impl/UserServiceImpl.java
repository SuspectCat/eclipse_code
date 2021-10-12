package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean userLogin(String userName, String password) {
		// TODO Auto-generated method stub
		boolean isRegisiter = false;
		UserDaoImpl daoImpl = new UserDaoImpl();
		
		if (null != daoImpl.findUserByUserName(userName, password)) 
			if (password.equals(daoImpl.findUserByUserName(userName, password).getUserpwd())) isRegisiter = true;
		
		return isRegisiter;
	}

}
