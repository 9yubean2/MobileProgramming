<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>

<title>Delete</title>
</head>
<body>
	<%@ include file="connection.jsp" %>
	<%
		request.setCharacterEncoding("utf-8");

		int userNum = Integer.parseInt(request.getParameter("userNum"));
		//String userPassword = request.getParameter("userPassword");
		//String userName = request.getParameter("userName");
		
		Statement stmt = null;
		
		try {
			String sql = "delete from userInfo where userNum='"+userNum+"'";
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			out.print("Delete userNum: "+userNum+" Data");
		} catch (SQLException e){
			out.print(e.getMessage());
		} finally {
			if (stmt != null) stmt.close();
			if (connection != null) connection.close();
		}
	%>
</body>
</html>