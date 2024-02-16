package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.Salesstatus_Dto;

public class Salesstatus_Dao {
	
	// Field
	DataSource dataSource;
	
	// Constructor
	public Salesstatus_Dao() {
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
	// DB에서 불러오기 (Select)
	public ArrayList<Salesstatus_Dto> chartDBselect() {
		ArrayList<Salesstatus_Dto> dtos = new ArrayList<Salesstatus_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT oseq ,omid ,omncode ,olength ,obread ,otoast ,ocheese ,"
						+ " ovegetables ,osauce ,oprice ,odate"
						+ " FROM orderpurchase";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Salesstatus_Dto dto = new Salesstatus_Dto();
				
				dto.setOseq(rs.getInt("oseq"));
				dto.setOmid(rs.getString("omid"));
				dto.setOmncode(rs.getInt("omncode"));
				dto.setOlength(rs.getInt("olength"));
				dto.setObread(rs.getString("obread"));
				dto.setOtoast(rs.getString("otoast"));
				dto.setOcheese(rs.getString("ocheese"));
				dto.setOvegetables(rs.getString("ovegetables"));
				dto.setOsauce(rs.getString("osauce"));
				dto.setOprice(rs.getInt("oprice"));
				dto.setOdate(rs.getString("odate"));
				
				dtos.add(dto);
			}
			
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
		return dtos;
		
	} // chartDBselect()

	// DB에서 시작날짜와 끝날짜를 가지고 pie차트 DB 가져오기 (Select)
	public ArrayList<Salesstatus_Dto> pieChartDBselect(String startDay, String endDay) {
		ArrayList<Salesstatus_Dto> dtos = new ArrayList<Salesstatus_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT m.mnname ,COUNT(m.mncode) "
						+ " FROM menu m ,orderpurchase o "
						+ " WHERE o.odate BETWEEN ? AND ?"
						+ " AND m.mncode = o.omncode"
						+ " GROUP BY m.mnname";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, startDay);
			preparedStatement.setString(2, endDay);

			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Salesstatus_Dto dto = new Salesstatus_Dto();
				
				dto.setMnname(rs.getString("m.mnname"));
				dto.setCountMncode(rs.getInt("COUNT(m.mncode)"));
				
				dtos.add(dto);
			}
			
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
		return dtos;
		
	} // pieChartDBselect()
	
	// DB에서 불러오기 (Select)
	public ArrayList<Salesstatus_Dto> barChartDBselect(String startDay, String endDay) {
		ArrayList<Salesstatus_Dto> dtos = new ArrayList<Salesstatus_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT DATE_FORMAT(odate, '%Y-%m-%d') as oday, SUM(oprice) as odaysum"
						+ " FROM orderpurchase"
						+ " WHERE odate BETWEEN ? AND ?"
						+ " GROUP BY oday";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, startDay);
			preparedStatement.setString(2, endDay);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Salesstatus_Dto dto = new Salesstatus_Dto();
				
				dto.setOday(rs.getString("oday"));
				dto.setOdaysum(rs.getInt("odaysum"));
				
				dtos.add(dto);
			}
			
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
		return dtos;
		
	} // chartDBselect()

	// 초기 차트 date를 DB에서 불러오기 (Select)
	public ArrayList<Salesstatus_Dto> initBarChartDBselect() {
		ArrayList<Salesstatus_Dto> dtos = new ArrayList<Salesstatus_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT MONTH (odate) as omonth, SUM(oprice) as omonthsum"
						+ " FROM orderpurchase"
						+ " WHERE YEAR (odate) BETWEEN YEAR (NOW())-1 AND YEAR (NOW())"
						+ " GROUP BY omonth";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Salesstatus_Dto dto = new Salesstatus_Dto();
				
				dto.setOmonth(rs.getString("omonth"));
				dto.setOmonthsum(rs.getInt("omonthsum"));
				
				dtos.add(dto);
			}
			
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
		return dtos;
		
	} // chartDBselect()
	
}
