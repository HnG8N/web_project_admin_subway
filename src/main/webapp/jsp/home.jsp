<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminHome</title>
    <link href="../css/home.css" rel="stylesheet" />
</head>
<body>
<section>
	<c:import url="../sidebar/sidebar.jsp" />
</section>
<div>
	<p><h2>판매 현황</h2>
</div>
 <div>
	<canvas id="myChart" width = 300 height = 100></canvas>
</div>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="../js/barchart.js"></script>
</body>
</html>