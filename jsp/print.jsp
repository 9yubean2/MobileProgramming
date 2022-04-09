<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>

<title>Print</title>
</head>
<body>
	<p> userInfo DB </p>
	<%@ include file="connection.jsp" %>
	
	<table width="800" border="1">
		<tr>
			<th> userNum </th>
			<th> userPassword </th>
			<th> userName </th>
			<th> userAge </th>
			<th> userBirthDate </th>
			<th> createDate </th>
		</tr>
		<%
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			
			try{
				String sql = "select * from userInfo";
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				while(rs.next()){
					Integer userNum = rs.getInt("userNum");
					String userPassword = rs.getString("userPassword");
					String userName = rs.getString("userName");
					Integer userAge = rs.getInt("userAge");
					String userBirthDate = rs.getString("userBirthDate");
					String createDate = rs.getString("createDate");
		%>
		<tr>
			<td><%= userNum %></td>
			<td><%= userPassword %></td>
			<td><%= userName %></td>
			<td><%= userAge %></td>
			<td><%= userBirthDate %></td>
			<td><%= createDate %></td>
		</tr>
		<%
					}
				} catch (SQLException e) {
					out.print("userInfo 테이블 호출에 실패 <br>");
					out.print("SQLException: " + e.getMessage());
				} finally {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (connection != null) connection.close();
				}
		%>
	</table>
</body>
</html>