<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert to UserInfo</title>
</head>
<body>
	<!-- 파일 가져오기 -->
	<%@ include file="connection.jsp" %>
	<%
		// 폼에서 넘어온 자료 받기
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userBirthDate = request.getParameter("userBirthDate");
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createDate = formats.format(now);

		Statement stmt = null;
		
		try {
			String sql = "insert into dlrbqls3024_ts.userInfo(userPassword, userName, userAge, userBirthDate, createDate) values('"+userPassword+"','"+userName+"','"+userAge+"','"+userBirthDate+"','"+createDate+"')";
			stmt = connection.createStatement();
			// 삽입 수정 삭제는 update로 실행해준다
			stmt.executeUpdate(sql);
			out.print("Insert to userInfo was successful");
		} catch (SQLException e) {
			out.print("Insert Failed <br>");
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