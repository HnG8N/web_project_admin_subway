package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.MemberInformation_Dto;

public class MemberInformation_Dao {
	// Field
	DataSource dataSource;
	
	// Constructor
	public MemberInformation_Dao() {
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
	public ArrayList<MemberInformation_Dto> memberList() {
		ArrayList<MemberInformation_Dto> dtos = new ArrayList<MemberInformation_Dto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();	// dataSoure를 연결 해주는 명령어
			String query = "SELECT mid ,mpw ,mname ,maddress ,mtel ,mbirth ,memail ,mregdate ,menddate"
						+ " FROM member";	// 쿼리문 작성
			
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				MemberInformation_Dto dto = new MemberInformation_Dto();
				
				dto.setMid(rs.getString("mid"));
				dto.setMpw(rs.getString("mpw"));
				dto.setMname(rs.getString("mname"));
				dto.setMaddress(rs.getString("maddress"));
				dto.setMtel(rs.getString("mtel"));
				dto.setMbirth(rs.getString("mbirth"));
				dto.setMemail(rs.getString("memail"));
				dto.setMregdate(rs.getString("mregdate"));
				dto.setMenddate(rs.getString("menddate"));
				
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

}
