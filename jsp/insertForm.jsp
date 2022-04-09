<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Enter User Form</title>
</head>
<body>
	<h2> New User </h2>

	<form action="insert.jsp" method="post">
		<p> Name : <input type="text" name="userName">
		<p> Password : <input type="password" name="userPassword">
		<p> Age : <input type="number" name="userAge">
		<p> BirthDate : <input type="date" name="userBirthDate">	
		<p> <input type="submit" value="전송">
	</form>
	
</body>
</html>