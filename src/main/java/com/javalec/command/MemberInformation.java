package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.dao.MemberInformation_Dao;
import com.javalec.dto.MemberInformation_Dto;

public class MemberInformation implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberInformation_Dao dao = new MemberInformation_Dao();
		ArrayList<MemberInformation_Dto> dtos = dao.memberList();
		request.setAttribute("MEMBER", dtos);
	}

}
