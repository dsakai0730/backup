<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<h3>ログイン画面</h3>

<s:form action="LoginAction">
	<s:textfield name="username"/>
	<s:password name="password" />
	<s:submit value="ログイン"/>
</s:form>

</body>
</html>