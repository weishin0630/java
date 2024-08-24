<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Locale"%>
<%
	System.out.println(request.getMethod());
	//if(!request.getMethod().equals("POST"))response.sendError(405);

	String account=request.getParameter("account");
	String[] hobby=request.getParameterValues("hobby");
	System.out.println(hobby.length);
	//request.getRemoteAddr(); //取得ip位置
	Locale loc=request.getLocale();
	loc.getDisplayLanguage();
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Hobby withbrad27</title>
	</head>
	<body>
		Method: ${pageContext.request.method}<br>
	
		1.${paramValues.hobby[0] }<br>
		2.${paramValues.hobby[1] }<br>
		3.${paramValues.hobby[2] }<br>
		4.${paramValues.hobby[3] }<br>
		5.${paramValues.hobby[4] }<br>
		<hr>
		${pageContext.request.remoteAddr }<br>
		${pageContext.request.locale}<br>
		${pageContext.request.locale.displayLanguage}<br>
		
		
		
		
		
	</body>
</html>