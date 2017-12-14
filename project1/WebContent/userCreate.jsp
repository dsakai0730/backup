<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<header>project1</header>
	<h1>新規ユーザー登録</h1>
	<div>
		<s:if test="errorMessage != ''">
			<s:property value="errorMessage" escape="false"/>
		</s:if>
		<table>
			<s:form action="UserCreateConfirmAction">
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
						<label>ユーザー名</label>
					</td>
					<td>
						<input type="text" name="userName" value="">
					</td>
				</tr>
				<tr id="box">
					<td>
						<label>パスワード</label>
					</td>
					<td>
						<input type="password" name="loginPassword" value="">
					</td>
				</tr>
				<s:submit value="登録"/>
			</s:form>
		</table>
		</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>