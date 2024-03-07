<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>save</title>
</head>
<body>
	<form action="/board/save" method="post">
		<!-- DB와 컬럼명과 맞췄다. (DTO, VO와도 이름을 맞출 에정이다.) -->
		<input type="text" name="boardWriter" placeholder="작성자" /><br /><br />
		<input type="text" name="boardPass" placeholder="비밀번호"/><br /><br />
		<input type="text" name="boardTitle" placeholder="제목" /><br /><br />
		
		<textarea name="boardContent" cols="22" rows="10" placeholder="내용을 입력하세요" ></textarea><br /><br />
		<input type="submit" value="작성" />
	</form>
</body>
</html>