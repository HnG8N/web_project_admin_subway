package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductCRUD_Dao {
	
	// Field
	DataSource dataSource;
	
	// Constructor
	public ProductCRUD_Dao() {
		try {
			// Server의 context.xml의 소스를 가져와야 함	
			Context context = new InitialContext();
			// DataSource를 가져옴, java:comp/env가 파일위치,  jdbc/subway는 context.xml에서 만들어준 파일이름
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/subway");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	// DB Insert
	public void insertAction(String mnctg, String mnname, String mnengname, String mninfo, String mnimg, String mnprice) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "INSERT INTO menu (mnctg, mnname, mnengname, mninfo, mnimg, mnprice)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mnctg);
			preparedStatement.setString(2, mnname);
			preparedStatement.setString(3, mnengname);
			preparedStatement.setString(4, mninfo);
			preparedStatement.setString(5, mnimg);
			preparedStatement.setString(6, mnprice);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {	// try 다음에도 오고 catch 다음에도 오기 때문에 메모리 정리용도로 자주 사용함, 보통 역순으로 정리
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	} // insertAction()

	// DB Update
	public void updateAction(String mnctg, String mnname, String mnengname, 
			String mninfo, String mnprice, String mncode, String mngram, 
			String mnkcal, String mnprotein, String mnfat, String mnsugar, String mnnatrum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "UPDATE menu AS m JOIN menuspec AS s ON m.mncode = s.mncode"
						+ " SET m.mnctg = ?, m.mnname = ?, m.mnengname = ?, m.mninfo = ?, m.mnprice = ?,"
						+ "	s.mngram = ?, s.mnkcal = ?, s.mnprotein = ?, s.mnfat = ?, s.mnsugar = ?, s.mnnatrum = ?"
						+ " WHERE m.mncode = ?";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mnctg);
			preparedStatement.setString(2, mnname);
			preparedStatement.setString(3, mnengname);
			preparedStatement.setString(4, mninfo);
			preparedStatement.setString(5, mnprice);
			preparedStatement.setString(6, mncode);
			preparedStatement.setString(7, mngram);
			preparedStatement.setString(8, mnkcal);
			preparedStatement.setString(9, mnprotein);
			preparedStatement.setString(10, mnfat);
			preparedStatement.setString(11, mnsugar);
			preparedStatement.setString(12, mnnatrum);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {	// try 다음에도 오고 catch 다음에도 오기 때문에 메모리 정리용도로 자주 사용함, 보통 역순으로 정리
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} // updateAction()

	// DB Update 이미지파일이 변경 되었을 경우
	public void updateMnimg(String mnimg, String mncode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "UPDATE menu SET mnimg = ? WHERE mncode = ?";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mnimg);
			preparedStatement.setString(2, mncode);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {	// try 다음에도 오고 catch 다음에도 오기 때문에 메모리 정리용도로 자주 사용함, 보통 역순으로 정리
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} // updateMnimg()



}
