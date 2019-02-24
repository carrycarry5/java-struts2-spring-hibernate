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
	<s:debug></s:debug>
	<!-- 获取字符串的值 -->
	<s:property value="username"/>
	<br>
	<hr>
	<!-- 获取值栈中对象的值 -->
	<s:property value="user."/>
	<s:property value="user.userName"/>
	<br>
	<hr>
	<!-- 获取值栈中list集合 -->
	<!-- 第一张方式（会用） -->
	<s:property value="list[0].userName"/>
	<s:property value="list[0].age"/>
	<hr>
	<!-- 第二张方式 -->
	<s:iterator value="list">
		<!-- 遍历list里面的每个user对象 -->
		<s:property value="userName"/>
		<s:property value="age"/>
	</s:iterator>
	<hr>
	<!-- 第三张方式 -->
	<s:iterator value="list" var="user">
		<!-- 
			遍历值栈list集合，得到每个user对象
			机制：把每次遍历出来的user对象放到context对象里面
			使用#来获取context里面的值
		 -->
		<s:property value="#user.userName"/>
	</s:iterator>
	
	<!-- el和jstl -->
	
	<s:textfield name="userName" value="%{#request.req}"></s:textfield>
	
</body>
</html>