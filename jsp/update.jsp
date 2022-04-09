<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>

<title>Update Table</title>
</head>
<body>
	<%@ include file="connection.jsp" %>
	<%
		// 폼에서 넘어온 자료 받기 
		request.setCharacterEncoding("utf-8");
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userBirthDate = request.getParameter("userBirthDate");
		
		
		Statement stmt = null;
		
		try {
			String sql = "Update userInfo set userPassword='"+userPassword+"', userName='"+userName+"', userAge='"+userAge+"', userBirthDate='"+userBirthDate+"' where userNum='"+userNum+"'";
			
			stmt = connection.createStatement();
			int n = stmt.executeUpdate(sql);
			

			out.print("Update userInfo");
		} catch (SQLException e) {
			out.print("Fail to update userInfo <br>");
			out.print("SQLException: " + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	%>
</body>
</html>