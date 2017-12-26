<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録確認</title>
</head>
<body>
	<header><a href='<s:url action="GoHomeAction" />'>FavBooks</a></header>
	<div id="main">
		<h3>以下の内容で登録します。</h3>
		<div>
			<table>
				<s:form action="UserCreateCompleteAction">
					<tr id="box">
						<td>
							<label>ログインID:</label>
						</td>
						<td>
							<s:property value="loginUserId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ユーザー名:</label>
						</td>
						<td>
							<s:property value="userName" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ログインパスワード:</label>
						</td>
						<td>
							<s:property value="loginPassword" escape="false" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="完了" />
						</td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
</body>
</html>