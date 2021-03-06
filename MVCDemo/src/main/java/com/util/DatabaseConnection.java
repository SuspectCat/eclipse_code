package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	private static Properties databaseProperties = new Properties();
	
	static {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		InputStream resourceAsStream = contextClassLoader.getResourceAsStream("db.properties");
		try {
			databaseProperties.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName(databaseProperties.getProperty("DriverPath"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(databaseProperties.getProperty("DatabaseName"), databaseProperties.getProperty("username"), databaseProperties.getProperty("passpwd"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int update(String sqlString, Object...objects) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		
		if (null != objects) {
			for (int i = 0; i < objects.length; i++) {
				prepareStatement.setObject(i + 1, objects[i]);
			}
		}
		
		return prepareStatement.executeUpdate();
	}
	
	public <T> T selectDatabase(String sqlString, Class<T> type, Object...objects) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		
		if (null != objects) {
			for (int i = 0; i < objects.length; i++) {
				prepareStatement.setObject(i + 1, objects[i]);
			}
		}
		
		ResultSet executeQuery = prepareStatement.executeQuery();
		
		if (null != executeQuery) {
			if (executeQuery.next()) {
				@SuppressWarnings("deprecation")
				T newInstance = type.newInstance();
				
				ResultSetMetaData metaData = executeQuery.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				for (int i = 0; i < columnCount; i++) {
					String columnName = metaData.getColumnName(i + 1);
					Method[] declaredMethods = type.getDeclaredMethods();
					
					for (Method method : declaredMethods) {
						
						if (method.getName().equalsIgnoreCase("set" + columnName)) {
							method.invoke(newInstance, executeQuery.getObject(columnName));
						}
					}
					
				}
				
				return newInstance;
			}
		}
		
		return null;
	}
}
