<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/register" method="post">
		<table align="center" border="1" cellspacing="0" >
			<tr>
				<td>用户名(邮箱地址)：<input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密    码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="password"/></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="立即注册" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>