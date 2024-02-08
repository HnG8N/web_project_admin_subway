package com.javalec.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.dao.ProductCRUD_Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductCRUD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// UTF-8로 컨버팅
        response.setCharacterEncoding("UTF-8");
		// 파일 사이즈 지정
        int fileSize = 1024 * 1024 * 100; // 300MB로 파일 크기를 제한
        // ServletContext를 사용하여 업로드 경로를 가져옴
        String uploadPath = request.getServletContext().getRealPath("/img");
        System.out.println(uploadPath);

        // MultipartRequest를 사용하여 파일 업로드 처리
        try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
            // 이미지 이름 불러오기
			String mnimg = multi.getFilesystemName("mnimg");
			// 이미지 이름 출력(확인)
//            System.out.println(mnimg);
            String mnctg = multi.getParameter("mnctg");
//            System.out.println(mnctg);
            String mnname = multi.getParameter("mnname");
//            System.out.println(mnname);
            String mnengname = multi.getParameter("mnengname");
//            System.out.println(mnengname);
            String mninfo = multi.getParameter("mninfo");
//            System.out.println(mninfo);
            String mnprice = multi.getParameter("mnprice");
//            System.out.println(mnprice);
            String mncode = multi.getParameter("mncode");
            System.out.println(!mncode.isEmpty()); // mncode가 비었는지 확인, 왜인지 null값은 아님
            ProductCRUD_Dao dao = new ProductCRUD_Dao();
            System.out.println(mnimg!=null);
            if(!mncode.isEmpty()) {
            	dao.updateAction(mnctg, mnname, mnengname, mninfo, mnprice, mncode);
            	if(mnimg !=null) dao.updateMnimg(mnimg, mncode);
            	System.out.println("수정 성공");
            }else {
            	dao.insertAction(mnctg, mnname, mnengname, mninfo, mnimg, mnprice);
            	System.out.println("입력 성공");
            }

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
