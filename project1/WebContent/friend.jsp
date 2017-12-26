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
			<p>フォロー</p>
		</div>
		<br>
		<p id="mypage-list">ユーザーを探す</p>
		<div id="search-form">
			<s:form action="SearchFriendAction">
				<input id ="search-box" type="text" name="friendId" placeholder="ユーザーのID">
				<s:submit value="検索" />
			</s:form>
		</div>

		<s:if test="session.searchFriendId != null ">

			<s:if test="session.retMessage == '検索結果がありません' ">
				<div id="search-result-false">
					<s:property value="retMessage"/>
				</div>
			</s:if>

			<s:if test="session.retMessage != '検索結果がありません' ">
				<div id="search-result">検索結果
					<br>
					<div id="searched-user">
							<a href = '<s:url action = "FriendInfoAction" />' ><s:property value="session.searchFriendName"/>&nbsp;さん</a>
					</div>
				</div>
			</s:if>

		</s:if>
		<p id="mypage-list"><s:property value="session.userName" />&nbsp;さんのフォローリスト</p>

			<s:if test="session.flexistMessage == 'exist' ">
				<div id="follow-box">
					<s:iterator value="session.followList" status="stat">
						<div id="follow-list">
							<a href = '<s:url action = "FollowerInfoAction" ><s:param name="flCheckNum" value="#stat.index" /></s:url>' ><s:property value="followUserName"/>&nbsp;さん</a>
							<br>
						</div>
					</s:iterator>
				</div>
			</s:if>

			<s:if test="session.flexistMessage == 'none'">
				<div id="follow-box-none">フォローしているユーザーがいません</div>
			</s:if>
		</div>
		<footer>copyright daichi sakai</footer>

</body>
</html>