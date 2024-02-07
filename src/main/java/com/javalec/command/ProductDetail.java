package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.dao.ProductSelect_Dao;
import com.javalec.dto.ProductSelect_Dto;

public class ProductDetail implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
//		HttpSession session = request.getSession();
		
		String mncode = request.getParameter("mncode");
		System.out.println(mncode);
		
		if(mncode != null) {
			ProductSelect_Dao dao = new ProductSelect_Dao();
			ArrayList<ProductSelect_Dto> dtos = dao.searchCodeAction(mncode);
			ProductSelect_Dto dto = dtos.get(0);
			
			request.setAttribute("MENU", dto);
		}
		
	}

}
