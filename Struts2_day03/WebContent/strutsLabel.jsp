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
	<s:form>
		<s:textfield name="username" label="username"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:radio list="{'女','男'}" name="sex" label="性别"></s:radio>
		<s:radio list="#{'女':'nv','男':'nan'}" name="sex" label="性别"></s:radio>
		<s:checkboxlist list="{'吃饭','睡觉'}" name="like" label="爱好"></s:checkboxlist>
		<s:select list="{'幼儿园','大学'}" name="college" label="学历"></s:select>
		<s:file name="file" label="文件上传"></s:file>
		<s:hidden name="hid" value="abcd"></s:hidden>
		<s:textarea name="textarea" rows="2" clos="2" label="文本域"></s:textarea>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
</body>
</html>