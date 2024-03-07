<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paging</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>writer</th>
			<th>date</th>
			<th>hits</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>
					<!-- 여기서는 page 값까지 상세페이지에 넘긴다.(paging은 BoardControl에서 받아올 예정) -->
					<a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a>
				</td>
				<td>${board.boardWriter}</td>
				<td>${board.boardCreatedTime}</td>
				<td>${board.boardHits}</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 조건에 따라 출력하며, 조건에 맞지 않는 경우까지 처리할 수 있음 -->
	<c:choose>
		<%-- 현재 페이지가 1페이지면 이전 글자만 보인다. --%>
		<c:when test="${paging.page <= 1}">
			<span>[이전]</span>
		</c:when>
		<%-- 1페이지가 아닌 경우 [이전]을 클릭하면 1 이전의 페이지로 이동한다. --%>
		<c:otherwise>
			<a href="/board/paging?page=${paging.page-1}">[이전]</a>
		</c:otherwise>
	</c:choose>
	
	<!-- java에서의 for문(페이지 시작부터 페이지끝까지 순회) i는 페이지 수 -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<%-- 현재페이지는 링크가 적용되지 않음 --%>
			<c:when test="${i eq paging.page}">
				<span>${i}</span>
			</c:when>
			<%-- 다른 페이지는 클릭시 해당 페이지로 이동 --%>
			<c:otherwise>
				<a href="/board/paging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<!-- 다음버튼 -->
	<c:choose>
		<%-- 현재 페이지가 마지막 페이지라면 다음 링크 비활성화 --%>
		<c:when test="${paging.page>=paging.maxPage}">
			<span>[다음]</span>
		</c:when>
		<%-- 마지막 페이지가 아니라면 다음 링크 활성화 --%>
		<c:otherwise>
			<a href="/board/paging?page=${paging.page+1}">[다음]</a>
		</c:otherwise>
	</c:choose>
</body>
</html>