package com.javalec.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javalec.dao.ProductSelect_Dao;
import com.javalec.dto.ProductSelect_Dto;

/**
 * Servlet implementation class PLSearchName_Servlet
 */
@WebServlet("/PLSearchName_Servlet")
public class PLSearchName_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PLSearchName_Servlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet 전송");
		
		String mnname = request.getParameter("mnname");
		String mnengname = request.getParameter("mnengname");
		String mncode = request.getParameter("mncode");
		System.out.println(mncode);
		response.setContentType("text/html;charset=UTF-8");
		
		// ArrayList에 담겨 있는 데이터를 JSON으로 변경하여 전송
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();

		ProductSelect_Dao dao = new ProductSelect_Dao();
		
		ArrayList<ProductSelect_Dto> dtos = new ArrayList<ProductSelect_Dto>();
		
		if(mncode==null) {
			dtos = dao.searchNameAction(mnname, mnengname);
		}
		if(mnname==null) {
			dtos = dao.searchCodeAction(mncode);
		}
		try {
			out.print(new Gson().toJson(dtos));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
