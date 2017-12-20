<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HOME</title>
</head>
<body>
	<div id="main">
		<div id="search-form">
			<h1>Search Books!</h1>
			<div id="search-box">
				<s:form action="SearchAction">
					<input type="text" name="searchWord" />
					<s:submit value="検索" />
				</s:form>
			</div>
			<br>
			<s:if test="session.testDTOList != null">
				<s:iterator value="session.testDTOList">
					<s:iterator value="idList">
						<s:property />
					</s:iterator>
				</s:iterator>
			</s:if>
		</div>
	</div>
</body>
</html>