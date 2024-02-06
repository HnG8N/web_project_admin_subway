<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>제품 관리</title>
</head>
    <link href="css/home.css" rel="stylesheet" />
<section>
<%-- 	<c:import url="../sidebar/sidebar.jsp" />
 --%></section>
<body>
<div>
<h2>제품 등록</h2>
<br>
<img id = "img" />
<form action="productdb.do" name="product" id="product" method="post" enctype="multipart/form-data">
  <label for="name">제품코드:</label>
  <input type="text" id="mncode" name="mncode" readonly="readonly"><br>
  <br>
  <label for="mnctg">카테고리:</label>
  <input type="text" id="mnctg" name="mnctg"><br>
  <br>
  <label for="mnname">이름:</label>
  <input type="text" id="mnname" name="mnname"><br>
  <br>
  <label for="mnengname">영문명:</label>
  <input type="text" id="mnengname" name="mnengname"><br>
  <br>
  <label for="mninfo">상세 정보:</label><br>
  <textarea id="mninfo" name="mninfo" rows="10" cols="50"></textarea><br>
  <br>
  <label for="mnprice">가격:</label>
  <input type="text" id="mnprice" name="mnprice"><br>
  <br>
  <label for="mnimg">이미지:</label>
  <input type="file" id="mnimg" name="mnimg">
  <div id="image_container"></div>
  <button type="submit" name="insertBtn" id="insertBtn" value="insertBtn">입력</button>
</form>
</div>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="js/productcrud.js"></script>
</body>
</html>
