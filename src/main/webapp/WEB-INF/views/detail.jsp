<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<td>${board.id}</td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${board.boardWriter}</td>
		</tr>
		<tr>
			<th>date</th>
			<td>${board.boardCreatedTime}</td>
		</tr>
		<tr>
			<th>hits</th>
			<td>${board.boardHits}</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${board.boardTitle}</td>
		</tr>
		<tr>
			<th>contents</th>
			<td>${board.boardContents}</td>
		</tr>
	</table>
</body>
</html>