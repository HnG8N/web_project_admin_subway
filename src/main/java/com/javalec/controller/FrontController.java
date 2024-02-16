package com.javalec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.command.Command;
import com.javalec.command.Logout;
import com.javalec.command.MemberInformation;
import com.javalec.command.ProductCRUD;
import com.javalec.command.ProductDetail;
import com.javalec.command.ProductList;
import com.javalec.command.Salesstatus;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet"); // get방식으로 들어왔을 때 확인
		actionDo(request, response); // actionDo method로 보냄
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost"); // post방식으로 들어왔을 때 확인
		actionDo(request, response); // actionDo method로 보냄
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Command command = null;
		String viewPage = null;
		
		String url = request.getRequestURI();
		System.out.println(url); 	   	//  /MVCBoard/list.do 라고 뜸
		String conPath = request.getContextPath();
		System.out.println(conPath);	 //  /MVCBoard 라고 뜸
		String com = url.substring(conPath.length());
		System.out.println(com);		//  /list.do라고 뜸(이걸로 페이지를 판단)

		switch (com) {
		case ("/login.do"):
			command = new Logout();
			command.execute(request, response);
			viewPage = "/jsp/login.jsp";
			break;
		case ("/logout.do"):
			command = new Logout();
			command.execute(request, response);
			viewPage = "/jsp/login.jsp";
			break;
		case ("/home.do"):
			viewPage = "/jsp/home.jsp";
			break;
		case ("/salesstatus.do"):
			command = new Salesstatus();
			command.execute(request, response);
			viewPage = "/jsp/salesstatus.jsp";
			break;
		case ("/daystatus.do"):
			viewPage = "/jsp/daystatus.jsp";
			break;
		case ("/piestatus.do"):
			viewPage = "/jsp/piestatus.jsp";
			break;
		case ("/productlist.do"):
			command = new ProductList();
			command.execute(request, response);
			viewPage = "/jsp/productlist.jsp";
			break;
		case ("/productinsert.do"):
			viewPage = "/jsp/productinsert.jsp";
			break;
		case ("/productdetail.do"):
			command = new ProductDetail();
			command.execute(request, response);
			viewPage = "/jsp/productdetail.jsp";
			break;
		case ("/productcrud.do"):
			command = new ProductCRUD();
			command.execute(request, response);
			response.sendRedirect("/admin/productlist.do");
			break;
		case ("/memberinformation.do"):
			command = new MemberInformation();
			command.execute(request, response);
			viewPage = "/jsp/memberinformation.jsp";
			break;
		default:
			break;
		}
		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	} // actionDo()

} // End
