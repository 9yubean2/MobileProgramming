<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Search User By JSON</title>
</head>
<body>
	<h2> Search User By JSON </h2>

	<form action="selectprint_json.jsp" method="post">
		<p> Name : <input type="text" name="userName_json" placeholder='{"name":"Write the name you are looking for"}' style="width:300px;">
		<p> <input type="submit" value="전송">
	</form>
	
</body>
</html>