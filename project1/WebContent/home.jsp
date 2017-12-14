<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>HOME</title>
</head>
<body>
	<header>project1</header>
	<s:if test="loginUserId == null">
	<ul>
		<li>ゲストさん</li>
		<li><a href='<s:url action="LoginPageAction" />' >ログイン</a></li>
		<li><a href='<s:url action="UserCreatePageAction" /> '>新規ユーザー登録</a></li>
	</ul>
	</s:if>
	<div>
		<s:if test="loginUserId != null">
			<ul>
				<li><s:property value="session.userName" />さん</li>
				<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
				<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
			</ul>
		</s:if>
	</div>
	<div id="main">
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>