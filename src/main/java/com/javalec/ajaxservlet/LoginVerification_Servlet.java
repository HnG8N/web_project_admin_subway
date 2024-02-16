package com.javalec.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.javalec.dao.LoginVerification_Dao;
import com.javalec.dto.LoginVerification_Dto;

/**
 * Servlet implementation class LoginVerification
 */
@WebServlet("/LoginVerification_Servlet")
public class LoginVerification_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginVerification_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		System.out.println(mid);
		System.out.println(mpw);
		
		LoginVerification_Dao dao = new LoginVerification_Dao();
		LoginVerification_Dto dto = dao.loginVerification(mid, mpw);
		System.out.println(dto.getMid());
		System.out.println(dto.getMpw());
		session.setAttribute("Logged_in_ID", dto.getMid());
		if(dto.getMid() != null) {
			session.setAttribute("welcome", dto.getMid() + "님 환영합니다.");
		}
		
		
		
//		 ArrayList에 담겨 있는 데이터를 JSON으로 변경하여 전송
		PrintWriter out = response.getWriter();
		try {
			out.print(new Gson().toJson(dto));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

}
