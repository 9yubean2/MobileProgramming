<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!-- 1. 임포트 하기 -->
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Connection</title>
</head>
<body>
	<%
		// 연결하기
		Connection connection = null;
		String url="db url";
		String user="db id";
		String password="db pw";
		
		Class.forName("org.mariadb.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
	%>
</body>
</html>
