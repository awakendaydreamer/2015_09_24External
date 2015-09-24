package com.tjo.excel;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConn {
	private SingleConn(){}
	
	private static Connection conn;
	
	static{
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "system";
		String pw = "12345";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =  DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("OracleDriver�� ��ġ���� �ʾҽ��ϴ�.");
		}
	}//static	
	
	public static Connection getConnect(){
		return conn;
	}//getConnect()
}
