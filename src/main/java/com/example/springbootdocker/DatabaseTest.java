package com.example.springbootdocker;

import java.io.*;
import java.sql.*;

public class DatabaseTest {

  static String testMysql(String args[]) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema?profileSQL=true&zeroDateTimeBehavior=convertToNull","root","Cassandra123$");
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(args[0]);
	ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	
	String result = "";
	while (resultSet.next()) {
		result = resultSet.getString(1) + ":" + resultSet.getString(2) + ":" + resultSet.getString(3);
	}
	resultSet.close();
	statement.close();
    connection.close();
    return result;
  }
  
	public static String getString(Reader reader) throws IOException {
		StringBuilder builder = new StringBuilder();
		int c;
		try {
			while ((c=reader.read())>-1) {
				builder.append((char) c);
			}
		} catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			e.printStackTrace();
		}
		return builder.toString();
	}

  public static void main(String[] args) throws Exception {
	  testMysql(args);
  }
}
