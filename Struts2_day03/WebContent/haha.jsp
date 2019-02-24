<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:property value="user.userName"/>
	<s:property value="user.age"/>
	<form action="/t1.action" method="post">
		用户<input type="text" name="userName"><br>
		年龄<input type="text" name="age">
		<input type="submit" value="提交">
	</form>
</body>
</html>