<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>FRIEND</title>
</head>
<body>
	<header><a href='<s:url action="GoHomeAction" />'>FavBooks</a>
		<ul>
			<li><s:property value="session.userName" />さん</li>
			<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
			<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
			<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
		</ul>
	</header>
	<div id="main">
		<div id="content">
			<p>フレンド</p>
		</div>
		<br>
		<s:form action="SearchFriendAction">
			<input type="text" name="friendId" placeholder="フレンドのID">
			<s:submit value="検索" />
		</s:form>

		<s:if test="session.searchFriendName != null">
			<p>検索結果</p>
				<a href = '<s:url action = "FriendInfoAction" />' ><s:property value="session.searchFriendName"/>さん</a>
		</s:if>
		<p id="mypage-list"><s:property value="session.userName" />さんのフレンドリスト</p>

		<footer>copyright daichi sakai</footer>
	</div>
</body>
</html>