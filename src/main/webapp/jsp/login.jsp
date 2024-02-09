<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div>
	<c:import url="../headerfooter/header.jsp" />
</div>
<div>
	<h2 style="color:#000">Login</h2>
</div>
<div>
	<form action="home.do" method="post" id="loginForm" name="loginForm">
		ID : <input type="text" id="loginID" name="loginID"><br>
		<br>
		PW : <input type="text" id="loginPW" name="loginPW"><br>
		<br>
		<input type="button" name="loginBtn" id="loginBtn" value="Login" >
	</form>
<br>
<br>
</div>
<div>
	<c:import url="../headerfooter/footer.jsp" />
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="js/login.js"></script>
</html>