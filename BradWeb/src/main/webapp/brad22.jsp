<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=(String)request.getAttribute("name");
	Bike bike = (Bike)request.getAttribute("bike");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	i am brad22<hr>
	Welcome,<%= name %>
	Bike speed=<%=bike.getSpeed() %>
	
	</body>
</html>