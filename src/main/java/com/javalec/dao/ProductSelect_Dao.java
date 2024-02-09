package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.ProductSelect_Dto;

public class ProductSelect_Dao {
	
	// Field
	DataSource dataSource;
	
	// Constructor
	public ProductSelect_Dao() {
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
	public ArrayList<ProductSelect_Dto> selectAction() {
		ArrayList<ProductSelect_Dto> dtos = new ArrayList<ProductSelect_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT m.mncode, m.mnctg, m.mnname, m.mnengname, m.mninfo, m.mnimg, m.mnprice, "
						+ " s.mngram, s.mnkcal, s.mnprotein, s.mnfat, s.mnsugar, s.mnnatrum"
						+ " FROM menu AS m JOIN menuspec AS s ON m.mncode = s.mncode";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductSelect_Dto dto = new ProductSelect_Dto();
				
				dto.setMncode(rs.getInt("m.mncode"));
				dto.setMnctg(rs.getString("m.mnctg"));
				dto.setMnname(rs.getString("m.mnname"));
				dto.setMnengname(rs.getString("m.mnengname"));
				dto.setMninfo(rs.getString("m.mninfo"));
				dto.setMnimg(rs.getString("m.mnimg"));
				dto.setMnprice(rs.getInt("m.mnprice"));
				dto.setMngram(rs.getDouble("s.mngram"));
				dto.setMnkcal(rs.getDouble("s.mnkcal"));
				dto.setMnprotein(rs.getDouble("s.mnprotein"));
				dto.setMnfat(rs.getDouble("s.mnfat"));
				dto.setMnsugar(rs.getDouble("s.mnsugar"));
				dto.setMnnatrum(rs.getDouble("s.mnnatrum"));
				
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
		
	} // selectAction()

	// DB에서 Name 조건으로 불러오기 (Select)
	public ArrayList<ProductSelect_Dto> searchNameAction(String mnname, String mnengname) {
		ArrayList<ProductSelect_Dto> dtos = new ArrayList<ProductSelect_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT mncode, mnctg, mnname, mnengname, mninfo, mnimg, mnprice FROM menu"
						 + " WHERE mnname LIKE ? OR mnengname LIKE ?";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, "%" + mnname + "%");
			preparedStatement.setString(2, "%" + mnengname + "%");
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductSelect_Dto dto = new ProductSelect_Dto();
				
				dto.setMncode(rs.getInt("mncode"));
				dto.setMnctg(rs.getString("mnctg"));
				dto.setMnname(rs.getString("mnname"));
				dto.setMnengname(rs.getString("mnengname"));
				dto.setMninfo(rs.getString("mninfo"));
				dto.setMnimg(rs.getString("mnimg"));
				dto.setMnprice(rs.getInt("mnprice"));
				
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
	} // searchNameAction()
	
	// DB에서 Code 조건으로 불러오기 (Select)
	public ArrayList<ProductSelect_Dto> searchCodeAction(String mncode) {
		ArrayList<ProductSelect_Dto> dtos = new ArrayList<ProductSelect_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT m.mncode, m.mnctg, m.mnname, m.mnengname, m.mninfo, m.mnimg, m.mnprice, "
					+ " s.mngram, s.mnkcal, s.mnprotein, s.mnfat, s.mnsugar, s.mnnatrum"
					+ " FROM menu AS m, menuspec AS s "
					+ " WHERE m.mncode = ? AND m.mncode = s.mncode";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mncode);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				ProductSelect_Dto dto = new ProductSelect_Dto();
				
				dto.setMncode(rs.getInt("mncode"));
				dto.setMnctg(rs.getString("mnctg"));
				dto.setMnname(rs.getString("mnname"));
				dto.setMnengname(rs.getString("mnengname"));
				dto.setMninfo(rs.getString("mninfo"));
				dto.setMnimg(rs.getString("mnimg"));
				dto.setMnprice(rs.getInt("mnprice"));
				dto.setMngram(rs.getDouble("s.mngram"));
				dto.setMnkcal(rs.getDouble("s.mnkcal"));
				dto.setMnprotein(rs.getDouble("s.mnprotein"));
				dto.setMnfat(rs.getDouble("s.mnfat"));
				dto.setMnsugar(rs.getDouble("s.mnsugar"));
				dto.setMnnatrum(rs.getDouble("s.mnnatrum"));
				
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
	} // searchCodeAction()



}
