<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	#title{
		text-align: center;
	}
    .container {
		display: flex;
		justify-content: space-between; /* 요소를 컨테이너의 양 끝에 정렬합니다. */
		align-items: center; /* 요소를 수직 가운데로 정렬합니다. */
    }
	.search-container {
		display: inline-block; /* 인라인 블록 요소로 설정하여 다른 요소와 함께 한 줄에 배치될 수 있도록 합니다. */
		vertical-align: middle; /* 수직 정렬을 가운데로 설정합니다. */
    }
    #selectSearch, #search {
		margin-right: 10px; /* 입력 요소 간에 간격을 설정합니다. */
    }
	#insertBtnForm {
		margin-left: auto; /* 검색 버튼을 맨 오른쪽에 배치합니다. */
	}
  </style>
<!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
 -->  
</head>
<body>
<!-- 	
<div>
<c:import url="../sidebar/sidebar.jsp" />
</div>
 -->
<h2 id="title">상품 리스트</h2><br>
<div class="container">
	 	<select name="selectSearch" id="selectSearch">
	 		<option value="nameSearch">이름(영문명 가능)</option>
			<option value="codeSearch">상품코드</option>
	 	</select>
	 	<input type="text" name="search" id="search">
	 	<input type="button" id="searchBtn" name="searchBtn" value="검색">
	 	<form action="productdetail.do" method="post" id="insertBtnForm">
	 	<input type="submit" id="insertBtn" name="insertBtn" value="새 상품 등록"> <!-- 새 상품 등록 버튼 -->
	 	</form>
	 	<br>
	 	<br>
</div>
<!-- 		
		<c:forEach var="dtos" items="${LIST }">
	        <div class="card">
	          <table style="width: 100%;">
	          	<tr>
	 			<td style="width: 10%;"><img src="img/${dtos.mnimg }" class="card-img-top" alt="..." ></td>
	          	<td style="width: 5%;">${dtos.mncode }</td> <td style="width: 5%;">${dtos.mnctg }</td> <td style="width: 5%;">${dtos.mnname }</td>
	          	<td style="width: 5%;">${dtos.mnengname }</td> <td style="width: 50%;">${dtos.mninfo }</td> <td style="width: 10%;">${dtos.mnprice }</td>
	            <td style="width: 10%;"><a href="productcrud.do?mncode=${dtos.mncode }" class="btn btn-primary">자세히 보기</a></td>
	          	</tr>
	          </table>
	          </div>
	 	  </c:forEach>
 -->       
<div id="result"></div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="js/ProductList.js"></script>
</html>