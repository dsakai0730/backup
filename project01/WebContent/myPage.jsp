<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>MYPAGE</title>
</head>
<body>
	<header><a href='<s:url action="GoHomeAction" />'>FavBooks</a>
		<ul>
			<li><s:property value="session.userName" />さん</li>
			<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
			<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
		</ul>
	</header>
	<div id="main">
		<div id="content">
			<p><s:property value="session.userName" />さんのマイページ</p>
		</div>
		<br>
		<div id="register-item">
			<p><a href = '<s:url action = "RegItemPageAction" />' >商品登録画面へ</a></p>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>