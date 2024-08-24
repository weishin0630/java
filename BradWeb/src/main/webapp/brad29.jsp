<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    
<%
	String[] names1={"BRAD","Mark","Joe","Kevin"};
	pageContext.setAttribute("names1", names1);
	
	LinkedList<String> list=new LinkedList<>();
	pageContext.setAttribute("list",list);
	list.add("BRAD1");
	list.add("Mark1");
	list.add("Joe1");
	list.add("Kevin1");
	
	HashMap<String,Object>map=new HashMap<>();
	pageContext.setAttribute("map",map);
	map.put("1","Brad1");
	map.put("2","male");
	map.put("3","20");
	
	
%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		names1[2]= ${names1[2] }<br>
		list[1]=${list[2]}<br>
		${map}
		
	
	</body>
</html>