<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
	<header>project1</header>
	<div id="main">
		<h1>ログイン画面</h1>
			<div>
				<table>
					<s:form action="LoginAction">
						<tr>
							<td>
								<label>ユーザーID:</label>
							</td>
							<td>
								<s:textfield name="loginUserId" />
							</td>
						</tr>
						<tr>
							<td>
								<label>パスワード:</label>
							</td>
							<td>
								<s:password name="loginPassword" />
							</td>
						</tr>
						<tr>
							<s:submit value="ログイン"/>
						</tr>
					</s:form>
				</table>
			</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>