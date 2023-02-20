<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <h1>게시글 목록</h1>
    


<table>
<tr>

<td>글번호</td>
<td>제목</td>
<td>작성자</td>
<td>작성시간</td>
<td>조회수</td>
</tr>
	    <c:forEach items="${boardlist }" var="vo" varStatus="s">
	    <c:set target="${vo }" property="boardTitle" value="aaa"/>
		
		
		<c:if test="${s.count%2 == 1 }">

		</c:if>
		
		<c:if test="${s.count%2 == 0 }">
		<tr>
		</c:if>
		<tr>
			<td>&nbsp; ${vo.boardNum }: ${s.count }: ${s.index }</td>
			<td>${vo.boardTitle }</td>
			<td>&nbsp;&nbsp; ${vo.boardWriter}</td>
			<td>&nbsp;&nbsp; ${vo.boardDate }</td>
			<td>&nbsp;&nbsp; ${vo.boardReadcount }</td>
		</tr>	
	</c:forEach>
</table>

<div>

페이지처리

</div>





</section>