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

/**
 * Servlet implementation class ProductList_Servlet
 */
@WebServlet("/ProductList_Servlet")
public class ProductList_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList_Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String url = request.getRequestURI();
//		System.out.println(url); 	   	//  /subway/list.do 라고 뜸
//		String conPath = request.getContextPath();
//		System.out.println(conPath);	 //  /subway 라고 뜸
//		String com = url.substring(conPath.length());
//		System.out.println(com);		//  /list.do라고 뜸(이걸로 페이지를 판단)
//		switch (com) {
//		case ("/productlist.do"):
//		break;
//		case ("/productcrud.do"):
//			break;
//		case ("/productdb.do"):
//		break;
//		default:
//			break;
//		}
		
		HttpSession session = request.getSession();
		
		System.out.println("servlet 전송");
		
		String mnname = request.getParameter("mnname");
		System.out.println(mnname);
		response.setContentType("text/html;charset=UTF-8");
		
		// ArrayList에 담겨 있는 데이터를 JSON으로 변경하여 전송
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		try {
			out.print(new Gson().toJson(session.getAttribute("LIST")));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
