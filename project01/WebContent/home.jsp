<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>HOME</title>
</head>
<body>
	<header><a href='<s:url action="GoHomeAction" />'>project1</a>
		<s:if test="session == null">
		<ul>
			<li>ゲストさん</li>
			<li><a href='<s:url action="LoginPageAction" />' >ログイン</a></li>
			<li><a href='<s:url action="UserCreatePageAction" /> '>新規ユーザー登録</a></li>
		</ul>
		</s:if>
		<s:if test="session.loginUserId == null">
		<ul>
			<li>ゲストさん</li>
			<li><a href='<s:url action="LoginPageAction" />' >ログイン</a></li>
			<li><a href='<s:url action="UserCreatePageAction" /> '>新規ユーザー登録</a></li>
		</ul>
		</s:if>
		<s:if test="session.loginUserId != null">
			<ul>
				<li><s:property value="session.userName" />さん</li>
				<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
				<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
			</ul>
		</s:if>
	</header>
	<div id="main">
		<div id="search-form">
			<h1>Search Books!</h1>
			<div id="search-box">
				<s:form action="SearchBookAction">
					<input type="text" name="searchWord" />
					<s:submit value="検索" />
				</s:form>
			</div>
			<br>
			<s:if test="session.id != null">
				
					<img src="<s:property value="session.img" />" />
					<ul>
					<li>タイトル:<s:property value="session.title" /></li>
					<li>著者:
					<s:iterator value="authorsList">
						<s:property />
					</s:iterator>
					</li>
					<li>出版日:<s:property value="session.publishedDate" /></li>
					<li>説明:<s:property value="session.description" /></li>
					</ul>
			</s:if>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>