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
<!-- 使用ognl和struts2标签实现计算字符串长度value属性值 -->
	<s:property value="'haha'.length()"/>
	<!-- 使用struts2标签查看值栈结构 -->
	<s:debug></s:debug>
	
	
</body>
</html>