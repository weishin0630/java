<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("max");
	Bike bike = new Bike();
	
	
	request.setAttribute("name",name);
	request.setAttribute("bike",bike);
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	I am brad21<br>
	<jsp:forward page="brad22.jsp"></jsp:forward>
	
	</body>
</html>