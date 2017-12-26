<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>LOGIN</title>
</head>
<body>
	<header><a href='<s:url action="GoHomeAction" />'>FavBooks</a>
		<ul>
			<li>ゲストさん</li>
			<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
		</ul>
	</header>
	<div id="main">
		<div id="content">
			<p>ログイン画面</p>
		</div>
		<br>
		<div class="login-form">
			<s:form action="LoginAction">
				<table>
					<tr>
						<td>
							<label>ユーザーID:</label>
						</td>
						<td>
							<input type="text" name="loginUserId" />
						</td>
					</tr>
					<tr>
						<td>
							<label>パスワード:</label>
						</td>
						<td>
							<input type="password" name="loginPassword" />
						</td>
					</tr>
					<tr>
						<s:submit value="ログイン"/>
					</tr>
				</table>
			</s:form>
		</div>
		<footer>copyright daichi sakai</footer>
	</div>
</body>
</html>