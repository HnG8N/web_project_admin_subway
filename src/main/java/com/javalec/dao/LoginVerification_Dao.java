package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.LoginVerification_Dto;

public class LoginVerification_Dao {
	// Field
	DataSource dataSource;
	
	// Constructor
	public LoginVerification_Dao() {
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
	// DB의 member Table에서 받아온 id와 pw를 where 조건으로 검색
	public LoginVerification_Dto loginVerification(String mid, String mpw) {
		LoginVerification_Dto dto = new LoginVerification_Dto();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT mid, mpw"
						+ " FROM member"
						+ " WHERE mid = ?";	// mid와 mpw가 존재하는지 확인하는 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mid);
			
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				dto.setMid(resultset.getString("mid"));
				dto.setMpw(resultset.getString("mpw"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	// try 다음에도 오고 catch 다음에도 오기 때문에 메모리 정리용도로 자주 사용함, 보통 역순으로 정리
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
} //End
