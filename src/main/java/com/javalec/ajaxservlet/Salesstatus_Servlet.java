package com.javalec.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javalec.dao.Salesstatus_Dao;
import com.javalec.dto.Salesstatus_Dto;

/**
 * Servlet implementation class Salesstatus_Servlet
 */
@WebServlet("/Salesstatus_Servlet")
public class Salesstatus_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salesstatus_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		System.out.println(startDay + endDay);
		
		Salesstatus_Dao dao = new Salesstatus_Dao();
		
		ArrayList<Salesstatus_Dto> dtos = new ArrayList<Salesstatus_Dto>();
		if(startDay != null && endDay != null) {
			dtos = dao.barChartDBselect(startDay, endDay);
			System.out.println(dtos.get(0).getOdaysum());
			System.out.println(dtos.get(0).getOday());
		}else {
			dtos = dao.initBarChartDBselect();
		}
		
		request.setAttribute("CHART",dtos);
		
		response.setContentType("text/html;charset=UTF-8");
		
		// ArrayList에 담겨 있는 데이터를 JSON으로 변경하여 전송
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			out.print(new Gson().toJson(dtos));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
