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
		String url="jdbc:mysql://sc1.swu.ac.kr:13306/dlrbqls3024_ts";
		String user="dlrbqls3024";
		String password="dlrbqls302485";
		
		Class.forName("org.mariadb.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
	%>
</body>
</html>