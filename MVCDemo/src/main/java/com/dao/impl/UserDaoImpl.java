package com.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.dao.IUserDao;
import com.entity.User;
import com.util.DatabaseConnection;

public class UserDaoImpl implements IUserDao {
	private DatabaseConnection databaseConnection = new DatabaseConnection();
	
	@Override
	public User findUserByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		StringBuilder sqlStringBuilder = new StringBuilder();
		sqlStringBuilder.append("select * from mvc.user where user.username = ?;");
		
		try {
			return databaseConnection.selectDatabase(sqlStringBuilder.toString(), User.class, userName);
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
