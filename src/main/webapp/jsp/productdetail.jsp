<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${MENU }" />
<!DOCTYPE html>
<html>
<head>
<title>상품 관리</title>
</head>
	<style>
	#img {
	    width: 250px; /* 너비를 250px로 설정 */
	    height: auto; /* 높이를 auto로 설정 */
	    object-fit: contain;
	}
	#imgPreview {
	    width: 250px; /* 너비를 250px로 설정 */
	    height: auto; /* 높이를 auto로 설정 */
	    object-fit: contain;
	}
	</style>
    <link href="css/home.css" rel="stylesheet" />
<section>
<!-- 	<c:import url="../sidebar/sidebar.jsp" />
 --></section>
<body>
<div>
<h2>상품 등록</h2>
<br>
<img id = "img"  src="img/${dto.mnimg }" alt="..."/>
<form action="productcrud.do" name="product" id="product" method="post" enctype="multipart/form-data" class="product">
	<label for="name">제품코드:</label>
	<input type="text" id="mncode" name="mncode" readonly="readonly" value="${dto.mncode }" placeholder="상품코드는 자동으로 입력됩니다." size="25"><br>
	<br>
	<label for="mnctg">카테고리:</label>
	<input type="text" id="mnctg" name="mnctg" value="${dto.mnctg }" placeholder="카테고리를 입력해주세요."><br>
	<br>
	<label for="mnname">이름:</label>
	<input type="text" id="mnname" name="mnname" placeholder="한글명을 입력해주세요. (&과 공백 가능)" value="${dto.mnname }" size="30"><br>
	<br>
	<label for="mnengname">영문명:</label>
	<input type="text" id="mnengname" name="mnengname" placeholder="영문명을 입력해주세요. (&과 공백 가능)" value="${dto.mnengname }" size="30"><br>
	<br>
	<label for="mninfo">상세정보:</label><br>
	<textarea id="mninfo" name="mninfo" rows="10" cols="50" placeholder="상세정보를 입력해주세요.">${dto.mninfo }</textarea><br>
	<br>
	<label for="mnprice">가격:</label>
	<input type="text" id="mnprice" name="mnprice" placeholder="가격을 입력해주세요. (숫자만 가능)" value="${dto.mnprice }" size="30"><br>
	<br>
	<label for="mnimg">이미지:</label>
	<input type="file" id="mnimg" name="mnimg" onchange="previewImage(event)"><br>
	<img id="imgPreview" src="img/cat1.png" alt="이미지를 등록 해주세요."/>
	<button type="submit" name="insertBtn" id="insertBtn" value="insertBtn">입력</button>
</form>
</div>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="js/productdetail.js"></script>
</body>
</html>