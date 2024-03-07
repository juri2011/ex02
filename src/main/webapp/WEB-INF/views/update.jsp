<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<form action="/board/update" method="post" name="updateForm">
		<!-- DB와 컬럼명과 맞췄다. (DTO, VO와도 이름을 맞출 에정이다.) -->
		아이디 : <input type="text" name="id" value="${board.id}" readonly/><br /><br />
		작성자 : <input type="text" name="boardWriter" value="${board.boardWriter}" readonly /><br /><br />
		비밀번호 : <input type="text" name="boardPass" id="boardPass" placeholder="비밀번호"/><br /><br />
		<input type="text" name="boardTitle" value="${board.boardTitle}" /><br /><br />
		<!-- dto의 변수와 이름이 다르면 DB에 등록되지 않는다. -->
		<textarea name="boardContents" cols="22" rows="10">${board.boardContents}</textarea><br /><br />
		<input type="button" value="수정" onclick="updateReqFn()"/>
	</form>
</body>
<script>
	const updateReqFn = () => {
		const passInput = document.getElementById('boardPass').value;
		const passDB = '${board.boardPass}';
		if(passInput == passDB){
			document.updateForm.submit();
		}else{
			alert('비밀번호가 일치하지 않습니다!');
		}
		
	}
</script>
</html>