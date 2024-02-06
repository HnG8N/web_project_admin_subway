<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>상품 리스트</title>
   <link href="css/home.css" rel="stylesheet" />
   <link href="css/productlist.css" rel="stylesheet">
  <style>
	.card {
	  display: flex;
	  align-items: center;
	}
  </style>
<!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
 -->  
</head>
<body>
<div>
<%-- 	<c:import url="../sidebar/sidebar.jsp" />
 --%></div>
<div>
	<div class="container">
	 <p><h2>상품 리스트</h2>
       <div class="row">
		<c:forEach var="list" items="1, 2, 3, 4, 5, 6, 7, 8, 9, 10">
	      <div class="col">
	        <div class="card">
	          <img src="img/cat1.png" class="card-img-top" alt="..." >
	          	제품코드, 카테고리, 이름, 영문명, 상세정보, 가격
	            <a href="#" class="btn btn-primary">자세히 보기</a>
	          </div>
	        </div>
	 	  </c:forEach>
		 </div>
       </div>
    </div>
</body>
</html>