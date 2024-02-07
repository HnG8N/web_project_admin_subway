package com.javalec.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.dao.ProductInsert_Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductInsert implements Command {

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
//            String mncode = multi.getParameter("mncode");
//            System.out.println(mncode);
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
            
            ProductInsert_Dao dao = new ProductInsert_Dao();
            dao.insertAction(mnctg, mnname, mnengname, mninfo, mnimg, mnprice);
            System.out.println("입력 성공");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
