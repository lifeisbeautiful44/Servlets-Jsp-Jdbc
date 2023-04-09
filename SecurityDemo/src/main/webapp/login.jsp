<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<form action="j_security_check" method="post">

		UserName: <input name="j_username" /> <br /> 
		Password: <input type="password" name="j_password"> 
			<input type="submit"value="submit">

	</form>

</body>
</html>