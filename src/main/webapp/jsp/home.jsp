<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">
	.content {
	flex: 1; /* flex-grow: 1;과 같음 */
    }
</style>
</head>
<body>
<div>
	<c:import url="../headerfooter/header.jsp" />
</div>
<div>
	<h2 style="color:#000">시작 페이지 입니다!!!</h2>
</div>
<div>
	<c:import url="../headerfooter/footer.jsp" />
</div>
</body>
</html>