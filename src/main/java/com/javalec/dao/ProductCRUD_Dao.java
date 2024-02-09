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
	public void insertAction(String mnctg, String mnname, String mnengname, String mninfo, String mnimg, String mnprice,
			String mngram, String mnkcal, String mnprotein, String mnfat, String mnsugar, String mnnatrum) {
		Connection connection = null;
		PreparedStatement pstmtMenu = null;
		PreparedStatement pstmtMenuspec = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String menuQuery = "INSERT INTO menu (mnctg, mnname, mnengname, mninfo, mnimg, mnprice)"
							+ " VALUES (?, ?, ?, ?, ?, ?)";	// menu insert 쿼리문 작성
			// menuspec insert 쿼리문 작성, menuspec의 mncode는 AI가 아니기 때문에 value값에 menu의 마지막 mncode를 select해서 넣어줌
			String menuspecQuery = "INSERT INTO menuspec (mncode, mngram, mnkcal, mnprotein, mnfat, mnsugar, mnnatrum) "
								+ " SELECT mncode, ?, ?, ?, ?, ?, ?"
								+ " FROM menu"
								+ " ORDER BY mncode DESC"
								+ " LIMIT 1;"; 
			
			// menu insert 쿼리문 작성
			pstmtMenu = connection.prepareStatement(menuQuery);
			pstmtMenu.setString(1, mnctg);
			pstmtMenu.setString(2, mnname);
			pstmtMenu.setString(3, mnengname);
			pstmtMenu.setString(4, mninfo);
			pstmtMenu.setString(5, mnimg);
			pstmtMenu.setString(6, mnprice);
			pstmtMenu.executeUpdate();
			pstmtMenu.close();

			// menuspec insert 쿼리문 작성
			pstmtMenu = connection.prepareStatement(menuspecQuery);
			pstmtMenu.setString(1, mngram);
			pstmtMenu.setString(2, mnkcal);
			pstmtMenu.setString(3, mnprotein);
			pstmtMenu.setString(4, mnfat);
			pstmtMenu.setString(5, mnsugar);
			pstmtMenu.setString(6, mnnatrum);
			pstmtMenu.executeUpdate();
			
	        // 커밋 (쿼리문을 여러개 쓸 때는 트랜잭션(Transction)을 해주어야 함)
	        connection.commit();

		}catch(Exception e){
			e.printStackTrace();
		}finally {	// try 다음에도 오고 catch 다음에도 오기 때문에 메모리 정리용도로 자주 사용함, 보통 역순으로 정리
			try {
				if(pstmtMenuspec != null) pstmtMenuspec.close();
				if(pstmtMenu != null) pstmtMenu.close();
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
			preparedStatement.setString(6, mngram);
			preparedStatement.setString(7, mnkcal);
			preparedStatement.setString(8, mnprotein);
			preparedStatement.setString(9, mnfat);
			preparedStatement.setString(10, mnsugar);
			preparedStatement.setString(11, mnnatrum);
			preparedStatement.setString(12, mncode);
			
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
