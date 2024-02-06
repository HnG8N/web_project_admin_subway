package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.dao.ProductSelect_Dao;
import com.javalec.dto.ProductSelect_Dto;

public class ProductList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		ProductSelect_Dao dao = new ProductSelect_Dao();
		ArrayList<ProductSelect_Dto> dtos = dao.selectAction();
		
		session.setAttribute("LIST", dtos);
		
	}

}
