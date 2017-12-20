<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー登録</title>
</head>
<body>
	<header>
		<a href='<s:url action="GoHomeAction" />'>project1</a>
	</header>
	<div id="main">
		<div id="content">
			<p>新規ユーザー登録</p>
		</div>
		<br>

		<div class="user-create-form">
			<s:if test="userErrorMessage != ''">
				<div id="error-message">
					<s:property value="userErrorMessage" escape="false"/>
				</div>
			</s:if>
			<s:form action="UserCreateConfirmAction">
			<table>
				<tr id="box">
					<td>
						<label>ログインID:</label>
					</td>
					<td>
						<input type="text" name="loginUserId" value="">
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>ユーザー名:</label>
					</td>
					<td>
						<input type="text" name="userName" value="">
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>パスワード:</label>
					</td>
					<td>
						<input type="password" name="loginPassword" value="">
					</td>
				</tr>
				<s:submit value="登録"/>
				</table>
			</s:form>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>